package com.crm.biz;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.log4j.Logger;
import com.crm.data.MapperFactory;

import com.crm.dao.UserMapper;

import com.crm.model.Message;
import com.crm.model.dict.MessageStatus;
import com.crm.model.QueryResult;
import com.crm.model.User;
import com.crm.model.UserQuery;
import static com.crm.biz.util.ValidationUtil.*;

@Service("userBiz")
public class UserBiz {

	private static final Logger LOGGER = Logger.getLogger(UserBiz.class);

	@Resource
	private MapperFactory mapperFactory;

	public Message<Integer> deleteUser(Integer id, String operatorId) {
		Message<Integer> message = new Message<Integer>();
		try {
			UserMapper userMapper = mapperFactory
					.getMapperForMaster(UserMapper.class);
			int result = userMapper.logicalDeleteByPrimaryKey(id, operatorId,
					System.currentTimeMillis());

			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete,删除User失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<Integer> createUser(User user) {
		Message<Integer> message = new Message<Integer>();
		if (!validateForCreate(user, message)) {
			return message;
		}
		try {
			mapperFactory.beginTransaction();
			UserMapper userMapper = mapperFactory
					.getMapperForMaster(UserMapper.class);
			user.setCreateTime(System.currentTimeMillis());
			userMapper.insert(user);
			mapperFactory.commitTransaction();
			message.setData(user.getId());

		} catch (Exception e) {
			LOGGER.error("createUser,创建User失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		} finally {
			mapperFactory.rollbackTransaction();
		}
		return message;
	}

	private boolean validateForCreate(User user, Message<?> message) {

		if (isMoreThan(message, User.REALNAME, user.getRealname(), 100)) {
			return false;
		}

		if (isMoreThan(message, User.LOGINNAME, user.getLoginname(), 100)) {
			return false;
		}

		if (isMoreThan(message, User.PASSWORD, user.getPassword(), 128)) {
			return false;
		}
		return true;
	}

	public Message<Integer> updateUser(User user) {
		Message<Integer> message = new Message<Integer>();
		if (!validateForUpdate(user, message)) {
			return message;
		}
		try {
			UserMapper userMapper = mapperFactory
					.getMapperForMaster(UserMapper.class);
			mapperFactory.beginTransaction();

			User userLast = userMapper
					.selectByPrimaryKeyForUpdate(user.getId());
			if (userLast == null) {
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS,
						"TODO：这里请写清楚");
				return message;
			}

			user.setUpdateTime(System.currentTimeMillis());
			int result = userMapper.updateByPrimaryKey(user);
			mapperFactory.commitTransaction();
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateUser,更新User失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		} finally {
			mapperFactory.rollbackTransaction();
		}
		return message;
	}

	private boolean validateForUpdate(User user, Message<?> message) {
		if (isNull(message, User.ID, user.getId())) {
			return false;
		}
		if (isMoreThan(message, User.REALNAME, user.getRealname(), 100)) {
			return false;
		}
		if (isMoreThan(message, User.LOGINNAME, user.getLoginname(), 100)) {
			return false;
		}
		if (isMoreThan(message, User.PASSWORD, user.getPassword(), 128)) {
			return false;
		}
		return true;
	}

	public Message<Integer> changeStatus(Integer id, Byte status,
			String operatorId) {
		Message<Integer> message = new Message<Integer>();
		try {

			UserMapper userMapper = mapperFactory
					.getMapperForMaster(UserMapper.class);
			mapperFactory.beginTransaction();
			User userLast = userMapper.selectByPrimaryKeyForUpdate(id);
			if (userLast == null) {
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS,
						"TODO：这里请写清楚");
				return message;
			}

			// TODO：其他判断

			int result = userMapper.changeStatus(id, status, operatorId,
					System.currentTimeMillis());
			mapperFactory.commitTransaction();
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("changeStatus,更新User状态失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		} finally {
			mapperFactory.rollbackTransaction();
		}
		return message;
	}

	public Message<User> getUser(Integer id) {
		Message<User> message = new Message<User>();
		try {
			UserMapper userMapper = mapperFactory
					.getMapperForSlave(UserMapper.class);
			User user = userMapper.selectByPrimaryKey(id);
			message.setData(user);

		} catch (Exception e) {
			LOGGER.error("getUser,根据主键查询User失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<List<User>> getAllUser() {

		Message<List<User>> message = new Message<List<User>>();
		try {
			UserMapper userMapper = mapperFactory
					.getMapperForSlave(UserMapper.class);

			List<User> userList = userMapper.selectAll();
			message.setData(userList);
		} catch (Exception e) {
			LOGGER.error("getAllUser,查询全部User失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<User> checkUser(String loginname, String password) {

		Message<User> message = new Message<User>();
		try {
			UserMapper userMapper = mapperFactory
					.getMapperForSlave(UserMapper.class);

			List<User> userList = userMapper.checkUser(loginname, password);
			if (userList.size() > 0) {
				message.setData(userList.get(0));
				message.setStatus(1);
				message.setMessage("登录成功");
			} else {
				message.setStatus(0);
				message.setMessage("账号或密码错误！");
			}
		} catch (Exception e) {
			LOGGER.error("checkUser,登录验证User错误", e);
			message.setStatus(0);
			message.setMessageStatus(MessageStatus.LOGIN_NOT_VALID);
		}
		return message;
	}

	public Message<User> getUserByLoginname(String loginname) {

		Message<User> message = new Message<User>();
		try {
			UserMapper userMapper = mapperFactory
					.getMapperForSlave(UserMapper.class);

			List<User> userList = userMapper.getUserByLoginname(loginname);
			if (userList.size() > 0) {
				message.setData(userList.get(0));
				message.setStatus(1);
			} else {
				message.setStatus(0);
				message.setMessage("用户不存在！");
			}
		} catch (Exception e) {
			LOGGER.error("checkUser,登录验证User错误", e);
			message.setStatus(0);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<User>> queryUser(UserQuery userQuery) {
		Message<QueryResult<User>> message = new Message<QueryResult<User>>();
		try {
			UserMapper userMapper = mapperFactory
					.getMapperForSlave(UserMapper.class);
			QueryResult<User> queryResult = new QueryResult<User>();
			PageHelper.startPage(userQuery.getPageIndex(),
					userQuery.getPageSize());
			List<User> userList = userMapper.queryUser(userQuery);
			PageInfo<User> pageInfo = new PageInfo<User>(userList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(userList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryUser,分页查询User失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

}