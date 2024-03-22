package org.doctorApp.model;

public enum Specialization {
    ORTHO("ORTHOPEDIC"),
    PEDIA("PEDIATRICIAN"),
    PHYSICIAN("GENERAL PHYSICIAN"),
    GYNACO("GYNECOLOGIST"),
    DERMA("DERMATOLOGIST");

    private String speciality;
    Specialization(String speciality){
        this.speciality=speciality;
    }
    public String getSpeciality(){
        return speciality;
    }
}
