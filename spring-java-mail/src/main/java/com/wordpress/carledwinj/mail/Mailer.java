package com.wordpress.carledwinj.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.wordpress.carledwinj.model.Message;


@Component
public class Mailer {

	private Logger LOGGER = LoggerFactory.getLogger(Mailer.class);
	
	@Autowired
	private JavaMailSender javaMailSender;

	public boolean send(Message message) {

		try {
			
			LOGGER.info("Inicio do envio de email...");
			
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(message.getSender());
			simpleMailMessage.setTo(message.getRecipients().toArray(new String[message.getRecipients().size()]));
			simpleMailMessage.setSubject(message.getSubject());
			simpleMailMessage.setText(message.getBody());

			LOGGER.info("Enviando de email...");
			
			javaMailSender.send(simpleMailMessage);
			
			LOGGER.info("Email enviado com sucesso.");
			return true;

		} catch (Exception e) {

			LOGGER.error("Erro ao tentar enviar email. Message error : " + e.getMessage());
			LOGGER.error("Erro ao tentar enviar email. Cause error : " + e.getCause());
			return false;
		}
	}
}
