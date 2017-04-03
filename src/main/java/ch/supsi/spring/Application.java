package ch.supsi.spring;

import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class Application extends SpringBootServerInitializer {
	public SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(Application.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}