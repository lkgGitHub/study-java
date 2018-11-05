package com.lkg.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyApplicationTests {
//	private static final Logger log = LoggerFactory.getLogger(StudyApplicationTests.class);

	@Test
	public void contextLoads() {
	}

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate<String, Serializable> redisTemplate;
	@Test
	public void redisDemo(){
		System.out.println("aaaaaaaaaaaa");
//		stringRedisTemplate.opsForValue().set("k1", "v1");
//		final String k1 = stringRedisTemplate.opsForValue().get("k1");
//		System.out.println("[字符缓存结果] ==>" + k1);
//		stringRedisTemplate.opsForValue().increment("kk",1);
		ExecutorService executorService = Executors.newFixedThreadPool(8);
		IntStream.range(0,100).forEach(i ->
				executorService.execute(() -> stringRedisTemplate.opsForValue().increment("kk",1))
		);
	}

}
