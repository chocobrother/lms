package com.cafe24.lms.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.cafe24.inheritance.domain.Item;


public class UserItemId implements Serializable {

	
	/*@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Item item;*/
	
	private Long user;
	
	private Long item;

//	private Long no;
	
	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Long getItem() {
		return item;
	}

	public void setItem(Long item) {
		this.item = item;
	}

//	public Long getNo() {
//		return no;
//	}
//
//	public void setNo(Long no) {
//		this.no = no;
//	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	
	
	
	
}
