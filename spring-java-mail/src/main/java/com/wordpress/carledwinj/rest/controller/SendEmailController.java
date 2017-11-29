package com.wordpress.carledwinj.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordpress.carledwinj.mail.Mailer;
import com.wordpress.carledwinj.model.Message;
@Controller
@RestController
@RequestMapping("/mail")
public class SendEmailController {

	@Autowired
	private Mailer mailer;
	
	private Logger LOGGER = LoggerFactory.getLogger(SendEmailController.class);
	
	@PostMapping("/send")
	public ResponseEntity<String> sendMail(@RequestBody Message message) {
		
		LOGGER.info(message.toString());
		
		mailer.send(message); 
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Sucesso");
	}
	
}
