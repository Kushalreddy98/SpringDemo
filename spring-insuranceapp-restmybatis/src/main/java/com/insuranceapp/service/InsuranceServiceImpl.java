package com.insuranceapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceapp.exception.InsuranceNotFoundException;
import com.insuranceapp.model.Insurance;
import com.insuranceapp.repository.IInsuranceRepository;

@Service
public class InsuranceServiceImpl implements IInsuranceService {
	@Autowired
	IInsuranceRepository repository;
	@Override
	public void addInsurance(Insurance insurance) {
		// TODO Auto-generated method stub
		repository.addInsurance(insurance);
	}

	@Override
	public void updateInsurance(int insuranceId, double premium) {
		// TODO Auto-generated method stub
		repository.updateInsurance(insuranceId, premium);
	}

	@Override
	public void deleteInsurance(int insuranceId) {
		// TODO Auto-generated method stub
		repository.deleteInsurance(insuranceId);
	}

	@Override
	public List<Insurance> getAll() {
		
		return repository.findAll();
	}

	@Override
	public List<Insurance> getByBrand(String brand) throws InsuranceNotFoundException {
		// TODO Auto-generated method stub
		return repository.findByBrand(brand);
	}

	@Override
	public List<Insurance> getByBrandAndType(String brand, String type) throws InsuranceNotFoundException {
		// TODO Auto-generated method stub
		return repository.findByBrandAndType(brand, type);
	}

	@Override
	public List<Insurance> getByTypeAndLesserPremium(String type, String premium) throws InsuranceNotFoundException {
		// TODO Auto-generated method stub
		return repository.findByTypeAndLesserPremium(type, premium);
	}

	@Override
	public Insurance getById(int insuranceId) throws InsuranceNotFoundException {
		// TODO Auto-generated method stub
		return repository.findById(insuranceId);
	}

}