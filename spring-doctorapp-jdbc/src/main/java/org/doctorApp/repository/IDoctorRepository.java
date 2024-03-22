package org.doctorApp.repository;

import org.doctorApp.model.Doctor;

import java.sql.SQLException;
import java.util.List;

public interface IDoctorRepository {
    void addDoctor(Doctor doctor);
    void updateDoctor(int doctorId,double fees);
    void deleteDoctor(int doctorId);
    Doctor findById(int doctorId) throws SQLException;
    List<Doctor> findAll();
    List<Doctor> findBySpeciality(String speciality);
    List<Doctor> findBySpecialityAndExp(String speciality, int experience);
    List<Doctor> findBySpecialityAndLessFees(String speciality, double fees);
    List<Doctor> findBySpecialityAndRatings(String speciality, int ratings);
    List<Doctor> findBySpecialityAndNameContains(String speciality, String doctorName);
}
