package com.example.order_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final OrderKafkaProducer kafkaProducer;

    public OrderService(OrderKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public void saveOrder(Order order) {
        // saving to Database..
        kafkaProducer.sendOrderToKafka(order);
        logger.info("Order successfully saved: id={}", order.orderId());
    }
}
