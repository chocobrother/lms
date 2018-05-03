package com.cafe24.lms.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cafe24.inheritance.domain.Item;

@Entity
//@IdClass(UserItemId.class)
@Table(name = "RESERVE")
public class Reserve {

	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;


	@ManyToOne
	@JoinColumn(name = "ITEM_ID")
	private Item item;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long no;
	
	
	@Column(name = "reserveDate")
	@Temporal(TemporalType.DATE)
	private Date reserveDate;

	
	@Column(name = "returnDate")
	@Temporal(TemporalType.DATE)
	private Date returnDate;


	@Transient
	private String categoryName;

	@Transient
	private String title;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Reserve [user=" + user + ", item=" + item + ", no=" + no + ", reserveDate=" + reserveDate
				+ ", returnDate=" + returnDate + ", categoryName=" + categoryName + ", title=" + title + "]";
	}

	
	
	
	
}
