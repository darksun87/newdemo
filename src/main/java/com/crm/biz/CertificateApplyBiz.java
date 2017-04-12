package com.crm.biz;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.log4j.Logger;
import com.crm.data.MapperFactory;

import com.crm.dao.CertificateApplyMapper;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.crm.model.QueryResult;
import com.crm.model.CertificateApply;
import com.crm.model.CertificateApplyQuery;
import static com.crm.biz.util.ValidationUtil.*;

@Service("certificateApplyBiz")
public class CertificateApplyBiz {


	private static final Logger LOGGER = Logger.getLogger(CertificateApplyBiz.class);

	@Resource
	private MapperFactory mapperFactory;
	
		public Message<Integer> deleteCertificateApply(Integer id,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			CertificateApplyMapper certificateApplyMapper  = mapperFactory.getMapperForMaster(CertificateApplyMapper.class);
			int result = certificateApplyMapper.logicalDeleteByPrimaryKey(id,operatorId,System.currentTimeMillis());
			
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除CertificateApply失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Integer> createCertificateApply(CertificateApply certificateApply){
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate( certificateApply, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			CertificateApplyMapper certificateApplyMapper = mapperFactory.getMapperForMaster(CertificateApplyMapper.class);
									certificateApply.setCreateTime(System.currentTimeMillis());			certificateApplyMapper.insert( certificateApply );
			mapperFactory.commitTransaction();
			message.setData(certificateApply.getId());

		} catch (Exception e) {
			LOGGER.error("createCertificateApply,创建CertificateApply失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForCreate(CertificateApply certificateApply, Message<?> message) {
								    		        		        		
        		if (isMoreThan(message, CertificateApply.APPLYREASON, certificateApply.getApplyreason(), 100)) {
        			return false;
        		}	
        		    								    		        		        				
        		if (isNull(message,CertificateApply.CERTIFICATEID, certificateApply.getCertificateid())) {
        			return false;
        		}
        		    								    		        		    								    		        		        		
        		if (isMoreThan(message, CertificateApply.GM_RESULT, certificateApply.getGmResult(), 10)) {
        			return false;
        		}	
        		    								    		        		        		
        		if (isMoreThan(message, CertificateApply.GM_SUGGEST, certificateApply.getGmSuggest(), 100)) {
        			return false;
        		}	
        		    								    		        		    																																return true;
	}
	public Message<Integer> updateCertificateApply(CertificateApply certificateApply){
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(certificateApply, message)) {
            return message;
        }
		try {
			CertificateApplyMapper certificateApplyMapper = mapperFactory.getMapperForMaster(CertificateApplyMapper.class);
			mapperFactory.beginTransaction();
			
			CertificateApply certificateApplyLast = certificateApplyMapper.selectByPrimaryKeyForUpdate( certificateApply.getId() );
			if( certificateApplyLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									certificateApply.setUpdateTime(System.currentTimeMillis());			int result = certificateApplyMapper.updateByPrimaryKey( certificateApply );
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateCertificateApply,更新CertificateApply失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;	
	}
	private boolean validateForUpdate(CertificateApply certificateApply, Message<?> message) {
       				if (isNull(message,CertificateApply.ID, certificateApply.getId())) {
			return false;
		}
			   				if (isMoreThan(message, CertificateApply.APPLYREASON, certificateApply.getApplyreason(), 100)) {
			return false;
		}	
			   			   			   				if (isMoreThan(message, CertificateApply.GM_RESULT, certificateApply.getGmResult(), 10)) {
			return false;
		}	
			   				if (isMoreThan(message, CertificateApply.GM_SUGGEST, certificateApply.getGmSuggest(), 100)) {
			return false;
		}	
			   			   			   			   			   			   			   			   		return true;
    }
		public Message<Integer> changeStatus(Integer id,Byte status,String operatorId){
		Message<Integer> message = new Message<Integer>();
		try {
			
			CertificateApplyMapper certificateApplyMapper = mapperFactory.getMapperForMaster(CertificateApplyMapper.class);
			mapperFactory.beginTransaction();
			CertificateApply certificateApplyLast = certificateApplyMapper.selectByPrimaryKeyForUpdate(id );
			if( certificateApplyLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
			//TODO：其他判断
			
			int result = certificateApplyMapper.changeStatus(id,status,operatorId,System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("changeStatus,更新CertificateApply状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		finally{
			mapperFactory.rollbackTransaction();
		}
		return message;
	}
		public Message<CertificateApply> getCertificateApply( Integer id ){
		Message<CertificateApply> message = new Message<CertificateApply>();
		try {
			CertificateApplyMapper certificateApplyMapper = mapperFactory.getMapperForSlave(CertificateApplyMapper.class);
			CertificateApply certificateApply = certificateApplyMapper.selectByPrimaryKey( id );
			message.setData(certificateApply);

		} catch (Exception e) {
			LOGGER.error("getCertificateApply,根据主键查询CertificateApply失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<CertificateApply>> getAllCertificateApply(){
	
		Message<List<CertificateApply>> message = new Message<List<CertificateApply>>();
		try {
			CertificateApplyMapper certificateApplyMapper = mapperFactory.getMapperForSlave(CertificateApplyMapper.class);
				
			List<CertificateApply> certificateApplyList = certificateApplyMapper.selectAll();
			message.setData( certificateApplyList);
		} catch (Exception e) {
			LOGGER.error("getAllCertificateApply,查询全部CertificateApply失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<CertificateApply>> queryCertificateApply(CertificateApplyQuery certificateApplyQuery) {
		Message<QueryResult<CertificateApply>> message = new Message<QueryResult<CertificateApply>>();
		try {
			CertificateApplyMapper certificateApplyMapper = mapperFactory.getMapperForSlave(CertificateApplyMapper.class);
			QueryResult<CertificateApply> queryResult = new QueryResult<CertificateApply>();
			PageHelper.startPage(certificateApplyQuery.getPageIndex(), certificateApplyQuery.getPageSize());
			List<CertificateApply> certificateApplyList = certificateApplyMapper.queryCertificateApply(certificateApplyQuery);
			PageInfo<CertificateApply> pageInfo = new PageInfo<CertificateApply>(certificateApplyList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(certificateApplyList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryCertificateApply,分页查询CertificateApply失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}