package com.springBootRedisAsDB.Redis.Service;

import com.springBootRedisAsDB.Redis.Model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface StudentService {

    public ResponseEntity<String> saveStudentDetails(Student student);
    public ResponseEntity<Student> getStudentById(Integer studentId);

    public ResponseEntity<Map<Integer,Student>> getAllStudent();

    public ResponseEntity<String> modifyStudentById(Integer studentId,Student student);

    public ResponseEntity<String> deleteStudentById(Integer studentId);

}
