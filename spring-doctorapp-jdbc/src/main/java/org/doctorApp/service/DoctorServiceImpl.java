package org.doctorApp.service;

import org.doctorApp.exceptions.DoctorNotFoundException;
import org.doctorApp.exceptions.IdNotFoundException;
import org.doctorApp.model.Doctor;
import org.doctorApp.repository.DoctorRepositoryImpl;
import org.doctorApp.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
@Service
public class DoctorServiceImpl implements IDoctorService {
	@Autowired
    private IDoctorRepository repository;
	
    @Override
    public void addDoctor(Doctor doctor) {
        repository.addDoctor(doctor);
    }

    @Override
    public void updateDoctor(int doctorId, double fees) {
            repository.updateDoctor(doctorId,fees);
    }

    @Override
    public void deleteDoctor(int doctorId) {
        repository.deleteDoctor(doctorId);
    }

    @Override
    public Doctor getById(int doctorId) throws IdNotFoundException, SQLException {
        Doctor doctor= repository.findById(doctorId);
        if(doctor==null)
            throw new IdNotFoundException("Invalid id");
        return doctor;
    }

    @Override
    public List<Doctor> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException {
        List<Doctor> doctorList=repository.findBySpeciality(speciality);
        if(doctorList.isEmpty())
            throw new DoctorNotFoundException("doctor with this speciality not found");
        Collections.sort(doctorList,(o1, o2) -> o2.getSpeciality().compareTo(o1.getSpeciality()));
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
        List<Doctor> doctorList=repository.findBySpecialityAndExp(speciality,experience);
        if(doctorList.isEmpty())
            throw new DoctorNotFoundException("doctor with this speciality and experience not found");
        Collections.sort(doctorList,(o1, o2) -> ((Integer)o2.getExperience()).compareTo(o1.getExperience()));
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecialityAndLessFees(String speciality, double fees) throws DoctorNotFoundException {
        List<Doctor> doctorList=repository.findBySpecialityAndLessFees(speciality,fees);
        if(doctorList.isEmpty())
            throw new DoctorNotFoundException("doctor with this speciality and fees not found");
        Collections.sort(doctorList,(o1, o2) -> ((Double)o2.getFees()).compareTo(o1.getFees()));
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecialityAndRatings(String speciality, int ratings) throws DoctorNotFoundException {
        List<Doctor> doctorList=repository.findBySpecialityAndRatings(speciality,ratings);
        if(doctorList.isEmpty())
            throw new DoctorNotFoundException("doctor with this speciality and ratings not found");
        Collections.sort(doctorList,(o1, o2) ->((Integer)o2.getRatings()).compareTo(o1.getRatings()));
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecialityAndNameContains(String speciality, String doctorName) throws DoctorNotFoundException {
        List<Doctor> doctorList=repository.findBySpecialityAndNameContains(speciality,doctorName);
        if(doctorList.isEmpty())
            throw new DoctorNotFoundException("doctor with this speciality and name are not found");
        Collections.sort(doctorList,(o1, o2) -> o2.getDoctorName().compareTo(o1.getDoctorName()));
        return doctorList;
    }
}
