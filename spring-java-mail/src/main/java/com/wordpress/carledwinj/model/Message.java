package com.wordpress.carledwinj.model;

import java.util.List;

public class Message {

	private Long id;
	private String sender;
	private List<String> recipients;
	private String subject;
	private String body;
	
	public Message() {
	}
	
	public Message(String sender, List<String> recipients, String subject, String body) {
		super();
		this.sender = sender;
		this.recipients = recipients;
		this.subject = subject;
		this.body = body;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public List<String> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", sender=" + sender + ", recipients=" + recipients + ", subject=" + subject
				+ ", body=" + body + "]";
	}
	
	
	
	
}
