package com.example.Hospital.Management.Service;


import com.example.Hospital.Management.Repository.PatientRepository;
import com.example.Hospital.Management.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    @Autowired
    private PatientRepository patientrepo;

    public Patient getPatientById(Long id){
        Patient p1= patientrepo.findById(id).orElseThrow();
        return p1;
    }
}
