package com.example.kafkaemailsend.email.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "email_logs")
public class EmailLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailLogId;
    //이메일 받은 사용자 id
    private Long receiverUserId;
    //수신자 이메일
    private String receiverEmail;
    //이메일 제목
    private String subject;

    @Builder
    public EmailLog(Long receiverUserId, String receiverEmail, String subject) {
        this.receiverUserId = receiverUserId;
        this.receiverEmail = receiverEmail;
        this.subject = subject;
    }
}
