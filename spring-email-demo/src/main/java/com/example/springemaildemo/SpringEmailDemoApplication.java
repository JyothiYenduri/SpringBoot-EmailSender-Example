package com.example.springemaildemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.springemaildemo.service.EmailSenderService;

@SpringBootApplication
public class SpringEmailDemoApplication {
	
	private EmailSenderService senderService;

	@Autowired
	public SpringEmailDemoApplication(EmailSenderService senderService) {
        this.senderService = senderService;
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailDemoApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	
	public void sendEmail(){
		senderService.sendEmail("receiver_mail@gmail.com", "Test Mail", "Body of the mail");
	}

}
