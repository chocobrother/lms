package com.cafe24.inheritance.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("C")
@PrimaryKeyJoinColumn(name = "CD_ID") 
public class CD  extends Item {

	private String Singer;

	
	
	public String getSinger() {
		return Singer;
	}

	
	
	public void setSinger(String singer) {
		Singer = singer;
	}

	@Override
	public String toString() {
		return "CD [Singer=" + Singer + ", getId()=" + getId() + ", getName()=" + getName() + ", getState()="
				+ getState() + "]";
	}
	
	
	
	
}
