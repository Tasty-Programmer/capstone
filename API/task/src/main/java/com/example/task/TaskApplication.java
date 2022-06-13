package com.example.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients  // openAPI를 호출하기 위한 FeignClients를 사용할 것이라고 명시해줍니다. 이 어노테이션이 없으면 feignClient가 동작하지 않습니다.
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

}
