package com.crm.data;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.StringUtils;
import org.springframework.util.StringValueResolver;


public class MapperFactory implements InitializingBean, ApplicationContextAware {
	private final static Logger logger = Logger.getLogger(MapperFactory.class);

	private ApplicationContext masterApplicationContext;
	private ApplicationContext slaveApplicationContext;
	private PlatformTransactionManager tranactionManager;
	private String masterConfigLoation;
	private String slaveConfigLoation;

	public MapperFactory() {
	}

	public MapperFactory(String masterConfigLoation, String slaveConfigLoation) {
		this.setMasterConfigLoation(masterConfigLoation);
		this.setSlaveConfigLoation(slaveConfigLoation);
		startSubApplicationContext();
	}

	public String getMasterConfigLoation() {
		return masterConfigLoation;
	}

	public void setMasterConfigLoation(String masterConfigLoation) {
		this.masterConfigLoation = masterConfigLoation;
	}

	public String getSlaveConfigLoation() {
		return slaveConfigLoation;
	}

	public void setSlaveConfigLoation(String slaveConfigLoation) {
		this.slaveConfigLoation = slaveConfigLoation;
	}

	public <T> T getMapperForMaster(Class<T> type) {
		// return masterBeanFactory.getBean(type);
		T t = masterApplicationContext.getBean(type);
		if (t == null) {
			logger.error("no bean found for type " + type.getName());
		}
		return t;
	}

	public <T> T getMapper(Class<T> type) {
		return getMapperForMaster(type);
	}

	public <T> T getMapperForSlave(Class<T> type) {
		T t = slaveApplicationContext.getBean(type);
		if (t == null) {
			logger.error("no bean found for type " + type.getName());
		}
		return t;
	}

	private final static ThreadLocal<CounterTransactionStatus> transactionstatusLocal = new ThreadLocal<CounterTransactionStatus>();

	private final static DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	static {
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		// def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
	}

	public TransactionStatus beginTransaction() {
		return beginTransaction(def);
	}

	/**
	 * @param definition
	 * @return
	 */
	public TransactionStatus beginTransaction(DefaultTransactionDefinition definition) {
		CounterTransactionStatus counterTransactionStatus = transactionstatusLocal.get();
		if (counterTransactionStatus == null) {
			counterTransactionStatus = new CounterTransactionStatus(tranactionManager.getTransaction(definition));
			transactionstatusLocal.set(counterTransactionStatus);
		}
		counterTransactionStatus.inreaseCounter();
		return counterTransactionStatus.getTransactionStatus();
	}

	public void commitTransaction() {
		CounterTransactionStatus counterTransactionStatus = transactionstatusLocal.get();
		if (counterTransactionStatus == null) {
			return;
		}
		if (counterTransactionStatus.getCounter() < 2) {
			TransactionStatus transactionStatus = counterTransactionStatus.getTransactionStatus();
			if (!transactionStatus.isCompleted()) {
				tranactionManager.commit(transactionStatus);
			}
			transactionstatusLocal.remove();
		}
	}

	public void commitTransaction(TransactionStatus transactionStatus) {
		if (transactionStatus != null) {
			if (!transactionStatus.isCompleted()) {
				tranactionManager.commit(transactionStatus);
			}
			transactionstatusLocal.remove();
		}
	}

	public void rollbackTransaction() {
		try {
			CounterTransactionStatus counterTransactionStatus = transactionstatusLocal.get();
			if (counterTransactionStatus == null) {
				return;
			}
			counterTransactionStatus.decreaseCounter();
			if (counterTransactionStatus.getCounter() == 0) {
				TransactionStatus transactionStatus = counterTransactionStatus.getTransactionStatus();
				if (!transactionStatus.isCompleted()) {
					tranactionManager.rollback(transactionStatus);
				}
				transactionstatusLocal.remove();
			}

		} catch (Exception e) {
			logger.error("rollbackTransaction,回滚事务失败", e);
		}
	}

	// @Override
	// public void onApplicationEvent(ApplicationEvent event) {
	// if (event instanceof ContextRefreshedEvent) {
	// masterApplicationContext = buildApplicationContext(masterConfigLoation);
	// slaveApplicationContext = buildApplicationContext(slaveConfigLoation);
	// }
	// }

	private ApplicationContext buildApplicationContext(String configLocation) {
		logger.info("buildApplicationContext" + configLocation);
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { configLocation },
				parentApplicationContext);
		return appContext;
	}

	protected void doProcessProperties(ConfigurableListableBeanFactory beanFactoryToProcess,
			StringValueResolver valueResolver) {

		BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);

		String[] beanNames = beanFactoryToProcess.getBeanDefinitionNames();
		for (String curName : beanNames) {
			BeanDefinition bd = beanFactoryToProcess.getBeanDefinition(curName);
			try {
				visitor.visitBeanDefinition(bd);
			} catch (Exception ex) {
				throw new BeanDefinitionStoreException(bd.getResourceDescription(), curName, ex.getMessage(), ex);
			}

		}

		// New in Spring 2.5: resolve placeholders in alias target names and
		// aliases as well.
		beanFactoryToProcess.resolveAliases(valueResolver);

		// New in Spring 3.0: resolve placeholders in embedded values such as
		// annotation attributes.
		beanFactoryToProcess.addEmbeddedValueResolver(valueResolver);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (masterApplicationContext == null) {
			startSubApplicationContext();
		}
	}

	private void startSubApplicationContext() {
		if (StringUtils.hasLength(masterConfigLoation)) {
			logger.info("startSubApplicationContext,初始化Master数据容器开始");
			masterApplicationContext = buildApplicationContext(masterConfigLoation);
			logger.info("startSubApplicationContext,初始化Master数据容器完成");
			tranactionManager = masterApplicationContext.getBean(PlatformTransactionManager.class);
		}
		if (StringUtils.hasLength(slaveConfigLoation)) {
			logger.info("startSubApplicationContext,初始化Slave数据容器开始");
			slaveApplicationContext = buildApplicationContext(slaveConfigLoation);
			logger.info("startSubApplicationContext,初始化Slave数据容器完成");
		}
	}

	private ApplicationContext parentApplicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.parentApplicationContext = applicationContext;
	}

	// private DefaultListableBeanFactory buildBeanFactory(BeanFactory
	// parentBeanFactory, String configLocation) {
	//
	// DefaultListableBeanFactory beanFactory = new
	// DefaultListableBeanFactory(parentBeanFactory);
	// try {
	// ResourcePatternResolver resourceloader = new
	// PathMatchingResourcePatternResolver();
	// Resource[] res = resourceloader.getResources(configLocation);
	// XmlBeanDefinitionReader reader = new
	// XmlBeanDefinitionReader(beanFactory);
	// reader.loadBeanDefinitions(res);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return beanFactory;
	// }
}
