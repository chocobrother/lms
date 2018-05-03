package com.cafe24.lms.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.inheritance.domain.Item;
import com.cafe24.lms.domain.Rent;
import com.cafe24.lms.domain.Reserve;
import com.cafe24.lms.domain.Role;
import com.cafe24.lms.domain.User;
import com.cafe24.lms.repository.MainRepository;
import com.cafe24.lms.repository.RentRepository;
import com.cafe24.lms.repository.ReserveRepository;
import com.cafe24.lms.repository.UserRepository;

@Service
@Transactional
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MainRepository mainRepository;
	
	@Autowired
	private RentRepository rentRepository;
	
	@Autowired
	private ReserveRepository reserveRepository;
	
	public void join( User user ) {
		//1.DB에 사용정보 저장
		user.setRole( Role.USER );
		userRepository.save( user );
		
	}
	
	
	public void saveRent(Long no,Long id) {
		
		Rent rent = new Rent();
				
		User user = userRepository.findOne(id);
		
		Item item = mainRepository.findOne(no);
		
		Long RentNum  = rentRepository.findUsing(no, id);
		
		System.out.println("클릭한 아이템 예약중인지 확인하기 위함" + RentNum);
		
		if(RentNum == null) {
			
			
			rent.setUser(user);
			
			rent.setItem(item);
			
			item.setState("대여중");
			
			rent.setRentDate(new Date());
			
			Calendar cal = new GregorianCalendar(Locale.KOREA);
			
			cal.setTime(new Date());
			
			cal.add(Calendar.DAY_OF_YEAR, 7);
		
			rent.setReturnDate(cal.getTime());
			
			rentRepository.save(rent);
			
			
			///5월 2일 제대로 볼 것 대여중 변경하는거 
			
			System.out.println("user service item : " + item);
			
			//잘 들어옴 update 쿼리만 수정하면 될듯?
			
			updateState(item);
			
			
			
		}else if(RentNum!=null) {
			return;
		}
		
		
	}
	
	// item_id = no user_id = id
	public void saveReserve(Long no,Long id) {
		
		//빌린 아이템 의 대여 정보 찾기
		Rent rent = rentRepository.findwant(no);
	
		User user = userRepository.findOne(id);
		
		Item item = mainRepository.findOne(no);
		
		//아이템의 상태 찾기 
		String state = mainRepository.findwant(no);
		
		System.out.println("state 상태 " +state );
	
		if(state==null) {
			//대여
			saveRent(no,id);
			
		} else if(state!=null) {
		
		//예약
			Reserve reserve = new Reserve();
			
			Long reserveNum  = reserveRepository.findUsing(no, id);
			
			System.out.println("클릭한 아이템 예약중인지 확인하기 위함" + reserveNum);
			
			if(reserveNum == null) {

				reserve.setUser(user);
				reserve.setItem(item);
				
				reserve.setReserveDate(rent.getReturnDate());
				
				Calendar cal = new GregorianCalendar(Locale.KOREA);
				
				cal.setTime(rent.getReturnDate());
				
				cal.add(Calendar.DAY_OF_YEAR, 7);
			
				reserve.setReturnDate(cal.getTime());
				
				reserveRepository.save(reserve);
				
			}else if(reserveNum != null) {
			
				return;
			}
						
		}
		
	}
	
	
	
	public boolean updateState( Item item ) {
		return mainRepository.update( item ) == 1;
	}
	
	
	
	
	public User getUser( String email, String password ) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	public User getUser( Long no ) {
		return userRepository.findOne( no );
	}
	
	
	public boolean modifyUser( User user ) {
		return userRepository.update( user ) == 1;
	}
}
