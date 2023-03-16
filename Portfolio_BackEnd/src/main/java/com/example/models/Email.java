package com.example.models;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;

@Component
public class Email {
	Session newSession=null;
	MimeMessage mimeMessage =null;
	
	MailMessage mymessage; 
	String recepient="";
	
	public Email() {}
	
	
	public Email(String to, MailMessage message) throws AddressException, MessagingException, IOException {
		mymessage=message; 
		recepient=to;
		setupServerProperties();
		
	}
	
	 public void sendEmail() throws MessagingException, IOException {
		 
		draftEmail();
		 
 
		String fromUser= System.getenv("PORTFOLIO_GMAIL_USERNAME");
		String fromUserPassword= System.getenv("PORTFOLIO_GMAIL_PASSWORD");
		
		String emailHost= "smtp.gmail.com";
		
		Transport transport = newSession.getTransport("smtp");
		transport.connect(emailHost,fromUser,fromUserPassword);
		transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
		transport.close();  
		
	}

	private MimeMessage draftEmail() throws AddressException,MessagingException,IOException{
	  
		mimeMessage=new MimeMessage(newSession); 
		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(this.recepient) );
		mimeMessage.setSubject(this.mymessage.getSubject()); 
		mimeMessage.setText("New Message from Porfolio website, info bellow \n"+mymessage.toString()); 
		return mimeMessage; 
	
	}

	private void setupServerProperties() {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		newSession = Session.getDefaultInstance(properties,null);
		
	}

}
