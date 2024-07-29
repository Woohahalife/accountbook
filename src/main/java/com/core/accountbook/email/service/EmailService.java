package com.core.accountbook.email.service;

import com.core.accountbook.member.domain.repository.MemberRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final MemberRepository memberRepository;

    public void sendEmail(String email, String name) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            mimeMessageHelper.setTo(email); // 메일 수신자
            mimeMessageHelper.setSubject(name + "님의 가계부 회원가입을 축하합니다!"); // 메일 제목

            // HTML 템플릿 로딩
            String htmlContent = loadTemplate("templates/welcome-email-form.html")
                    .replace("{{name}}", name);

            mimeMessageHelper.setText(htmlContent, true); // 메일 본문 내용, HTML 여부

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String loadTemplate(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(new ClassPathResource(path).getURI())));
    }
}
