package org.doctorApp.util;

public class Queries {
    public static final String INSERTQUERY="INSERT INTO DOCTOR(doctor_name,speciality,experience,ratings,fees) values(?,?,?,?,?)";
    public static final String UPDATEQUERY="UPDATE DOCTOR SET fees=? where doctor_Id=?";
    public static final String DELETEQUERY="DELETE FROM DOCTOR WHERE doctor_Id=?";
    public static final String FINDALLQUERY="SELECT * FROM DOCTOR";
    

    public static final String FINDBYSPECIALITY="SELECT * FROM DOCTOR where speciality=?";
    public static final String FINDBYSPECIALITYANDEXP="SELECT * FROM DOCTOR where speciality=? and experience=?";
    public static final String FINDBYSPECIALITYANDRATINGS="SELECT * FROM DOCTOR where speciality=? and ratings=?";
    public static final String FINDBYSPECIALITYANDFEES="SELECT * FROM DOCTOR where speciality=? and fees<=?";
    public static final String FINDBYSPECIALITYANDNAME="SELECT * FROM DOCTOR where speciality=? and doctor_name like ?";
    public static final String FINDBYID="SELECT * FROM DOCTOR where doctor_Id=?";

    
}
