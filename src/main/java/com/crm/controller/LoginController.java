package com.crm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.chain.contexts.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.crm.biz.UserBiz;
import com.crm.model.Message;
import com.crm.model.Resource;
import com.crm.model.User;
import com.crm.service.TestService;
import com.crm.service.system.SystemService;
import com.crm.view.grid.Grid;
import com.crm.view.grid.GridHead;
import com.crm.view.grid.GridViewDate;

@Controller
public class LoginController {
	
	private Map<String,Object> model = new HashMap<String,Object>();
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private SystemService systemService;
	@javax.annotation.Resource
	private UserBiz userBiz;
	
	
	@RequestMapping(value = "/index")
	public ModelAndView index() {
		Map<String,Object> model = new HashMap<String,Object>();
		List<Resource> menus = systemService.selectMenuByPid(0);
		model.put("menu", menus);
		return new ModelAndView("index", model);
	}
	@RequestMapping(value = "/welcome")
	public ModelAndView welcome() {
		return new ModelAndView("welcome");
	}

	@RequestMapping(value = "/checkUser")
	@ResponseBody
	public Message<User> checkUser(String loginname, String password, HttpServletRequest request) {	
		Message<User> user = userBiz.checkUser(loginname, password);
		if (user.getStatus()==1) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			ServletContext application = session.getServletContext();
			application.setAttribute("user", user.getData().getLoginname());
		}
		return user;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		
//		Test test = testService.selectByPrimaryKey(1L);
		List<Resource> menus = systemService.selectMenuByPid(0);
		model.put("menu", menus);

		return new ModelAndView("login", model);
	}
	@RequestMapping(value = "/fileUpload.htm")  
    public String fileUpload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
  
        System.out.println("开始");  
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = file.getOriginalFilename();  
//        String fileName = new Date().getTime()+".jpg";  
        System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  
  
        return "result";  
    }
	
	/**
	 *  grid page Demo
	 * @return
	 */
	@RequestMapping(value = "/grid.htm")  
    public ModelAndView gridPage() {
		Grid grid = new Grid<GridViewDate>();
		for(int i = 0; i < 5; i ++){
			GridHead head = new GridHead();
			head.setTitle(i + "");
			grid.getHead().add(head);
		}
		
		for(int i = 0; i < 100; i ++){
			GridViewDate gridViewDate = new GridViewDate();
			gridViewDate.setIndex(i);
			gridViewDate.setName("name" + i);
			gridViewDate.setCode("code" + i);
			grid.getContentDate().add(gridViewDate);
		}
		
		model.put("grid", grid);
		return new ModelAndView("template/grid",model);  
    }
	
	/**
	 *  grid page Demo
	 * @return
	 */
	@RequestMapping(value = "/form.htm")  
    public ModelAndView formPage() {
		return new ModelAndView("template/form",model);  
    }
}
