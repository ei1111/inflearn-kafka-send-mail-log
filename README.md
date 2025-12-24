# spring-kafka-Consumer-signup-mail

Spring Kafka를 활용하여 **회원 가입 이벤트 발생 시 이메일 발송을 처리하는 Kafka Consumer API 프로젝트**입니다.  
재시도 정책과 Dead Letter Topic(DLT)을 적용하여  
메시지 처리 실패 상황까지 고려한 비동기 이벤트 소비 구조를 학습·구현했습니다.

---

## 프로젝트 목적

- Spring Kafka 기반 비동기 이벤트 처리 학습
- Kafka Consumer 재시도(Retry) 및 DLT 처리 이해
- 회원 가입 로직과 이메일 발송 로직 분리
- 이벤트 기반 아키텍처 설계 경험

---

## 기술 스택

### Backend

- **Java:** 21  
- **Spring Boot:** 3.5.6  
- **Spring Data JPA**
- **Spring Kafka**
- **Build Tool:** Gradle  

### Database

- **H2 Database** (In-Memory)

### Messaging

- **Apache Kafka**

---

## 기능 개요

### 회원 가입 이벤트 소비 (Consumer)

- Kafka Topic으로부터 회원 가입 이벤트 수신
- 이메일 발송 로직 처리 (실제 메일 발송은 로그로 대체)
- 이메일 발송 이력 DB 저장
- 처리 실패 시 재시도 및 DLT 전송

---

## Kafka Consumer 설정

### Listener 설정

- **Topic:** `user.signed-up`
- **Consumer Group:** `email-service`
- **Concurrency:** 3 (병렬 처리)

```java
@KafkaListener(
    topics = "user.signed-up",
    groupId = "email-service",
    concurrency = "3"
)
