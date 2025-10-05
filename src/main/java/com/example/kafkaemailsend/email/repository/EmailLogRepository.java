package com.example.kafkaemailsend.email.repository;

import com.example.kafkaemailsend.email.entity.EmailLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailLogRepository extends JpaRepository<EmailLog, Long> {

}
