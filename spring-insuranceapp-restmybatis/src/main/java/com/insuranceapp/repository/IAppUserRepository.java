package com.insuranceapp.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.insuranceapp.model.AppUser;
@Mapper
public interface IAppUserRepository {
	@Insert("insert into appuser values(#{userId},#{username},#{password},#{email}) ")
	void addUser(AppUser user);
	@Update("update  appuser set email=#{email} where  userId=#{userId}")
	void updateUser(AppUser user);
	@Delete("delete from appuser where username=#{username}")
	void deleteUser(String username);
	@Select("select * from appuser where username=#{username}")
	AppUser findByUsername(String username);

}
