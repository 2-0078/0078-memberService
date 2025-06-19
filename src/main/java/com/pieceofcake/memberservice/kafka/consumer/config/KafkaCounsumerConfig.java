package com.pieceofcake.memberservice.kafka.consumer.config;

import com.pieceofcake.memberservice.kafka.consumer.event.SignUpEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class KafkaCounsumerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    /**
     * 공통 consumer config 설정
     */
    @Bean
    public Map<String, Object> signUpConsumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "member-signup-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*"); // 또는 "com.pieceofcake.*"
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, SignUpEvent.class);
        return props;
    }

    /**
     * Kafka ConsumerFactory 설정
     */
    @Bean
    public ConsumerFactory<String, SignUpEvent> signUpConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                signUpConsumerConfigs(),
                new StringDeserializer(),
                new ErrorHandlingDeserializer<>(new JsonDeserializer<>(SignUpEvent.class, false))
        );
    }

    /**
     * KafkaListenerContainerFactory 설정
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, SignUpEvent> signUpListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, SignUpEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(signUpConsumerFactory());
        return factory;
    }
}
