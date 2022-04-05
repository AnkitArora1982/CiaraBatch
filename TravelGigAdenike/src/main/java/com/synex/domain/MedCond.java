package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedCond {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String conditionName;
	private String description;
	private int severityLevel;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConditionName() {
		return conditionName;
	}
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSeverityLevel() {
		return severityLevel;
	}
	public void setSeverityLevel(int severityLevel) {
		this.severityLevel = severityLevel;
	}
	
	
	
}
