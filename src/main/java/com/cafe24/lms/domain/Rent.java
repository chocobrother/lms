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


/*@AssociationOverrides({ @AssociationOverride(name = "primaryKey.user", joinColumns = @JoinColumn(name = "USER_ID")),
		@AssociationOverride(name = "primaryKey.item", joinColumns = @JoinColumn(name = "ITEM_ID")) })*/
@Entity
//@IdClass(UserItemId.class)
@Table(name = "RENT")
public class Rent {

//	private UserItemId primaryKey = new UserItemId();
	
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "ITEM_ID")
	private Item item;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "no")
	private Long no;
	
	@Transient
	private String categoryName;

	@Transient
	private String title;
	
	
	
	
	//////////////////////
	
	
	public Long getNo() {
		return no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setNo(Long no) {
		this.no = no;
	}


	
	@Column(name = "rentDate")
	@Temporal(TemporalType.DATE)
	private Date rentDate;

	
	@Column(name = "returnDate")
	@Temporal(TemporalType.DATE)
	private Date returnDate;


	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

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

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Rent [user=" + user + ", item=" + item + ", no=" + no + ", categoryName=" + categoryName + ", rentDate="
				+ rentDate + ", returnDate=" + returnDate + ", getNo()=" + getNo() + ", getRentDate()=" + getRentDate()
				+ ", getUser()=" + getUser() + ", getItem()=" + getItem() + ", getReturnDate()=" + getReturnDate()
				+ ", getCategoryName()=" + getCategoryName() + "]";
	}

	
	
}
