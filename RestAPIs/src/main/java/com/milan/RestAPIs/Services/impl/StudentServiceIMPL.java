package com.milan.RestAPIs.Services.impl;

import com.milan.RestAPIs.Controllers.Student;
import com.milan.RestAPIs.Dto.AddStudentDto;
import com.milan.RestAPIs.Dto.StudentDTO;
import com.milan.RestAPIs.Entity.Students;
import com.milan.RestAPIs.Repositories.studentRepository;
import com.milan.RestAPIs.Services.StudentService;
import com.milan.RestAPIs.config.StudentMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceIMPL implements StudentService {

    private final StudentMapper studentMapper;

    private final ModelMapper mapper;

    public final studentRepository studentrepo;

    public StudentServiceIMPL(StudentMapper studentMapper, ModelMapper mapper, studentRepository studentrepo) {
        this.studentMapper = studentMapper;
        this.mapper = mapper;
        this.studentrepo = studentrepo;
    }

    @Override
    public List<StudentDTO> getAllStudent() {
        List<Students> students=studentrepo.findAll();
        return (List<StudentDTO>) students
                .stream()
                .map(student -> new StudentDTO(student.getId(),student.getEmail(),student.getName()))
//                .map(student->studentMapper.StudentsToStudentDTO(student))
                .toList();
    }

    @Override
    public StudentDTO getstudentById(Long id) {
    //here findById will return optional of student dto
        // findById returns an Optional<Students> which is handled by orElseThrow
       Students student= studentrepo.findById(id).orElseThrow(()->new IllegalArgumentException("student not found of id"+id));
       return studentMapper.StudentsToStudentDTO(student);
    }

    @Override
    public StudentDTO createStudent(AddStudentDto addstudentdto) {
        Students student=mapper.map(addstudentdto,Students.class);
        Students savedStudent=studentrepo.save(student);
        return mapper.map(savedStudent, StudentDTO.class);
//        return addstudentdto;
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentrepo.existsById(id)){
            throw new IllegalArgumentException("stundent not exist by id:"+id);
        }
        studentrepo.deleteById(id);
    }

    @Override
    public StudentDTO updatestudentById(Long id, AddStudentDto addStudentDto) {
        Students student=studentrepo.findById(id).orElseThrow(()->new IllegalArgumentException("student not found by id:"+id));
        mapper.map(addStudentDto,student);
        student=studentrepo.save(student);
        return mapper.map(student,StudentDTO.class);
    }

    @Override
    public StudentDTO updatePartialStudent(Long id, Map<String, Object> update) {
        Students student=studentrepo.findById(id).orElseThrow(()->new IllegalArgumentException("student not found by id:"+id));
        update.forEach((String field,Object value)->{
            switch (field){
                case "name":student.setName((String)value);
                break;
                case "email":student.setEmail((String)value);
                break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }

        });
        Students savedStudent=studentrepo.save(student);
        return mapper.map(savedStudent, StudentDTO.class);
//        return null;
    }
}
