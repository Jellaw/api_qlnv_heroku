package com.example.demo.Model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String dob;
	private int accid;
	private String gender;
	private String email;
	private String address;
	private String phone;
	private String position;
	private Double salary;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	public Employee(){
		id=0;
	}
	public Employee(String name, String dob, int accid, String gender, String email, String address, String phone,
			String position, Double salary, long id) {
		super();
		this.name = name;
		this.dob = dob;
		this.accid = accid;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.position = position;
		this.salary = salary;
		this.id = id;
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getAccid() {
		return accid;
	}
	public void setAccid(int accid) {
		this.accid = accid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}