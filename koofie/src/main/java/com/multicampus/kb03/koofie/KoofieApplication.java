package com.multicampus.kb03.koofie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KoofieApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/koofie");
		SpringApplication.run(KoofieApplication.class, args);
	}
	
	/*
	 * @Bean public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	 * return args -> {
	 * 
	 * System.out.println(">>>> 스프링부트 러너  <<<< ");
	 * System.out.println("스프링 부트 애플리케이션 구동시 시작되는 프로그램");
	 * 
	 * String[] beanNames = ctx.getBeanDefinitionNames(); for (String beanName :
	 * beanNames) { System.out.println(beanName); }
	 * 
	 * }; }
	 */
}
