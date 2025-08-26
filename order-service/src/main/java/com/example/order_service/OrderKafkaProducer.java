package com.example.order_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderKafkaProducer {
    private final KafkaTemplate<String, Order> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(OrderKafkaProducer.class);


    public OrderKafkaProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderToKafka(Order order) {
        kafkaTemplate.send("orders", order);
        logger.info("Order send to Kafka: id {}", order.orderId());
    }
}
