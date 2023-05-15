package com.example.service.member;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.example.service.RedisUtil;

import io.lettuce.core.RedisURI;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {
    
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;
    private final RedisUtil redisUtil;
    private String authNum;

    // 1. 랜덤 인증 코드 생성 => 8자리 인증코드 무작위 생성
    public void createAuthNum() {
        Random random = new Random();
        StringBuffer key = new StringBuffer();

        for(int i=0; i<8; i++) {
            int index = random.nextInt(3);

            switch(index) {
                case 0 :
                    key.append((char)((int)random.nextInt(26)+97));
                    break;
                case 1 :
                    key.append((char)((int)random.nextInt(26)+65));
                    break;
                case 2 :
                    key.append(random.nextInt(9));
                    break;
            }
        }
        authNum = key.toString();
    }

    // 2. 메일 양식 작성
    public MimeMessage createEmailForm(String email) throws MessagingException, UnsupportedEncodingException {

        createAuthNum(); // 인증 코드 생성
        String setForm = "shmjo6417@gmail.com"; // email=config에서 설정한 이메일 주소
        String toEmail = email; // 받는 사람
        String title = "SPECIALDAY 비밀번호 찾기 인증 번호"; // 제목

        MimeMessage message = mailSender.createMimeMessage();
        message.addRecipients(MimeMessage.RecipientType.TO, toEmail); // 보낼 이메일 설정
        message.setSubject(title); // 제목 설정
        message.setFrom(setForm);  // 보내는 이메일
        message.setText(setContext(authNum), "utf-8", "html");

        return message;
    }

    // 3. thymeleaf 이용 context 설정
    public String setContext(String code) {

        Context context = new Context();
        context.setVariable("code", code);
        return templateEngine.process("mail", context); // mail.html

    }

    // 4. 실제 메일 전송
    public String sendEmail(String toEmail) throws MessagingException, UnsupportedEncodingException {

        MimeMessage emailForm = createEmailForm(toEmail); // 메일 전송에 필요한 정보 설정
        redisUtil.setDataExpire(authNum, toEmail, 60 * 3L);
        
        mailSender.send(emailForm); // 실제 메일 전송

        return authNum; // 인증 코드 반환

    }

    // 5. 인증 번호로 유효한 인증 번호인지 확인
    //public String verifyEmail(String key) throws 

}
