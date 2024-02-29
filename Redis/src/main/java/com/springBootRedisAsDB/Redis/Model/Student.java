package com.springBootRedisAsDB.Redis.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID= 123456789L;

    private Integer stdId;
    private String stdName;
    private String stdFee;

}
