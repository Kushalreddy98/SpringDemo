package com.insuranceapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceapp.model.Insurance;
import com.insuranceapp.service.IInsuranceService;
@RestController
@RequestMapping("/insurance-api/v1")
public class InsuranceControllers {
	@Autowired
	IInsuranceService service;
	@PostMapping("/insurances")
	ResponseEntity<Void> addInsurance(@RequestBody Insurance insurance) {
		service.addInsurance(insurance);
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
	}
	@PutMapping("/insurances")
	ResponseEntity<Void> updateInsurance(@RequestBody Insurance insurance) {
		service.updateInsurance(insurance.getInsuranceId(), insurance.getPremium());
		return ResponseEntity.accepted().build();
	}
	@DeleteMapping("/insurances/insurance-id/{insuranceId}")
	ResponseEntity<Void> deleteInsurance(@PathVariable("insuranceId") int insuranceId) {
		service.deleteInsurance(insuranceId);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/insurances")
	ResponseEntity<List<Insurance>> getAll(){
		HttpHeaders headers= new HttpHeaders();
		headers.add("info", "returning list of insurance");
		headers.add("desc", "All insurance from db");
		List<Insurance> insurances=service.getAll();
		ResponseEntity<List<Insurance>> entity=new ResponseEntity(insurances,headers,HttpStatus.OK);
		return entity;
	}
	@GetMapping("/insurances/brand/{brand}")
	ResponseEntity<List<Insurance>> getByBrand(@PathVariable("brand") String brand){
		HttpHeaders headers= new HttpHeaders();
		headers.add("info", "returning list of insurance by brand"+brand);
		List<Insurance> insurances=service.getByBrand(brand);
		return ResponseEntity.status(200).headers(headers).body(insurances);
	}
	@GetMapping("/insurances/brand/{brand}/type/{type}")
	ResponseEntity<List<Insurance>> getByBrandAndType(@PathVariable("brand")String brand,@PathVariable("type")String type){
		List<Insurance> insurances=service.getByBrandAndType(brand,type);
		return ResponseEntity.ok(insurances);
	}
	@GetMapping("/insurances/type/{type}/premium/{premium}")
	ResponseEntity<List<Insurance>> getByTypeAndLesserPremium(String type,String premium){
		List<Insurance> insurances= service.getByTypeAndLesserPremium(type, premium);
		HttpHeaders headers= new HttpHeaders();
		headers.add("info", "returning list of insurance by type and premium"+type+" "+premium);
		return ResponseEntity.accepted().headers(headers).body(insurances);
	}
	@GetMapping("/insurances/insurance-id/{insuranceId}")
	ResponseEntity<Insurance> getById(@PathVariable int insuranceId) {
		Insurance insurance= service.getById(insuranceId);
		return ResponseEntity.ok().body(insurance);
	}

}
