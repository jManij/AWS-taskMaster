package com.example.taskMaster;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskMasterApplication {

	@Value("${amazon.aws.accesskey}")
	private static String amazonAWSAccessKey;



	public static void main(String[] args) {
		SpringApplication.run(TaskMasterApplication.class, args);
		System.out.println("Task Master is Listening now!!");
	}

}

