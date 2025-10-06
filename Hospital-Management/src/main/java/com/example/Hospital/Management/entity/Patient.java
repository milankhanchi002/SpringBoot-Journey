package com.example.Hospital.Management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter
@Table(name = "PatientTable",
uniqueConstraints = {
        @UniqueConstraint(name = "unique_patient_mail", columnNames = {"email"}),
        @UniqueConstraint(name="unique_withname_dob",columnNames = {"name","Birth_date"})
}
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ToString.Exclude
    @Column(name="patient_name",nullable = false,length=40)
    private String name;

    private LocalDate Birth_date;
    @Column(unique = true,nullable = false)
    private String email;
    private String gender;
//
//    @Override
//    public String toString() {
//        return "Patient{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", Birth_date=" + Birth_date +
//                ", email='" + email + '\'' +
//                ", gender='" + gender + '\'' +
//                '}';
//    }
}
