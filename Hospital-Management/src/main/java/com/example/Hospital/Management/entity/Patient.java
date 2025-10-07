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
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_mail", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_withname_dob", columnNames = {"name", "birth_date"})
        },
        indexes = {
                @Index(name = "idx_name_birthdate", columnList = "birth_date")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(name = "birth_date") // Explicitly name the column
    private LocalDate birthDate; // Corrected naming

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_group")
    private BloodGroupTypes bloodGroup; // Corrected type and naming
}