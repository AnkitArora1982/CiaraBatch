package com.synex.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Address;
import com.synex.domain.AgeGroup;
import com.synex.domain.MedCond;
import com.synex.domain.PrimInsur;
import com.synex.model.InsuranceModel;
import com.synex.repository.AgeGroupRepository;
import com.synex.repository.FamMemRepository;
import com.synex.repository.HealthInfoRepository;
import com.synex.repository.MedCondRepository;
import com.synex.repository.PersonalInfoRepository;
import com.synex.repository.PrimInsuranceRepository;

@Service
public class InsuranceServiceImpl implements InsuranceService{
	
	@Autowired
	FamMemRepository famMemRepository;
	
	@Autowired
	HealthInfoRepository healthInfoRepository;
	
	@Autowired
	MedCondRepository medCondRepository;
	
	@Autowired
	PersonalInfoRepository personalInfoRepository;
	
	@Autowired
	PrimInsuranceRepository primInsuranceRepository;
	
	@Autowired
	AgeGroupRepository ageGroupRepository;
	
	@Override
	public String saveInsurance(InsuranceModel insuraceModel) {
		PrimInsur primInsur = new PrimInsur();
		primInsur.setFirstName(insuraceModel.getFirstName());
		primInsur.setLastName(insuraceModel.getLastName());
		Address address = new Address();
		address.setAddressLine(insuraceModel.getAddressLine());
		primInsur.setInsurerAddress(address);
		AgeGroup ageGroup = ageGroupRepository.findByAgeRange(insuraceModel.getAgeRange());
		primInsur.setAgeGroup(ageGroup);
		List<String> listMedicalCondition = insuraceModel.getConditionName();
		Iterator<String> itrMedicalCond = listMedicalCondition.iterator();
		List listMedicalConditionObject = new ArrayList<>();
		while(itrMedicalCond.hasNext()) {
			String conditionName = itrMedicalCond.next();
			MedCond medCond = medCondRepository.findByConditionName(conditionName);
			listMedicalConditionObject.add(medCond);
		}
		primInsur.setMedCond(listMedicalConditionObject);
		primInsuranceRepository.save(primInsur);
		return null;
	}

}
