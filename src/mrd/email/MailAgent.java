package mrd.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.Message.RecipientType;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

public class MailAgent {
	/**
	 * @uml.property  name="session"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Session session;
	/**
	 * @uml.property  name="props"
	 * @uml.associationEnd  qualifier="constant:java.lang.String java.lang.String"
	 */
	private Properties props; 
	/**
	 * @uml.property  name="config"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private MailConfig config;
	
	public MailAgent(MailConfig config) {
		props = new Properties();
		props.put("mail.smtp.host", config.getHost());
		props.put("mail.smtp.port", config.getPort());
		props.put("mail.smtp.auth", "true");
		this.config = config;
		
		session = Session.getInstance(props, getAuthenticator());
		
	}

	private Authenticator getAuthenticator() {
		return new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {	
				return new PasswordAuthentication(config.getMailUser(), config.getMailPassword()); }};
	}
	
	public void send(MailMessage message) throws MessagingException {
		System.out.println("MailTo = " + message.getMailTo());
		//System.out.println();
		//System.out.println();
		
		Message msg = new MimeMessage(session);
		java.util.List<java.util.Map<String, String>> headers_tSendMail_1 = new java.util.ArrayList<java.util.Map<String, String>>();
		
		msg.setFrom(new InternetAddress(config.getMailFrom()));
		msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(message.getMailTo(),false));
		
		if (message.getMailCc() != null)
			msg.setRecipients(RecipientType.CC,InternetAddress.parse(message.getMailCc(), false));
		
		if (message.getMailBcc() != null)
			msg.setRecipients(Message.RecipientType.BCC,InternetAddress.parse(message.getMailBcc(), false));

		msg.setSubject(message.getSubject());

		for (int i_tSendMail_1 = 0; i_tSendMail_1 < headers_tSendMail_1.size(); i_tSendMail_1++) {
			java.util.Map<String, String> header_tSendMail_1 = headers_tSendMail_1.get(i_tSendMail_1);
			msg.setHeader(header_tSendMail_1.get("KEY"),header_tSendMail_1.get("VALUE"));
		}

		msg.setSentDate(new Date());
		MimeMultipart mp_tSendMail_1 = new MimeMultipart();
		javax.mail.internet.MimeBodyPart mbpText_tSendMail_1 = new javax.mail.internet.MimeBodyPart();
		mbpText_tSendMail_1.setText(message.getMessage());
		mp_tSendMail_1.addBodyPart(mbpText_tSendMail_1);

		for (int i_tSendMail_1 = 0; i_tSendMail_1 < message.getAttachments().size(); i_tSendMail_1++) {
			String filename_tSendMail_1 = message.getAttachments().get(i_tSendMail_1);
			MimeBodyPart mbpFile_tSendMail_1 = new MimeBodyPart();

			javax.activation.FileDataSource fds_tSendMail_1 = new javax.activation.FileDataSource(filename_tSendMail_1);
			mbpFile_tSendMail_1.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_1));
			mbpFile_tSendMail_1.setFileName(fds_tSendMail_1.getName());
			mp_tSendMail_1.addBodyPart(mbpFile_tSendMail_1);
		}

		// -- set the content --
		msg.setContent(mp_tSendMail_1);

		// -- Send the message --
		javax.mail.Transport.send(msg);

	}
}
