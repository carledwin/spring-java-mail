package com.wordpress.carledwinj;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wordpress.carledwinj.mail.Mailer;
import com.wordpress.carledwinj.model.Message;

@SpringBootApplication
public class SpringJavaMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJavaMailApplication.class, args);
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
				SpringJavaMailApplication.class.getPackage().getName());
		
		String[] beans = appContext.getBeanDefinitionNames();
		
		Arrays.sort(beans);
		
		int count = 0;
		
		for(String beanName : beans) {
			
			System.out.println("--- Bean"+count + ": "+ beanName);
		}
		
		sendMail(appContext);
	}

	private static void sendMail(AnnotationConfigApplicationContext appContext) {
		Mailer mailer = appContext.getBean(Mailer.class);
		mailer.send(new Message("Quem envia <quemenvia.email@email.com>", Arrays.asList("Quem Vai Receber <quemvaireceber.email@email.com>"), "Assunto: Spring com Java Mail ", "Corpo do email"));
		
		appContext.close();
		
		System.out.println("Email enviado com sucesso.");
	}
	
}
