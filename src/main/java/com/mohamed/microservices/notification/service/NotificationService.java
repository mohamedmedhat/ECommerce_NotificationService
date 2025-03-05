package com.mohamed.microservices.notification.service;

import com.mohamed.microservices.notification.Order.OrderPlacedEvent;
import com.mohamed.microservices.notification.email.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final EmailService emailService;

    @KafkaListener(topics = "order-placed")
    public void listen(OrderPlacedEvent orderPlacedEvent){
        log.info("Got a message form order-placed topic {}", orderPlacedEvent);
        this.emailService.sendEmailToUser(orderPlacedEvent);
    }
}
