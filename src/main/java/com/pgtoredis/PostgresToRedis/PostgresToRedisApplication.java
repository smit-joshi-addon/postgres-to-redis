package com.pgtoredis.PostgresToRedis;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import redis.clients.jedis.JedisPooled;
import redis.clients.jedis.search.Query;
import redis.clients.jedis.search.SearchResult;

@EnableRedisDocumentRepositories(basePackages = "com.pgtoredis.PostgresToRedis.redis.*")
@Configuration
@EnableScheduling
@SpringBootApplication
public class PostgresToRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresToRedisApplication.class, args);
	}


}
