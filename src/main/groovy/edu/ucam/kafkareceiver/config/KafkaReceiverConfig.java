package edu.ucam.kafkareceiver.config;

import edu.ucam.kafkareceiver.entity.Mensaje;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaReceiverConfig {

    private final String bootstrapAddress = "localhost:9092";

    @Bean
    public ConsumerFactory<String, Mensaje> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "edu.ucam.kafkasender.entity, edu.ucam.kafkareceiver.entity");

        final JsonDeserializer<Mensaje> jsonDeserializer = new JsonDeserializer<>(Mensaje.class);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), jsonDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Mensaje>
    kafkaListenerContainerFactory(){

        ConcurrentKafkaListenerContainerFactory<String, Mensaje> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
