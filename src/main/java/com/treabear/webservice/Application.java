package com.treabear.webservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class Application {

	// 실행 환경을 프로젝트 외부에 설정
	public static final String APPLICATION_LOCATIONS = "spring.config.location="
								+ "classpath:application.yml,"
								+ "/app/config/spring-webservice/real-application.yml";
								// + "C:\\dev\\yj\\app\\config\\spring-webservice\\real-application.yml";

	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);
		new SpringApplicationBuilder(Application.class)
				.properties(APPLICATION_LOCATIONS)
				.run(args);
	}

}
