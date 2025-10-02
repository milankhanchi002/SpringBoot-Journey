package com.example.Hospital.Management.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ToString.Exclude
    private String name;
    private LocalDate Birth_date;
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
