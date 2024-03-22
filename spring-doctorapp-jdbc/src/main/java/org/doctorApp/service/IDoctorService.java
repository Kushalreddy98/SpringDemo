package org.doctorApp.service;

import org.doctorApp.exceptions.DoctorNotFoundException;
import org.doctorApp.exceptions.IdNotFoundException;
import org.doctorApp.model.Doctor;

import java.sql.SQLException;
import java.util.List;

public interface IDoctorService {
    void addDoctor(Doctor doctor);
    void updateDoctor(int doctorId,double fees);
    void deleteDoctor(int doctorId);
    Doctor getById(int doctorId) throws IdNotFoundException, SQLException;
    List<Doctor> getAll();
    List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException;
    List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException;
    List<Doctor> getBySpecialityAndLessFees(String speciality, double fees) throws DoctorNotFoundException;
    List<Doctor> getBySpecialityAndRatings(String speciality, int ratings) throws DoctorNotFoundException;
    List<Doctor> getBySpecialityAndNameContains(String speciality, String doctorName) throws DoctorNotFoundException;
}
