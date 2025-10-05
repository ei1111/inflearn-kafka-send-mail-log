package com.example.kafkaemailsend.email.service;

import com.example.kafkaemailsend.email.entity.EmailLog;
import com.example.kafkaemailsend.email.repository.EmailLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailLogService {

    private final EmailLogRepository emailLogRepository;

    public EmailLog save(EmailLog emailLog) {
        return emailLogRepository.save(emailLog);
    }
}
