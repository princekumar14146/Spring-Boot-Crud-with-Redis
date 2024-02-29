package com.springBootRedisAsDB.Redis.Exception;

public class DatabaseIsEmptyException extends Exception{

    String message;

    public DatabaseIsEmptyException(String message)
    {
        super(message);
    }
}
