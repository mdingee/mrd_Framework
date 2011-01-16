package mrd.email;

import java.util.Vector;

public class MailMessage {
	/**
	 * @uml.property  name="mailTo"
	 */
	private Vector <String> mailTo;
	/**
	 * @uml.property  name="mailCc"
	 */
	private Vector <String> mailCc;
	/**
	 * @uml.property  name="mailBcc"
	 */
	private Vector <String> mailBcc;
	/**
	 * @uml.property  name="message"
	 */
	private String message;
	/**
	 * @uml.property  name="subject"
	 */
	private String subject;
	/**
	 * @uml.property  name="attachments"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
	 */
	private Vector<String> attachments;
	
	public MailMessage() {
		this.attachments = new Vector<String>();
		this.mailTo = new Vector<String>();
		this.mailCc = new Vector<String>();
		this.mailBcc = new Vector<String>();
	}
	
	public MailMessage(String mailTo, String subject, String message) {
		this();
		addMailTo(mailTo);
		this.subject = subject;
		this.message = message;
	}
	
	public void addAttachment(String filename) { this.attachments.add(filename); }
	 
	public void addMailBcc(String mailBcc) { this.mailCc.addAll(string2vector(mailBcc)); }

	public void addMailCc(String mailCc) { this.mailCc.addAll(string2vector(mailCc)); }

	public void addMailTo(String mailTo) { this.mailTo.addAll(string2vector(mailTo)); }
	
	public Vector <String> getAttachments() { return this.attachments; }
	
	public String getMailBcc() { return vector2string(this.mailBcc); }
	
	public String getMailCc() { return vector2string(this.mailCc); }

	public String getMailTo() { return vector2string(this.mailTo); }

	/**
	 * @return
	 * @uml.property  name="message"
	 */
	public String getMessage() { return message; }
	
	/**
	 * @return
	 * @uml.property  name="subject"
	 */
	public String getSubject() { return subject; }

	/**
	 * @param message
	 * @uml.property  name="message"
	 */
	public void setMessage(String message) { this.message = message; }

	/**
	 * @param subject
	 * @uml.property  name="subject"
	 */
	public void setSubject(String subject) { this.subject = subject; }

	private Vector <String> string2vector(String s) {
		Vector <String> rslt = new Vector <String>();
		if(s == null) return rslt;
		String temp = s.replace(";", ",");
		String[] arr = temp.split(",");
		
		for(int i = 0; i < arr.length; i++)
			rslt.add(arr[i]);
		
		return rslt;
	}

	private String vector2string(Vector <String> v) {
		String rslt = null;
		
		for(int i = 0; i < v.size(); i++)
			rslt = (rslt == null ? "" : rslt + ",") + v.get(i);
		
		return rslt;
	}
}
