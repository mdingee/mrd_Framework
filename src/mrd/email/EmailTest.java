package mrd.email;

public class EmailTest {
	public static void main(String args[]) {
		MailConfig config = new MailConfig("banyan.ttifc.net", "25", "mark.dingee@ttifloorcare.com", "mdingee", "@fbii2dmt@");
		MailAgent agent = new MailAgent(config);
		
		MailMessage msg = new MailMessage();
		msg.setSubject("Mark test 1");
		msg.setMessage("Test message");
		msg.addMailTo("mark.dingee@gmail.com");
		
		try {
			agent.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
