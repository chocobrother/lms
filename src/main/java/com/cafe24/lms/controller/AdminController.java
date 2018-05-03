package com.cafe24.lms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.inheritance.domain.Category;
import com.cafe24.lms.domain.Rent;
import com.cafe24.lms.domain.Reserve;
import com.cafe24.lms.service.AdminService;
import com.cafe24.security.Auth;




@Controller
@RequestMapping( "/admin" )
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Auth(value=Auth.Role.ADMIN)	
	@RequestMapping( { "", "/rent", "/main" } )
	public String main( Model model,
			@RequestParam(value = "pg", defaultValue="1" ,required = false) int pg) {
		
//		List<Rent> list= adminService.getRent();
	
//		for(Rent rent : list) {
//			
//			rent.setTitle(rent.getItem().getName());
//			
//			Category category = adminService.getCategoryName(rent.getItem().getId());
//			
//			rent.setCategoryName(category.getCatename());	
//		}
		
		Page<Rent> list = adminService.getRent(pg);
		
		for(Rent rent : list) {
		
			rent.setTitle(rent.getItem().getName());
			
			Category category = adminService.getCategoryName(rent.getItem().getId());
			
			System.out.println("Rent category ..." + category);

			rent.setCategoryName(category.getCatename());	
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
		
		return "admin/rent";
	}
	@Auth(value=Auth.Role.ADMIN)
	@RequestMapping( "/reserve" )
	public String reserve(Model model,
			@RequestParam(value = "pg", defaultValue="1" ,required = false) int pg) {
		
//		List<Reserve> list= adminService.getReserve();
//		
//		for(Reserve reserve : list) {
//			
//			reserve.setTitle(reserve.getItem().getName());
//		
//			Category category = adminService.getCategoryName(reserve.getItem().getId());
//			
//			reserve.setCategoryName(category.getCatename());
//		
//		}
		
		
		Page<Reserve> list = adminService.getReserve(pg);
		
		for(Reserve reserve : list) {
		
			reserve.setTitle(reserve.getItem().getName());
			
			Category category = adminService.getCategoryName(reserve.getItem().getId());
			
			
			System.out.println("reserve category ..." + category);
			
			reserve.setCategoryName(category.getCatename());	
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
		
		return "admin/reserve";
	}
	
}
