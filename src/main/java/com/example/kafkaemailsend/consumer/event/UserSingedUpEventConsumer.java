package com.example.kafkaemailsend.consumer.event;

import com.example.kafkaemailsend.consumer.dto.UserSignUpEvent;
import com.example.kafkaemailsend.email.entity.EmailLog;
import com.example.kafkaemailsend.email.repository.EmailLogRepository;
import com.example.kafkaemailsend.email.service.EmailLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserSingedUpEventConsumer {
    private final EmailLogService emailLogService;

    @KafkaListener(
            topics = "user.signed-up",
            groupId = "email-service",
            concurrency = "3"
    )
    //재시도 정책
    @RetryableTopic(
            attempts = "5",
            backoff = @Backoff(delay = 1000, multiplier = 2),
            dltTopicSuffix = ".dlt"
    )
    public void consume(String message) throws InterruptedException {
        UserSignUpEvent userSignUpEvent = UserSignUpEvent.fromJson(message);

        ///실제 이메일 발송 로직 생략~
        String name = userSignUpEvent.getName();
        String subject = name + ": 님 회원 가입을 축하합니다, 이메일 전송 = " +  userSignUpEvent.getEmail();
        log.info(subject);
        Thread.sleep(3000);
        log.info("이메일 발송 완료");

        EmailLog emailLog = EmailLog.builder()
                .receiverUserId(userSignUpEvent.getUserId())
                .receiverEmail(userSignUpEvent.getEmail())
                .subject(subject)
                .build();

        emailLogService.save(emailLog);
    }
}
