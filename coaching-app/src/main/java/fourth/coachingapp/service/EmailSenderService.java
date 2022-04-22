package fourth.coachingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailSenderService
{
	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(
			String toEmail,
			String subject,
			String body)
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("${spring.mail.username}");
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);

		mailSender.send(message);
		System.out.println("Message Sent Successfully");
	}
}
