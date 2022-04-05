package com.synex.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class HealthInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long submissionId;
	private String firstName;
	private String lastName;
	@ManyToMany
	private List<MedCond> medicalConditions = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSubmissionId() {
		return submissionId;
	}
	public void setSubmissionId(Long submissionId) {
		this.submissionId = submissionId;
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
	public List<MedCond> getMedicalConditions() {
		return medicalConditions;
	}
	public void setMedicalConditions(List<MedCond> medicalConditions) {
		this.medicalConditions = medicalConditions;
	}
	
	
	
}
