package com.springBootRedisAsDB.Redis.Controller;

import com.springBootRedisAsDB.Redis.Model.Student;
import com.springBootRedisAsDB.Redis.Service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/save")
    public ResponseEntity<String> saveStudentDetails(@RequestBody  Student student)
    {
        return studentService.saveStudentDetails(student);
    }

    @GetMapping("/get/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer studentId)
    {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/get")
    public ResponseEntity<Map<Integer, Student>> getAllStudent()
    {
        return studentService.getAllStudent();
    }

    @PutMapping("/modify/{studentId}")
    public ResponseEntity<String> modifyStudentById(@PathVariable("studentId")  Integer studentId,@RequestBody Student student)
    {
        return studentService.modifyStudentById(studentId, student);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudentById(@RequestParam("studentId") Integer studentId)
    {
        return studentService.deleteStudentById(studentId);
    }

}
