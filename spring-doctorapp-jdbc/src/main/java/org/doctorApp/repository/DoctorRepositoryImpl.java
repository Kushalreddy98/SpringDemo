package org.doctorApp.repository;

import java.sql.SQLException;
import java.util.List;

import org.doctorApp.model.Doctor;
import org.doctorApp.util.Queries;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class DoctorRepositoryImpl implements IDoctorRepository {
	private JdbcTemplate jdbcTemplate;
	
	public DoctorRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addDoctor(Doctor doctor) {
		Object[] doctorArr= {doctor.getDoctorName(),doctor.getSpeciality(),doctor.getExperience(),doctor.getRatings(),doctor.getFees()};
		jdbcTemplate.update(Queries.INSERTQUERY, doctorArr);
		
	}

	@Override
	public void updateDoctor(int doctorId, double fees) {
		jdbcTemplate.update(Queries.UPDATEQUERY,fees,doctorId);
		
	}

	@Override
	public void deleteDoctor(int doctorId) {
		jdbcTemplate.update(Queries.DELETEQUERY,doctorId);
		
	}

	@Override
	public Doctor findById(int doctorId) throws SQLException {
		Doctor doctor=jdbcTemplate.queryForObject(Queries.FINDBYID,new DoctorMapper(), doctorId);
		return doctor;
	}

	@Override
	public List<Doctor> findAll() {
		RowMapper<Doctor> mapper=new DoctorMapper();
		List<Doctor> doctor=jdbcTemplate.query(Queries.FINDALLQUERY, mapper);
		return doctor;
		
	}

	@Override
	public List<Doctor> findBySpeciality(String speciality) {
		List<Doctor> doctor=jdbcTemplate.query(Queries.FINDBYSPECIALITY, new DoctorMapper(),speciality);
		return doctor;
	}

	@Override
	public List<Doctor> findBySpecialityAndExp(String speciality, int experience) {
		List<Doctor> doctor=jdbcTemplate.query(Queries.FINDBYSPECIALITYANDEXP, new DoctorMapper(),speciality,experience);
		return doctor;
	}

	@Override
	public List<Doctor> findBySpecialityAndLessFees(String speciality, double fees) {
		List<Doctor> doctor=jdbcTemplate.query(Queries.FINDBYSPECIALITYANDFEES, new DoctorMapper(),speciality,fees);
		return doctor;
	}

	@Override
	public List<Doctor> findBySpecialityAndRatings(String speciality, int ratings) {
		List<Doctor> doctor=jdbcTemplate.query(Queries.FINDBYSPECIALITYANDRATINGS, new DoctorMapper(),speciality,ratings);
		return doctor;
	}

	@Override
	public List<Doctor> findBySpecialityAndNameContains(String speciality, String doctorName) {
		List<Doctor> doctor=jdbcTemplate.query(Queries.FINDBYSPECIALITYANDNAME, new DoctorMapper(),speciality,doctorName);
		return doctor;
	}
   
}
