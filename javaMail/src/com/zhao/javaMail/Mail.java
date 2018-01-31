package com.zhao.javaMail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.Test;

public class Mail
{
	@Test
	public void sendMail() throws AddressException, MessagingException
	{
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.smtp.auth", "true");
		Authenticator authenticator = new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication("zyldomain", "zhao1998");
			}
			
		};
		Session session = Session.getInstance(prop, authenticator);
		
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("zyldomain@163.com"));
		msg.setRecipients(RecipientType.TO, "zylboxer@163.com");
		msg.setSubject("Test");
		msg.setContent("一封垃圾邮件","text/html;charst=utf-8");
		Transport.send(msg);
	}
	@Test
	public void send() throws AddressException, MessagingException
	{
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.smtp.auth", "true");
		Authenticator authenticator = new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication("zyldomain", "zhao1998");
			}
			
		};
		Session session = Session.getInstance(prop, authenticator);
		
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("zyldomain@163.com"));
		msg.setRecipients(RecipientType.TO, "zylboxer@163.com");
		msg.setSubject("Test");
		MimeMultipart list = new MimeMultipart();
		MimeBodyPart part1 = new MimeBodyPart();
		part1.setContent("一封垃圾邮件","text/html;charst=utf-8");
		list.addBodyPart(part1);
		MimeBodyPart part2 = new MimeBodyPart();
		msg.setContent(list);
		Transport.send(msg);
	}
}












