package com.cafe24.lms.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue( strategy = GenerationType.IDENTITY  )
	private Long no;
	
	@NotEmpty
	@Column( name = "name", nullable = false, length = 20 )
	private String name;
	
	
	@Column( name = "email", nullable = false, length = 200 )
	private String email;
	
	
	@Column( name = "password", nullable = false, length = 128 )
	private String password;
	
	
	@Column( name = "gender", nullable = false, columnDefinition="enum('female', 'male')" )
	@Enumerated( EnumType.STRING )
	private Gender gender;
	
	@Column( name = "role", nullable = false, columnDefinition="enum('ADMIN', 'USER')" )
	@Enumerated( EnumType.STRING )
	private Role role;
	
	@OneToMany(mappedBy = "user")
	private List<Rent> rents = new ArrayList<Rent>();
	
	public Long getNo() {
		return no;
	}
	
	public void setNo(Long no) {
		this.no = no;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	/////////////////////
	public void addRent(Rent rent) {
		this.rents.add(rent);
	}
	//////////////////////
	
	
	
//	@OneToMany(mappedBy = "primaryKey.user", cascade = CascadeType.ALL)
	public List<Rent> getRents() {
		return rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", role=" + role + "]";
	}
	
	

}
