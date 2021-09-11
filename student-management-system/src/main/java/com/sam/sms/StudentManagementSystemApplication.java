package com.sam.sms;

import com.sam.sms.entity.Student;
import com.sam.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}


	@Autowired
	private StudentRepository studentRepository;


	@Override
	public void run(String... args) throws Exception {
//		Student student1 = new Student("Samraat", "Anand","samraatanand777@gmail.com");
//		studentRepository.save(student1);
//		Student student2 = new Student("Sonu", "Kumar","sonu@gmail.com");
//		studentRepository.save(student2);
//		Student student3 = new Student("Raushan", "Kumar","swarnim@gmail.com");
//		studentRepository.save(student3);
	}
}
