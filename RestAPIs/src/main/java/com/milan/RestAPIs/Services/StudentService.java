package com.milan.RestAPIs.Services;

import com.milan.RestAPIs.Dto.AddStudentDto;
import com.milan.RestAPIs.Dto.StudentDTO;
import com.milan.RestAPIs.Entity.Students;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDTO> getAllStudent();
    StudentDTO getstudentById(Long id);

    StudentDTO createStudent(AddStudentDto addstudentdto);

    void deleteStudentById(Long id);

    StudentDTO updatestudentById(Long id, AddStudentDto addStudentDto);

    StudentDTO updatePartialStudent(Long id, Map<String, Object> update);
}
