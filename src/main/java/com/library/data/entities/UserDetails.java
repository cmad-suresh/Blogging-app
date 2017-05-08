package com.library.data.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")

public class UserDetails {

	@Id @GeneratedValue 
	private int userid;
	private String username;
	@OneToMany(mappedBy="user")
	/*@JoinTable(name="USER_VEHICLE", joinColumns=@JoinColumn(name="USER_ID"),
						  inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))*/
	
	private List<Vehicles> vehicle = new ArrayList();
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Vehicles> getVehicle() {
		return vehicle;
	}
	public void setVehicle(List<Vehicles> vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
