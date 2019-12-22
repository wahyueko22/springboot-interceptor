package com.aspect.interceptor.services;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.aspect.interceptor.object.Mail;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class EmailServiceInter {
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private Configuration freemarkerConfig;

	public void sendEmail() {
		try {
			Mail mail =new Mail();
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("firstName", "David");
			model.put("lastName", "Pham");
			model.put("message", "message");
			model.put("recipient", "wahyu test@outlook.com");
			model.put("signature", "ttd");
			model.put("location", "jakarta");
			mail.setModel(model);
			Template t = freemarkerConfig.getTemplate("email-template1.ftl");
	        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());
			// SimpleMailMessage msg = new SimpleMailMessage();
			MimeMessage message = javaMailSender.createMimeMessage();
			message.setFrom("noreplay@gmail.com");
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(InternetAddress.parse("wahyu.ehs@gmail.com,wahyu.ehs3@gmail.com"));
			helper.setSubject("Test dAta");
			//for html
			helper.setText(text, true);

			javaMailSender.send(message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
