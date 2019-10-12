package br.com.cadevoce.AI;

import java.util.Date;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

	/**
	 * Utility method to send simple HTML email
	 * 
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public static void sendEmail(Session session, String toEmail, String subject, String body) {
		String contaEmail = "cadevoceprojeto@outlook.com"; //ou conta do google -> cadevoceprojeto@gmail.com
		
		try {
			MimeMessage msg = new MimeMessage(session);
			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(contaEmail, "NoReply-Cad� Voc�"));

			msg.setReplyTo(InternetAddress.parse(contaEmail, false));

			msg.setSubject(subject, "UTF-8");

			msg.setText(body, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Mensagem est� pronta");
			Transport.send(msg);

			System.out.println("E-mail enviado com sucesso!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
