package com.crm.util;

import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.crm.biz.UserBiz;
import com.crm.model.Message;
import com.crm.model.User;

/**
 * Session监听器
 * @author 黄思旭 IPET006
 */
public class SessionListener implements HttpSessionListener {
	
	@Resource
	private UserBiz userBiz;

	@Override
	public void sessionCreated(HttpSessionEvent se) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext application = se.getSession().getServletContext();
		Object obj = session.getAttribute("user");
		if (obj != null) {
			Message<User> user = (Message<User> ) session.getAttribute("user");
			Set<String> set = (Set<String>) application.getAttribute("user");
			if (set.contains(user.getData().getLoginname())) {
				set.remove(user.getData().getLoginname());
			}
		}
	}
}
