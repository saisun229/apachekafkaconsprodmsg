package com.sai.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;


 @SpringBootApplication
 public class KafakaExampleApplication implements ApplicationRunner {
   @Autowired
   private KafkaTemplate<String, String> kafkaTemplate;

   public void sendMessage(String msg) {
      kafkaTemplate.send("sai", msg);
   }
   public static void main(String[] args) {
		SpringApplication.run(KafakaExampleApplication.class, args);
   }
   @KafkaListener(topics = "sai", groupId = "group-id")
   public void listen(String message) {
      System.out.println("Received Messagee in ################################### in the group group-id: " + message);
   }
   @Override
   public void run(ApplicationArguments args) throws Exception {
      sendMessage("Messag@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
   }
}
