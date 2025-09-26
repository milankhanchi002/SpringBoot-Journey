package com.milan.RestAPIs.Dto;
//import lombok.AllArgsConstructor;
//import lombok.Data;
/*When you put @Data on a class, Lombok auto-generates boilerplate code for you at compile time:
Getters for all fields
Setters for all fields
toString()
equals() and hashCode()
A required-args constructor (constructor for all final fields and fields marked @NonNull)*/
//@Data
//@AllArgsConstructor
public class StudentDTO {
    private long id;
    private String name;
    private  String email;

    public StudentDTO() {
    }

    public StudentDTO(long i, String milannn, String mail) {
    this.id=i;
    this.name=milannn;
    this.email=mail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

