package edu.ucam.kafkareceiver.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucam.kafkareceiver.entity.Mensaje;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MensajeService {

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "test_topic")
    public void receiveMessage(Mensaje mensaje) {
        System.out.println("Mensaje recibido: " + mensaje.getId() + " fecha: " + mensaje.getDate() + " mensaje: " + mensaje.getMensaje());
    }

    @RabbitListener(queues = {"MQ_DEMO"})
    public void receiveManage(@Payload String message) throws JsonProcessingException {
        Object jsonObject = objectMapper.readValue(message, Object.class);
        System.out.println("Received message: " + jsonObject);
    }
}
