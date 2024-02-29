package com.springBootRedisAsDB.Redis.Service.Impl;

import com.springBootRedisAsDB.Redis.Exception.DatabaseIsEmptyException;
import com.springBootRedisAsDB.Redis.Exception.StudentIdAlreadyPresentException;
import com.springBootRedisAsDB.Redis.Exception.StudentIdNotAvailableException;
import com.springBootRedisAsDB.Redis.Model.Student;
import com.springBootRedisAsDB.Redis.Service.StudentService;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private String KEY="STUDENT";
    @Resource(name = "rt")
    private HashOperations<String, Integer, Student> operations;

    @SneakyThrows
    @Override
    public ResponseEntity<String> saveStudentDetails(Student student) {
        // create new record in HashMemory if given id not exist.
       Boolean value= operations.putIfAbsent(KEY,student.getStdId(),student);
       if(value==true)
       {
           return ResponseEntity.status(HttpStatus.OK).body("Data is saved Sucessfully");
       }
       else
       {
           throw new StudentIdAlreadyPresentException("StudentId already Exists");
       }

    }

    @SneakyThrows
    @Override
    public ResponseEntity<Student> getStudentById(Integer studentId) {

       Student student1= operations.get(KEY,studentId);

       if(student1==null)
       {
           throw new StudentIdNotAvailableException(studentId+" is not available in database");
       }
       else {
           return ResponseEntity.status(HttpStatus.OK).body(student1);
       }

    }

    @SneakyThrows
    @Override
    public ResponseEntity<Map<Integer, Student>> getAllStudent() {
       Map<Integer,Student> data= operations.entries(KEY);
       if(data.isEmpty())
       {
           throw new DatabaseIsEmptyException("There is no data in Database");
       }
       else
       {
           return ResponseEntity.status(HttpStatus.OK).body(data);
       }

    }

    @Override
    public ResponseEntity<String> modifyStudentById(Integer studentId, Student student) {

        operations.put(KEY,student.getStdId(),student);

        return ResponseEntity.status(HttpStatus.OK).body("Data Updated Successfully");

    }

    @Override
    public ResponseEntity<String> deleteStudentById(Integer studentId) {

          operations.delete(KEY,studentId);
          return ResponseEntity.status(HttpStatus.OK).body("Data deleted sucessfully");

    }
}
