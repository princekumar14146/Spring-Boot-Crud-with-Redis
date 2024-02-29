package com.springBootRedisAsDB.Redis.Exception;

public class StudentIdNotAvailableException extends Exception{

    String message;

    public StudentIdNotAvailableException(String message)
    {
        super(message);
    }

}
