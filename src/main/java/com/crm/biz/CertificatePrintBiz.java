package com.crm.biz;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.log4j.Logger;
import com.crm.data.MapperFactory;

import com.crm.dao.CertificatePrintMapper;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.crm.model.QueryResult;
import com.crm.model.CertificatePrint;
import com.crm.model.CertificatePrintQuery;
import static com.crm.biz.util.ValidationUtil.*;

@Service("certificatePrintBiz")
public class CertificatePrintBiz {


	private static final Logger LOGGER = Logger.getLogger(CertificatePrintBiz.class);

	@Resource
	private MapperFactory mapperFactory;
	
		public Message<Integer> deleteCertificatePrint(Integer id,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			CertificatePrintMapper certificatePrintMapper  = mapperFactory.getMapperForMaster(CertificatePrintMapper.class);
			int result = certificatePrintMapper.logicalDeleteByPrimaryKey(id,operatorId,System.currentTimeMillis());
			
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除CertificatePrint失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Integer> createCertificatePrint(CertificatePrint certificatePrint){
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate( certificatePrint, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			CertificatePrintMapper certificatePrintMapper = mapperFactory.getMapperForMaster(CertificatePrintMapper.class);
									certificatePrint.setCreateTime(System.currentTimeMillis());			certificatePrintMapper.insert( certificatePrint );
			mapperFactory.commitTransaction();
			message.setData(certificatePrint.getId());

		} catch (Exception e) {
			LOGGER.error("createCertificatePrint,创建CertificatePrint失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForCreate(CertificatePrint certificatePrint, Message<?> message) {
								    		        		        		
        		if (isMoreThan(message, CertificatePrint.PRINTREASON, certificatePrint.getPrintreason(), 100)) {
        			return false;
        		}	
        		    								    		        		        				
        		if (isNull(message,CertificatePrint.CERTIFICATEID, certificatePrint.getCertificateid())) {
        			return false;
        		}
        		    																																return true;
	}
	public Message<Integer> updateCertificatePrint(CertificatePrint certificatePrint){
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(certificatePrint, message)) {
            return message;
        }
		try {
			CertificatePrintMapper certificatePrintMapper = mapperFactory.getMapperForMaster(CertificatePrintMapper.class);
			mapperFactory.beginTransaction();
			
			CertificatePrint certificatePrintLast = certificatePrintMapper.selectByPrimaryKeyForUpdate( certificatePrint.getId() );
			if( certificatePrintLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									certificatePrint.setUpdateTime(System.currentTimeMillis());			int result = certificatePrintMapper.updateByPrimaryKey( certificatePrint );
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateCertificatePrint,更新CertificatePrint失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForUpdate(CertificatePrint certificatePrint, Message<?> message) {
       				if (isNull(message,CertificatePrint.ID, certificatePrint.getId())) {
			return false;
		}
			   				if (isMoreThan(message, CertificatePrint.PRINTREASON, certificatePrint.getPrintreason(), 100)) {
			return false;
		}	
			   			   			   			   			   			   			   			   		return true;
    }
		public Message<Integer> changeStatus(Integer id,Byte status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			
			CertificatePrintMapper certificatePrintMapper = mapperFactory.getMapperForMaster(CertificatePrintMapper.class);
			mapperFactory.beginTransaction();
			CertificatePrint certificatePrintLast = certificatePrintMapper.selectByPrimaryKeyForUpdate(id );
			if( certificatePrintLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
			//TODO：其他判断
			
			int result = certificatePrintMapper.changeStatus(id,status,operatorId,System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("changeStatus,更新CertificatePrint状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;
	}
		public Message<CertificatePrint> getCertificatePrint( Integer id ){
		Message<CertificatePrint> message = new Message<CertificatePrint>();
		try {
			CertificatePrintMapper certificatePrintMapper = mapperFactory.getMapperForSlave(CertificatePrintMapper.class);
			CertificatePrint certificatePrint = certificatePrintMapper.selectByPrimaryKey( id );
			message.setData(certificatePrint);

		} catch (Exception e) {
			LOGGER.error("getCertificatePrint,根据主键查询CertificatePrint失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<CertificatePrint>> getAllCertificatePrint(){
	
		Message<List<CertificatePrint>> message = new Message<List<CertificatePrint>>();
		try {
			CertificatePrintMapper certificatePrintMapper = mapperFactory.getMapperForSlave(CertificatePrintMapper.class);
				
			List<CertificatePrint> certificatePrintList = certificatePrintMapper.selectAll();
			message.setData( certificatePrintList);
		} catch (Exception e) {
			LOGGER.error("getAllCertificatePrint,查询全部CertificatePrint失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<CertificatePrint>> queryCertificatePrint(CertificatePrintQuery certificatePrintQuery) {
		Message<QueryResult<CertificatePrint>> message = new Message<QueryResult<CertificatePrint>>();
		try {
			CertificatePrintMapper certificatePrintMapper = mapperFactory.getMapperForSlave(CertificatePrintMapper.class);
			QueryResult<CertificatePrint> queryResult = new QueryResult<CertificatePrint>();
			PageHelper.startPage(certificatePrintQuery.getPageIndex(), certificatePrintQuery.getPageSize());
			List<CertificatePrint> certificatePrintList = certificatePrintMapper.queryCertificatePrint(certificatePrintQuery);
			PageInfo<CertificatePrint> pageInfo = new PageInfo<CertificatePrint>(certificatePrintList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(certificatePrintList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryCertificatePrint,分页查询CertificatePrint失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}