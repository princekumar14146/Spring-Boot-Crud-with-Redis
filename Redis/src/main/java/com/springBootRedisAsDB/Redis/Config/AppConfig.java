package com.springBootRedisAsDB.Redis.Config;

import com.springBootRedisAsDB.Redis.Model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class AppConfig {

    // Redis Connection
    @Bean
    public RedisConnectionFactory cf()
    {
        return  new LettuceConnectionFactory();
    }

    // Redis Template
    @Bean
    public RedisTemplate<String, Student> rt()
    {
        RedisTemplate<String,Student> template=new RedisTemplate<>();
        template.setConnectionFactory(cf());
        return template;
    }


}
