package com.milan.RestAPIs.config;

import com.milan.RestAPIs.Dto.StudentDTO;
import com.milan.RestAPIs.Entity.Students;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface StudentMapper {
    //Instance for easy access
    StudentMapper INSTANCE= Mappers.getMapper(StudentMapper.class);

    //Define the mapping
    StudentDTO StudentsToStudentDTO(Students student);
}
