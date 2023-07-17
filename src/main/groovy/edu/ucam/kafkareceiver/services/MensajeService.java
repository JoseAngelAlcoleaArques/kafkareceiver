package edu.ucam.kafkareceiver.services;

import edu.ucam.kafkareceiver.entity.Mensaje;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MensajeService {

    @KafkaListener(
            topics = "test_topic",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo1")
    public void consumer (Mensaje mensaje) {
        if (mensaje.getClass().isAssignableFrom(Mensaje.class)) {
            System.out.println("Datos recibidos: id = " + mensaje.getId() + " mensaje = " + mensaje.getMensaje() + " fecha = " +mensaje.getDate());
        }
    }
}
