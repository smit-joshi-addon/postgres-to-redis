package com.pgtoredis.PostgresToRedis.pg.config;
import com.bedatadriven.jackson.datatype.jts.JtsModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public JtsModule jtsModule() {
        return new JtsModule();
    }
}
