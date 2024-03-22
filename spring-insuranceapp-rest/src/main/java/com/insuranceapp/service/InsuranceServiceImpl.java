package com.insuranceapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.insuranceapp.model.Insurance;

@Service
public class InsuranceServiceImpl implements IInsuranceService {

	@Override
	public List<Insurance> getAll() {

		return getAllInsurance();
	}

	@Override
	public Insurance getById(int insuranceId) {
		List<Insurance> insurances = getAllInsurance();
		for (Insurance insurance : insurances) {
			if (insurance.getInsuranceId() == insuranceId)
				return insurance;
		}
		return null;
	}

	private List<Insurance> getAllInsurance() {
		return Arrays.asList(new Insurance(101, "VH-123", "Voya", "Health", 10, 1000),
				new Insurance(102, "BJ-321", "Bajaj", "Motor", 10, 5000),
				new Insurance(103, "F1-Life", "fidelity", "Life", 15, 8000),
				new Insurance(104, "VD-Mx01", "Voya", "Motor", 16, 10200),
				new Insurance(105, "F1-Motor", "fidelity", "Health", 12, 32000));
	}

}
