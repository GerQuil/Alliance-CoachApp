package fourth.coachingapp.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService
{
	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(
			String toEmail,
			String subject,
			String body,
			String attachment)
	{
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		try
		{
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom("${spring.mail.username}");
			mimeMessageHelper.setTo(new String [] { toEmail, "jillallera@gmail.com" });
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(body);

			FileSystemResource fileSystem = new FileSystemResource(new File(attachment + ".pdf"));
			mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);

			mailSender.send(mimeMessage);
			System.out.println("Message Sent Successfully");
		}
		catch (MessagingException e)
		{
			// TODO Auto-generated catch block
			e.getMessage();
		}

	}
}
