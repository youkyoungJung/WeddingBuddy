package com.multicampus.kb03.weddingBuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeddingBuddyApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/weddingBuddy");
		SpringApplication.run(WeddingBuddyApplication.class, args);
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
