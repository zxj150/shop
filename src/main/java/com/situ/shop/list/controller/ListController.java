package com.situ.shop.list.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.shop.list.domain.Lists;
import com.situ.shop.list.service.ListService;
@Controller
@RequestMapping("/list")
public class ListController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private ListService listService;
	
	@RequestMapping("/tree")
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName("list/jtree");
		modelAndView.addObject("menu", listService.findAllList());
		return modelAndView;
	}
	
	@RequestMapping("/find")
	public ModelAndView gotree(ModelAndView modelAndView) {
		modelAndView.addObject("list", listService.findAllList());
		modelAndView.setViewName("list/jtree_table");
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/add")
	public Long goAdd(Lists lists) {
	
		
		return listService.saveList(lists);
	}
	
	@ResponseBody
	@RequestMapping("/delete/{rowId}")
	public Long goDelete(@PathVariable("rowId") Long rowId) {
		
		
		return listService.deleteList(rowId);
	}

@ResponseBody
@RequestMapping("/goupdate/{rowId}")
public Lists goUpdate(@PathVariable("rowId") Long rowId) {
	
	
	return listService.findListById(rowId);
}
@ResponseBody
@RequestMapping("/doupdate")
public Long doUpdate(Lists lists) {
	
	
	return listService.updateList(lists);
}
@ResponseBody
@RequestMapping("/checkListName")
public String checkRoleName(String fieldId, String fieldValue) {
	
	Boolean bool = listService.checkListName(fieldValue);
	
	ObjectMapper objectMapper = new ObjectMapper();
	List<Object> list = new ArrayList<Object>();
	list.add(fieldId);
	list.add(bool);
	
		try {
			return objectMapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
	
	return null;
}

}
