package org.doctorApp;

import java.util.List;
import java.util.Scanner;

import org.doctorApp.model.Doctor;
import org.doctorApp.model.Specialization;
import org.doctorApp.service.DoctorServiceImpl;
import org.doctorApp.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class SpringDoctorappJdbcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringDoctorappJdbcApplication.class, args);
	}
	
	@Autowired
	IDoctorService service;
	@Override
	public void run(String... args) throws Exception {
	
        Specialization specialization = Specialization.DERMA;
        String speciality = specialization.getSpeciality();
        String special = Specialization.DERMA.getSpeciality();
       Scanner scanner=new Scanner(System.in);

        System.out.println("DOCTORS LIST");
        List<Doctor> doctors2= service.getAll();
        for(Doctor doctor2:doctors2){
            System.out.println(doctor2);
        }
        
        
        //ADD DOCTOR METHOD
        Doctor doctor=new Doctor("Manju",speciality,2800,10,5);
        service.addDoctor(doctor);

        //UPDATE DOCTOR METHOD
        System.out.println("Enter the id");
        int id=scanner.nextInt();
        System.out.println("Enter the fees");
        double fees=scanner.nextDouble();
        service.updateDoctor(id,fees);
        

        //DELETE DOCTOR METHOD
        System.out.println("Enter the id");
        int voterId=scanner.nextInt();
        service.deleteDoctor(voterId);

        //FINDBYSPECIALITY METHOD
        System.out.println("Enter the speciality");
        String speciality4=scanner.next();
        Specialization sp4 = Specialization.valueOf(speciality4);
        List<Doctor>doctors4=service.getBySpeciality(sp4.getSpeciality());
        for(Doctor doctor4:doctors4)
            System.out.println(doctor4);

        //FINDBYSPECIALITYANDEXPERIENCE METHOD
        System.out.println("Enter the speciality");
        String speciality5=scanner.next();
        System.out.println("Enter the experience");
        int exp=scanner.nextInt();
        Specialization sp5= Specialization.valueOf(speciality5);
        List<Doctor>doctors5=service.getBySpecialityAndExp(sp5.getSpeciality(),exp);
        for(Doctor doctor5:doctors5)
            System.out.println(doctor5);

        //FINDBYSPECIALITYANDLESSFEES METHOD
        System.out.println("Enter the speciality");
        String speciality6 = scanner.next();
        System.out.println("Enter the fees");
        double fee = scanner.nextDouble();
        Specialization sp6 = Specialization.valueOf(speciality6);
        List<Doctor> doctors6 = service.getBySpecialityAndLessFees(sp6.getSpeciality(), fee);
        for (Doctor doctor6 : doctors6)
            System.out.println(doctor6);


        //FINDBYSPECIALITYANDRATING METHOD
        System.out.println("Enter the speciality");
        String speciality7=scanner.next();
        System.out.println("Enter the rating");
        int rating=scanner.nextInt();
        Specialization sp7 = Specialization.valueOf(speciality7);
        List<Doctor>doctors7=service.getBySpecialityAndRatings(sp7.getSpeciality(),rating);
        for(Doctor doctor7:doctors7)
            System.out.println(doctor7);


        //FINDBYSPECIALITYANDNAME METHOD
        System.out.println("Enter the speciality");
        String speciality8=scanner.next();
        System.out.println("Enter the docterName");
        String doctorName=scanner.next();
        Specialization sp8 = Specialization.valueOf(speciality8);
        List<Doctor> doctors8=service.getBySpecialityAndNameContains(sp8.getSpeciality(),doctorName);
        for(Doctor doctor8:doctors8)
            System.out.println(doctor8);

        //FINDBYID  METHOD
        System.out.println("Enter Docter Id");
        int id1= scanner.nextInt();
        System.out.println(service.getById(id1));
		
	}

}
