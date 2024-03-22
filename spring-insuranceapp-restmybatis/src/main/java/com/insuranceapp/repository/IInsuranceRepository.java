package com.insuranceapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.insuranceapp.exception.InsuranceNotFoundException;
import com.insuranceapp.model.Insurance;

@Mapper
public interface IInsuranceRepository {
	@Insert("insert into Insurance(policyName,brand,type,duration,premium) values(#{policyName},#{brand},#{type},#{duration},#{premium})")
	void addInsurance(Insurance insurance);

	@Update("update Insurance set premium=#{premium} where insuranceId=#{insuranceId}")
	void updateInsurance(int insuranceId, double premium);

	@Delete("delete from Insurance where insuranceId=#{insuranceId}")
	void deleteInsurance(int insuranceId);

	@Select("select * from Insurance")
	@Results({ @Result(property = "insuranceId", column = "insuranceId"),
			@Result(property = "policyName", column = "policyName")

	})
	List<Insurance> findAll();

	@Select("select * from Insurance where brand=#{brand}")
	@Results({ @Result(property = "insuranceId", column = "insuranceId"),
			@Result(property = "policyName", column = "policyName")

	})
	List<Insurance> findByBrand(String brand) throws InsuranceNotFoundException;

	@Select("select * from Insurance where brand=#{brand} and type=#{type}")
	@Results({ @Result(property = "insuranceId", column = "insuranceId"),
			@Result(property = "policyName", column = "policyName")

	})
	List<Insurance> findByBrandAndType(String brand, String type) throws InsuranceNotFoundException;

	@Select("select * from Insurance where type=#{type} and premium=#{premium}")
	@Results({ @Result(property = "insuranceId", column = "insuranceId"),
			@Result(property = "policyName", column = "policyName")

	})
	List<Insurance> findByTypeAndLesserPremium(String type, String premium) throws InsuranceNotFoundException;

	@Select("select * from Insurance where insuranceId=#{insuranceId}")
	@Results({ @Result(property = "insuranceId", column = "insuranceId"),
			@Result(property = "policyName", column = "policyName")

	})
	Insurance findById(int insuranceId) throws InsuranceNotFoundException;
}
