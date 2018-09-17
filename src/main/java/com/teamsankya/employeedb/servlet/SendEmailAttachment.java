package com.teamsankya.employeedb.servlet;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmailAttachment
{
	public void sendEmail(String email) 
	{
		 Properties props=new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "mail.teamsankya.com");
	        props.put("mail.smtp.port", "587");
	        
	        Session session=Session.getInstance(props,new javax.mail.Authenticator()
	        		{
	        			protected PasswordAuthentication getPasswordAuthentication() 
	        			{
	        				return new PasswordAuthentication("nikhil.mi@teamsankya.com", "njm.xH,c?7[+");
	        			}
	        		});
	        Message message=new MimeMessage(session);
	        try 
	        {
				InternetAddress address=new InternetAddress("nikhil.mi@teamsankya.com");
				InternetAddress[] addresses= {address};
				message.addFrom(addresses);
				message.setRecipient(RecipientType.TO, new InternetAddress(email));
				message.setSubject("Welcome To TeamSankya.pvt.ltd");
				// Create the message part and set actual message
				BodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText("Employee Notification");
				// Create a multipar message and set text message part
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);
				// Part two is attachment
				messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText("\n"+"YOUR DATA HAS BEEN REGISTERED SUCCESSFULLY....!");
				
				
				/*
				DataSource source = new FileDataSource("C:\\Users\\MI_NIKHIL\\Desktop\\myface.jpg");
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName("source");
				*/
				multipart.addBodyPart(messageBodyPart);
				// Send the complete message parts
				message.setContent(multipart);
				// Send message
				Transport.send(message);
				System.out.println("Sent message successfully....");
	        
	        
	        
	        }catch(Exception e) {e.printStackTrace();}

	}
	

}
