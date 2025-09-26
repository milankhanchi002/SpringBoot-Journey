package com.milan.RestAPIs.Controllers;
import com.milan.RestAPIs.Dto.AddStudentDto;
import com.milan.RestAPIs.Dto.StudentDTO;
import com.milan.RestAPIs.Entity.Students;
import com.milan.RestAPIs.Repositories.studentRepository;
import com.milan.RestAPIs.Services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

//It combines:
//@Controller → marks the class as a controller (so Spring MVC can detect it).
//@ResponseBody → tells Spring to return the response as JSON/XML (instead of rendering a JSP/HTML view).
//So basically:
//@RestController = @Controller + @ResponseBody
@RestController
public class Student {

    public final studentRepository studentrepo;
    public final StudentService stuser;
    public Student(studentRepository studentrepo, StudentService stuser) {
        this.studentrepo = studentrepo;
        this.stuser = stuser;
    }
//    public Student (StudentService stuser){
//        this.stuser=stuser;
//    }
//    @GetMapping("/student") this is returning direct student entity from persistance layer by jpa using studentrepository
//    public List<Students> getStudent(){
//        return studentrepo.findAll();
//    }
    //this will return StudentDTO from service layer
    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getStudents(){
        return ResponseEntity.ok(stuser.getAllStudent());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO> getStudentByID(@PathVariable("id")Long studentid){
//        return new StudentDTO(2,"milannn","milan@gmail.com");
//        StudentDTO result=
        return ResponseEntity.ok( stuser.getstudentById(studentid));

    }
    @PostMapping("/addstudent")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody AddStudentDto addstudentdto){
        return ResponseEntity.status(HttpStatus.CREATED).body(stuser.createStudent(addstudentdto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        stuser.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id,@RequestBody AddStudentDto addStudentDto){
        return ResponseEntity.ok(stuser.updatestudentById(id,addStudentDto));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<StudentDTO> updatePartialStudent(@PathVariable Long id,@RequestBody Map<String,Object> update){
        return ResponseEntity.ok(stuser.updatePartialStudent(id,update));
    }
}
