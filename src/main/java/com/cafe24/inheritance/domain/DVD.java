package com.cafe24.inheritance.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("D")
@PrimaryKeyJoinColumn(name = "DVD_ID") 
public class DVD extends Item {

	private String company;
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "DVD [company=" + company + ", getId()=" + getId() + ", getName()=" + getName() + ", getState()="
				+ getState() + "]";
	}
	
	
	
}
