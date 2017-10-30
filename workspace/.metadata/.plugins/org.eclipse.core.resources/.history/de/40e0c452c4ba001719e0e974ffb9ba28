package util;
/*
 * For the use of Mail Validation
 * Sign-Up, 'Forgot Password?'
 */
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.dao.member.MemberDAO;  


public class MailSender {
	private static final String HOST = "localhost";
	private static final String MAIL_ID = "cocoanotemail@gmail.com";
	private static final String MAIL_PW = "tempPassword";
	
	private static MailSender ms = new MailSender();
	private MailSender() {}
	public static MailSender getInstance() {
		return ms;
	}
	public static void sendMail(String id, String command, String schedule_name) {
		Session session = null;
		MimeMessage msg = null;
		
		try {
				Properties props = new Properties();
				// SSL 사용하는 경우
				props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
				props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
				props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
				props.put("mail.smtp.port", "465"); //SMTP Port

				// TLS 사용하는 경우
				props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
				props.put("mail.smtp.port", "587"); //TLS Port
				props.put("mail.smtp.auth", "true"); //enable authentication
				props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

				// 인증
				System.out.println("[MailSender] Starting Password Auth...");
				Authenticator auth = new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(MAIL_ID, MAIL_PW);
					}
				};

				// 메일 세션
				System.out.println("[MailSender] Starting Mail Session...");
				session = Session.getInstance(props, auth);
				msg = new MimeMessage(session);

				msg.setFrom(new InternetAddress(MAIL_ID));
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(id, false));
				String body = null;
				
				switch(command) {
					case "forgotPasword": {
						System.out.println();
						// tempPassword Logic
						String tempPassword = null;
						tempPassword = id+(int)(Math.random()*1000000 +1);
						// set tempPassword
						body = "Your Temporary Password for " +id + " : " + tempPassword;

						MemberDAO.getInstance().updateMember(MemberDAO.getInstance().findMemberById(id), tempPassword);
						msg.setSubject("[CocoaNote] : " +id +", Temporary Password !", "UTF-8");
						break;
					}
					case "share_added" : {
						body = "You've been added to a schedule :" + schedule_name;
						msg.setSubject("[CocoaNote] : " + id +", check your new schedule !", "UTF-8");
						break;
					}
				}

				
				msg.setText(body, "UTF-8");
				msg.setSentDate(new Date());


				System.out.println("Message is ready");

				Transport transport = session.getTransport("smtps");
				transport.connect("smtp.gmail.com", MAIL_ID, MAIL_PW);
				transport.sendMessage(msg, msg.getAllRecipients());
				transport.close();   

				System.out.println("[MailSender] : Email Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
