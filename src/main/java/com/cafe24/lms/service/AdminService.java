package com.cafe24.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.inheritance.domain.Category;
import com.cafe24.lms.domain.Rent;
import com.cafe24.lms.domain.Reserve;
import com.cafe24.lms.repository.AdminRepository;
import com.cafe24.lms.repository.CategoryRepository;
import com.cafe24.lms.repository.ReserveRepository;

@Service
@Transactional
public class AdminService {

	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ReserveRepository reserveRepository;
	
	
	
	
	
	public Page<Rent> getRent(int pg){
		
		PageRequest pageRequest = new PageRequest(pg-1, 5);
		
		Page<Rent> list = adminRepository.findAll(pageRequest);
		
		return list;
	}
	
	
	public Page<Reserve> getReserve(int pg){
		
		PageRequest pageRequest = new PageRequest(pg-1, 5);
		
		Page<Reserve> list = reserveRepository.findAll(pageRequest);
		
		return list;
	}
	
	
	
	
	public Category getCategoryName(Long no) {
		
		return categoryRepository.findOne(no);
	}
}
