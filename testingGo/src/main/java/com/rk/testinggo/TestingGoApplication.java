package com.rk.testinggo;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.rk.testinggo.model.User;
import com.rk.testinggo.service.RegistrationService;

@SpringBootApplication
@PropertySource(value= {"classpath:configuration.properties"})
public class TestingGoApplication implements CommandLineRunner {

	@Autowired
	private Environment environment;
	@Autowired
	ApplicationContext context;
	public static void main(String[] args) {
		SpringApplication.run(TestingGoApplication.class, args);
	}
	@Autowired
	RegistrationService service ;
	@Override
	public void run(String a[]) {
		try{
			User user = new User();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter user id: ");
			String uid = sc.next();
			System.out.println("Enter password: ");
			String pwd = sc.next();
			System.out.println("Enter name: ");
			String name = sc.next();
			System.out.println("Enter city: ");
			String city = sc.next();
			System.out.println("Enter email: ");
			String mail = sc.next();
			System.out.println("Enter phone: ");
			String phone = sc.next();
			user.setCity(city);
			user.setUserId(uid);
			user.setPassword(pwd);
			user.setName(name);
			user.setEmail(mail);
			user.setPhone(phone);
			
			String message= service.registerUser(user);
			System.out.print(environment.getProperty(message));
			//System.out.print(environment.getProperty("UserRespository.REGISTRATION_SUCCESS"));
			
		}catch(Exception e)
		{
			System.out.println(environment.getProperty(e.getMessage()));
		}
	}

}
