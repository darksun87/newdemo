package com.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crm.biz.TravelBiz;
import com.crm.model.Travel;
import com.crm.model.TravelQuery;
import com.crm.model.Message;
import com.crm.model.QueryResult;

@Controller
@RequestMapping("travel")
public class TravelController {

	@Resource
	private TravelBiz travelBiz;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		return new ModelAndView("travel/index", modelMap);
	}

	@RequestMapping("query")
	@ResponseBody
	public QueryResult<Travel> query(TravelQuery travelQuery) {
		Message<QueryResult<Travel>> resultMessage = travelBiz.queryTravel(travelQuery);
		return resultMessage.getData();
	}

	@RequestMapping("get")
	@ResponseBody
	public Travel get(int id) {
		return travelBiz.getTravel(id).getData();
	}

	@RequestMapping("getAll")
	@ResponseBody
	public List<Travel> getAll() {
		return travelBiz.getAllTravel().getData();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Message<Integer> save(Travel travel) {
		if (travel.getId() == null) {
			travel.setCreateUserid(1);
			return travelBiz.createTravel(travel);
		}
		else {
			travel.setUpdateUserid(1);
			return travelBiz.updateTravel(travel);
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public Message<Integer> delete(Integer id) {
		return travelBiz.deleteTravel(id,"1");
	}
}
