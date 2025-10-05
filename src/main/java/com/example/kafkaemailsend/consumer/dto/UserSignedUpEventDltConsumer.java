package com.example.kafkaemailsend.consumer.dto;

import com.example.kafkaemailsend.email.entity.EmailLog;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserSignedUpEventDltConsumer {
    @KafkaListener(
            topics = "user.singed-up.dlt",
            groupId = "email-service"
    )
    public void consume(String message) {
        //로직 생략
        System.out.println("로그 시스템 전송 = " + message);
        System.out.println("slack에 알림 전송");
    }
}
