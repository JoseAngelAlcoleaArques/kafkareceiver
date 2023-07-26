package edu.ucam.kafkareceiver.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.ucam.kafkareceiver.entity.EventoDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MensajeService {

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "testtopic")
    public void receiveMessage(ConsumerRecord<String, String> kafkaMessage) throws JsonProcessingException {
        objectMapper.registerModule(new JavaTimeModule());
        String jsonString = kafkaMessage.value();
        EventoDTO jsonObject = objectMapper.readValue(jsonString, EventoDTO.class);
        System.out.println("Received message: " + jsonObject);
    }

    @RabbitListener(queues = {"MQ_DEMO"})
    public void receiveManage(@Payload String message) throws JsonProcessingException {
        objectMapper.registerModule(new JavaTimeModule());
        EventoDTO jsonObject = objectMapper.readValue(message, EventoDTO.class);
        System.out.println("Received message: " + jsonObject);
    }
}
