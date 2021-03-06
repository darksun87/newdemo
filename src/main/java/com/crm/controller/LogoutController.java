package com.crm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
		
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("login");
	}
}
