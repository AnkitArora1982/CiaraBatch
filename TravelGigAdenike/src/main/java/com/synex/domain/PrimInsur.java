package com.synex.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PrimInsur {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@OneToOne
	private Address insurerAddress;
	
	@ManyToOne
	private AgeGroup ageGroup;
	@ManyToMany
	private List<MedCond> medCond = new ArrayList<>();
	@ManyToMany
	private List<FamMem> famMem = new ArrayList<>();
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Address getInsurerAddress() {
		return insurerAddress;
	}
	public void setInsurerAddress(Address insurerAddress) {
		this.insurerAddress = insurerAddress;
	}
	public AgeGroup getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}
	public List<MedCond> getMedCond() {
		return medCond;
	}
	public void setMedCond(List<MedCond> medCond) {
		this.medCond = medCond;
	}
	public List<FamMem> getFamMem() {
		return famMem;
	}
	public void setFamMem(List<FamMem> famMem) {
		this.famMem = famMem;
	}
	
	
	
}
