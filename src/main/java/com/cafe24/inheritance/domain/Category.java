package com.cafe24.inheritance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "categoryNo")
	private Long no;
	
	private String catename;
	
	
	

	public Long getNo() {
		return no;
	}




	public void setNo(Long no) {
		this.no = no;
	}




	public String getCatename() {
		return catename;
	}




	public void setCatename(String catename) {
		this.catename = catename;
	}




	@Override
	public String toString() {
		return "Category [no=" + no + ", catename=" + catename + "]";
	}
	
	
	
	
}
