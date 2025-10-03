package com.example.Hospital.Management.Service;


import com.example.Hospital.Management.Repository.PatientRepository;
import com.example.Hospital.Management.entity.Patient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    @Autowired
    private PatientRepository patientrepo;

    @Transactional
    public Patient getPatientById(Long id){
        Patient p1= patientrepo.findById(id).orElseThrow();
        Patient p2=patientrepo.findById(id).orElseThrow();
        System.out.println(p1==p2);

        //here we dont need to save with .save method
        p1.setName("yoyo");
        return p1;
    }
}
