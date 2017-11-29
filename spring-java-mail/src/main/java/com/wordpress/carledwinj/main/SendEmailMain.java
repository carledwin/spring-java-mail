package com.wordpress.carledwinj.main;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wordpress.carledwinj.mail.Mailer;
import com.wordpress.carledwinj.model.Message;

public class SendEmailMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SendEmailMain.class.getPackage().getName());
		
		Mailer mailer = context.getBean(Mailer.class);
		mailer.send(new Message("Quem envia <quemenvia.email@email.com>", Arrays.asList("Quem Vai Receber <quemvaireceber.email@email.com>"), "Assunto: Spring com Java Mail ", "Corpo do email"));
		
		context.close();
		
		System.out.println("Email enviado com sucesso.");
	}
}
