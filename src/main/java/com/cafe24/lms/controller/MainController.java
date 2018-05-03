package com.cafe24.lms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.inheritance.domain.Book;
import com.cafe24.inheritance.domain.Category;
import com.cafe24.inheritance.domain.DVD;
import com.cafe24.inheritance.domain.Item;
import com.cafe24.lms.domain.Gender;
import com.cafe24.lms.domain.Role;
import com.cafe24.lms.domain.User;
import com.cafe24.lms.service.MainService;
import com.cafe24.lms.service.UserService;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;

	
	
	@RequestMapping( { "", "/main" } )
	public String index( Model model,
			@RequestParam(value = "pg", defaultValue="1" ,required = false) int pg) {
		
//		List<Item> list = mainService.getItem();
//		
//		
//		for(Item item : list) {
//			System.out.println("Item 목록 : " + item + "category" + item.getCategory());
//			
//			item.setCategoryname(item.getCategory().getCatename());
//			
//		}
		
		
		Page<Item> list = mainService.getMessageList(pg);
		
//		List<Item> list1 = list.getContent();
		
		for(Item item :list ) {
		System.out.println("페이지 아이템 ~~" + item);
		item.setCategoryname(item.getCategory().getCatename());
	}
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		int totalA = (int) list.getTotalElements();
		int totalP = (totalA+2) / 3; 
		
		System.out.println("totalA" + totalA);
		
		int startPage = (pg-1)/3*3+1;
		int endPage = startPage + 2;
		
		if(totalP < endPage) endPage = totalP;


		map.put("list", list);
		map.put("pg",pg);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalP", totalP);
		
		model.addAttribute("map",map);
		
		return "main/index";
	}
	

	
	
	

	
}
