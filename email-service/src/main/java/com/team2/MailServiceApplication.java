package com.team2;

import com.team2.controller.EmailController;
import com.team2.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MailServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(MailServiceApplication.class, args);
    }
}
