package com.example.kafkaemailsend.consumer.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignUpEvent {

    private Long userId;
    private String email;
    private String name;

    @Builder
    public UserSignUpEvent(Long userId, String email, String name) {
        this.userId = userId;
        this.email = email;
        this.name = name;
    }

    public static UserSignUpEvent fromJson(String json) {
        try {
            return new ObjectMapper().readValue(json, UserSignUpEvent.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json 변환 에러");
        }
    }
}
