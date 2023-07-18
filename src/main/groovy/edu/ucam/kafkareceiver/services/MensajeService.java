package edu.ucam.kafkareceiver.services;

import edu.ucam.kafkareceiver.entity.Mensaje;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MensajeService {

    @KafkaListener(topics = "test_topic")
    public void receiveMessage(Mensaje mensaje) {
        System.out.println("Mensaje recibido: " + mensaje.getId() + " fecha: " + mensaje.getDate() + " mensaje: " + mensaje.getMensaje());
    }
}
