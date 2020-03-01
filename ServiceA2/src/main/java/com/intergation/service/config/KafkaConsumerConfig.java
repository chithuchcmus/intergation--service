package com.intergation.service.config;

import com.intergation.service.model.RequestB1;
import com.intergation.service.model.RequestB2;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapAddress;


    @Bean
    public Map<String, Object> consumerConfigs(){
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return props;
    }

    @Bean
    public ConsumerFactory<String, RequestB1> consumerB1Factory(){
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), new JsonDeserializer<>(RequestB1.class) );
    }

    @Bean
    public ConsumerFactory<String, RequestB2> consumerB2Factory(){
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), new JsonDeserializer<>(RequestB2.class) );
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, RequestB1> kafkaListenerB1Factory(){
        ConcurrentKafkaListenerContainerFactory<String, RequestB1> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerB1Factory());
        return factory;
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, RequestB2> kafkaListenerB2Factory(){
        ConcurrentKafkaListenerContainerFactory<String, RequestB2> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerB2Factory());
        return factory;
    }
}
