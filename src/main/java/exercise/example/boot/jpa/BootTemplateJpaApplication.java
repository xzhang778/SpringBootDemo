package exercise.example.boot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootTemplateJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootTemplateJpaApplication.class, args);

	}
}
