package edu.ucam.kafkareceiver.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqReceiverConfig {

    @Bean Queue queue(){
            return new Queue("MQ_DEMO");
        }

}
