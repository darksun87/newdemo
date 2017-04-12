package com.crm.biz;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.log4j.Logger;
import com.crm.data.MapperFactory;

import com.crm.dao.CertificateMapper;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.crm.model.QueryResult;
import com.crm.model.Certificate;
import com.crm.model.CertificateQuery;
import static com.crm.biz.util.ValidationUtil.*;

@Service("certificateBiz")
public class CertificateBiz {


	private static final Logger LOGGER = Logger.getLogger(CertificateBiz.class);

	@Resource
	private MapperFactory mapperFactory;
	
		public Message<Integer> deleteCertificate(Integer id,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			CertificateMapper certificateMapper  = mapperFactory.getMapperForMaster(CertificateMapper.class);
			int result = certificateMapper.logicalDeleteByPrimaryKey(id,operatorId,System.currentTimeMillis());
			
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除Certificate失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Integer> createCertificate(Certificate certificate){
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate( certificate, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			CertificateMapper certificateMapper = mapperFactory.getMapperForMaster(CertificateMapper.class);
									certificate.setCreateTime(System.currentTimeMillis());			certificateMapper.insert( certificate );
			mapperFactory.commitTransaction();
			message.setData(certificate.getId());

		} catch (Exception e) {
			LOGGER.error("createCertificate,创建Certificate失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForCreate(Certificate certificate, Message<?> message) {
								    		        		        		
        		if (isMoreThan(message, Certificate.CERTIFICATENAME, certificate.getCertificatename(), 100)) {
        			return false;
        		}	
        		    								    		        		    								    		        		    																																return true;
	}
	public Message<Integer> updateCertificate(Certificate certificate){
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(certificate, message)) {
            return message;
        }
		try {
			CertificateMapper certificateMapper = mapperFactory.getMapperForMaster(CertificateMapper.class);
			mapperFactory.beginTransaction();
			
			Certificate certificateLast = certificateMapper.selectByPrimaryKeyForUpdate( certificate.getId() );
			if( certificateLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									certificate.setUpdateTime(System.currentTimeMillis());			int result = certificateMapper.updateByPrimaryKey( certificate );
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateCertificate,更新Certificate失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForUpdate(Certificate certificate, Message<?> message) {
       				if (isNull(message,Certificate.ID, certificate.getId())) {
			return false;
		}
			   				if (isMoreThan(message, Certificate.CERTIFICATENAME, certificate.getCertificatename(), 100)) {
			return false;
		}	
			   			   			   			   			   			   			   			   			   		return true;
    }
		public Message<Integer> changeStatus(Integer id,Byte status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			
			CertificateMapper certificateMapper = mapperFactory.getMapperForMaster(CertificateMapper.class);
			mapperFactory.beginTransaction();
			Certificate certificateLast = certificateMapper.selectByPrimaryKeyForUpdate(id );
			if( certificateLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
			//TODO：其他判断
			
			int result = certificateMapper.changeStatus(id,status,operatorId,System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("changeStatus,更新Certificate状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;
	}
		public Message<Certificate> getCertificate( Integer id ){
		Message<Certificate> message = new Message<Certificate>();
		try {
			CertificateMapper certificateMapper = mapperFactory.getMapperForSlave(CertificateMapper.class);
			Certificate certificate = certificateMapper.selectByPrimaryKey( id );
			message.setData(certificate);

		} catch (Exception e) {
			LOGGER.error("getCertificate,根据主键查询Certificate失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Certificate>> getAllCertificate(){
	
		Message<List<Certificate>> message = new Message<List<Certificate>>();
		try {
			CertificateMapper certificateMapper = mapperFactory.getMapperForSlave(CertificateMapper.class);
				
			List<Certificate> certificateList = certificateMapper.selectAll();
			message.setData( certificateList);
		} catch (Exception e) {
			LOGGER.error("getAllCertificate,查询全部Certificate失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<Certificate>> queryCertificate(CertificateQuery certificateQuery) {
		Message<QueryResult<Certificate>> message = new Message<QueryResult<Certificate>>();
		try {
			CertificateMapper certificateMapper = mapperFactory.getMapperForSlave(CertificateMapper.class);
			QueryResult<Certificate> queryResult = new QueryResult<Certificate>();
			PageHelper.startPage(certificateQuery.getPageIndex(), certificateQuery.getPageSize());
			List<Certificate> certificateList = certificateMapper.queryCertificate(certificateQuery);
			PageInfo<Certificate> pageInfo = new PageInfo<Certificate>(certificateList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(certificateList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryCertificate,分页查询Certificate失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}