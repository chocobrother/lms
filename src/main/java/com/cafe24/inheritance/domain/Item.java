package com.cafe24.inheritance.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cafe24.lms.domain.Rent;

@Entity
@Table(name = "ITEM")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="DTYPE")
public abstract class Item {

	@Id
	@Column(name="ITEM_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Transient
	private String categoryname;
	
	private String state;
	
	@OneToMany(mappedBy = "item")
	private List<Rent> rents = new ArrayList<Rent>();
	
	@ManyToOne()
	@JoinColumn(name = "categoryNo")
	private Category category;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	//////////////////////////////////////
	
	public void addRent(Rent rent) {
		this.rents.add(rent);
	}
	
//	@OneToMany(mappedBy = "primaryKey.item", cascade = CascadeType.ALL)
	public List<Rent> getRents() {
		return rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

	
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", state=" + state + ", rents=" + rents + ", category=" + category
				+ "]";
	}

	
	
	
	
	
}
