package edu.ucam.kafkareceiver

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@EnableRabbit
class KafkareceiverApplication {

    static void main(String[] args) {
        SpringApplication.run(KafkareceiverApplication, args)
    }

}
