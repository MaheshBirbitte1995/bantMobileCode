package com.mqa.btr.mail;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Javamail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 final String username = "satyanarayana.cheera@uncode.io";
		    final String password = "Satyam@123";

		    Properties props = new Properties();
		    props.put("mail.smtp.auth", true);
		    props.put("mail.smtp.starttls.enable", true);
		    props.put("mail.smtp.host", "smtp-relay.gmail.com");  //smtp.gmail.com
		    props.put("mail.smtp.port", "587");  //587

		    Session session = Session.getInstance(props,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(username, password);
		                }
		            });

		    try {

		        Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress("satyanarayana.cheera@uncode.io"));
		        message.setRecipients(Message.RecipientType.TO,
		                InternetAddress.parse("shiva.lanke@uncode.io"));
		        message.setSubject("Testing Subject");
		        message.setText("PFA");

		        MimeBodyPart messageBodyPart = new MimeBodyPart();

		        Multipart multipart = new MimeMultipart();
		        
		        String file = "C:\\Users\\satyanarayanac\\Documents\\AppiumScreens\\Inbox.jpg";
		        String fileName = "Inbox.jpg";
		        DataSource source = new FileDataSource(file);
		        messageBodyPart.setDataHandler(new DataHandler(source));
		        messageBodyPart.setFileName(fileName);
		        multipart.addBodyPart(messageBodyPart);

		        message.setContent(multipart);

		        System.out.println("Sending");

		        Transport.send(message);

		        System.out.println("Done");

		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }

	}

}
