package com.ug.Ukraine_students;

import com.ug.Ukraine_students.repository.UsersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
public class UkraineStudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UkraineStudentsApplication.class, args);
	}

}
