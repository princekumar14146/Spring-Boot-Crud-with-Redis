package com.springBootRedisAsDB.Redis.Exception;

public class StudentIdAlreadyPresentException extends Exception{

    String message;

     public StudentIdAlreadyPresentException(String message)
     {
         super(message);
     }
}
