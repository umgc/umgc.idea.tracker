package com.example.projecttracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectTrackerApplication {

	@Bean
	public WebMvcConfigurer configure()
	{
		return new WebMvcConfigurer() {
			
			 @Override
			 public void addCorsMappings(CorsRegistry registry) {
				 
				  registry.addMapping("/**").allowedOrigins("*")
				  .allowedMethods("GET","POST","PUT","DELETE");
				 
			 }
			 
			
			
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(ProjectTrackerApplication.class, args);
	}

}
