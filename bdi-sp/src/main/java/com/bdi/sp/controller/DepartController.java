package com.bdi.sp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdi.sp.service.DepartService;
import com.bdi.sp.vo.Depart;

@Controller
public class DepartController {

	@Autowired
	private DepartService ds;
	
	private static final Logger logger = LoggerFactory.getLogger(DepartController.class);
	
	@RequestMapping(value="/depart",method=RequestMethod.GET)
	public @ResponseBody List<Depart> departList(@ModelAttribute Depart di){
		return ds.getDepartList(di);
	}
	
	@RequestMapping(value="/depart{dinum}",method=RequestMethod.GET)
	public @ResponseBody Depart departList(@PathVariable int dinum){
		return ds.getDepart(dinum);
	}
	
	@RequestMapping(value="/depart{dinum}",method=RequestMethod.POST)
	public @ResponseBody int insertDepart(@ModelAttribute Depart di,@PathVariable Integer dinum){
		logger.debug("depart=>{}",di);
		return ds.insertDepart(di);
	}
	
	@RequestMapping(value="/depart{dinum}",method=RequestMethod.PUT)
	public @ResponseBody int updateDepart(@RequestBody Depart di,@PathVariable Integer dinum){
		logger.debug("depart=>{}",di);
		return ds.updateDepart(di);
	}
	
	@RequestMapping(value="/depart{dinum}",method=RequestMethod.DELETE)
	public @ResponseBody int deleteDepart(@PathVariable int di){
		return ds.deleteDepart(di);
	}
}
