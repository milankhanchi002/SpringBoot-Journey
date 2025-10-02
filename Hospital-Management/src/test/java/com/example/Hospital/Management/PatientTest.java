package com.example.Hospital.Management;


import com.example.Hospital.Management.Repository.PatientRepository;
import com.example.Hospital.Management.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {
    @Autowired
    private PatientRepository patientrepo;

    @Test
    public void testPatientRepository(){
    List<Patient> patientList=patientrepo.findAll();
        System.out.println(patientList);
    }
}
