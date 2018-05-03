package com.cafe24.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.lms.domain.User;
import com.cafe24.lms.service.UserService;
import com.cafe24.security.AuthUser;

@Controller
@RequestMapping( "/user" )
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping( value="/join", method=RequestMethod.GET )
	public String join( @ModelAttribute User user ){
		return "user/join";
	}
	
	
	@RequestMapping( value="/join", method=RequestMethod.POST )
	public String join( @ModelAttribute User user,
						Model model){
		
		System.out.println("user info :" + user);
		
		userService.join(user);
		
		return "user/joinsuccess";
	}
	
	
	@RequestMapping( value="/login", method=RequestMethod.GET )
	public String login() {
		return "user/login";
	}

	@RequestMapping( "/joinsuccess" )
	public String joinsuccess(){
		return "user/joinsuccess";
	}
	

	@RequestMapping( "/rent/{ITEM_ID}/{id}" )
	public String rent( Model model,
			@PathVariable("ITEM_ID")Long no,
			@PathVariable("id")Long id,
			@AuthUser User user) {
		
		System.out.println("item_id : " + no);
		
		System.out.println("user_id :" + id);
		
		userService.saveRent(no,id);
		
		
		return "main/rent";
	}
	
	
	@RequestMapping( "/reverse/{ITEM_ID}/{id}" )
	public String reverse( Model model,
			@PathVariable("ITEM_ID")Long no,
			@PathVariable("id")Long id,
			@AuthUser User user) {
		
		System.out.println("item_id : " + no);
		
		System.out.println("user_id :" + id);
		
		System.out.println("ㅇㅖ약 ~~~");
		
		
		userService.saveReserve(no,id);
		
		
		return "main/rent";
	}
	
	
	
	@RequestMapping( value="/modify", method=RequestMethod.GET )
	public String modify() {
		return "user/modify";
	}
	
	@RequestMapping( value="/modify/{no}", method=RequestMethod.POST )
	public String modify(@ModelAttribute User user,
			@PathVariable("no") Long userno,
			@AuthUser User user1,
			Model model) {
		
		user.setNo(userno);
		
		System.out.println("회원정보 수정 전 : " + user);
		
		userService.modifyUser(user);
		
		return "redirect:/main";
	}

}
