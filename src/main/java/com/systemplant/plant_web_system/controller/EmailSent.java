//package com.systemplant.plant_web_system.controller;
//import com.systemplant.plant_web_system.Entity.User;
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import jakarta.mail.internet.MimeMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
//
//import java.nio.charset.StandardCharsets;
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class EmailSent {
//    private final JavaMailSender getJavaMailSender;
//
//    @Autowired
//    @Qualifier("emailConfigBean")
//    private Configuration emailConfig;
//
//    public EmailSent(JavaMailSender getJavaMailSender) {
//        this.getJavaMailSender = getJavaMailSender;
//    }
//
//    public void sendResetEmail(User user) throws Exception {
//        try {
//            MimeMessage message = getJavaMailSender.createMimeMessage();
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,
//                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
//            Template template = emailConfig.getTemplate("Notification.ftl");
//
//
//            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
//            mimeMessageHelper.setTo("aayush@yopmail.com");
//            mimeMessageHelper.setText(html, true);
//            mimeMessageHelper.setSubject("for notification");
//            mimeMessageHelper.setFrom("fromme@yopmail.com");
////            taskExecutor.execute(new Thread() {
////                public void run() {
//                    getJavaMailSender.send(message);
////                }
////            });
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception(e.getMessage());
//        }
//    }
//}
