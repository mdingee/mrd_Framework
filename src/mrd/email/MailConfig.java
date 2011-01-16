package mrd.email;

public class MailConfig {
	/**
	 * @uml.property  name="host"
	 */
	String host;
	/**
	 * @uml.property  name="port"
	 */
	String port;
	/**
	 * @uml.property  name="mailFrom"
	 */
	String mailFrom;
	/**
	 * @uml.property  name="username"
	 */
	String username;
	/**
	 * @uml.property  name="password"
	 */
	String password;
	
	public MailConfig(String host, String port, String mailFrom, String username, String password) {
		this.host = host;
		this.port = port;
		this.mailFrom = mailFrom;
		this.username = username;
		this.password = password;
	}

	/**
	 * @return
	 * @uml.property  name="host"
	 */
	public String getHost() { return host; }

	/**
	 * @return
	 * @uml.property  name="port"
	 */
	public String getPort() { return port; }

	/**
	 * @return
	 * @uml.property  name="mailFrom"
	 */
	public String getMailFrom() { return mailFrom; }
	
	public String getMailUser() { return username; }
	
	public String getMailPassword() { return password; }
}
