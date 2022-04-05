package com.synex.model;

import java.util.List;

import com.synex.domain.FamMem;
import com.synex.domain.MedCond;

public class InsuranceModel {
	private String firstName;
	private String lastName;
	private String addressLine;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private String ageRange;
	private List<String> conditionName;
	private List<FamMem> listFamMem;
	
	public List<String> getConditionName() {
		return conditionName;
	}
	public void setConditionName(List<String> conditionName) {
		this.conditionName = conditionName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAgeRange() {
		return ageRange;
	}
	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}
	
	public List<FamMem> getListFamMem() {
		return listFamMem;
	}
	public void setListFamMem(List<FamMem> listFamMem) {
		this.listFamMem = listFamMem;
	}
	
	
}
