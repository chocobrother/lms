package com.cafe24.lms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.inheritance.domain.Item;
import com.cafe24.lms.repository.MainRepository;

@Service
@Transactional
public class MainService {

	
	@Autowired 
	private MainRepository mainRepository;
	
	public List<Item> getItem() {
		
		List<Item> list = mainRepository.findAll();
		
		return list;
	}
	
//	public List<Item> getMessageList() {
//		//return guestbookRepository.findAllByOrderByRegDateDesc();
//		return mainRepository.findAll( new Sort( Sort.Direction.DESC, "categoryNo" ) );
//	}
	
	
	public Page<Item> getMessageList( int pg ) {

		PageRequest pageRequest = new PageRequest(pg-1, 5);
		
//		PageRequest pageRequest = new PageRequest(0, 5, new Sort(Sort.Direction.DESC, "categoryNo"));
		
		Page<Item> result = mainRepository.findAll(pageRequest);


		
		
		return result;
	}	
	
	
	
	
}
