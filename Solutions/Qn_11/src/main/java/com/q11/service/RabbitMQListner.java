package com.q11.service;

import java.io.FileWriter;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RabbitMQListner implements MessageListener {

	private static Logger log = LoggerFactory.getLogger(RabbitMQListner.class);
	public void onMessage(Message message) {
		try {
		FileWriter fileWriter = new FileWriter("C:\\Users\\Laptop\\Desktop\\office-assignments\\rabbit.txt");
		fileWriter.write(new String(message.getBody()));
		fileWriter.close();
		log.info("message written to fileS");
	}
		catch(IOException e) {
			log.info("Error occured");
		}
	}

}