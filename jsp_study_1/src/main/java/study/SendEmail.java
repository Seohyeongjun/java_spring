package study;

import javax.mail.PasswordAuthentication;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.mail.Message;

public class SendEmail {

	public static void sendEmail(String fromEmail, String title, String content) {
		// ���Ǳ� ��ϵǸ� ������ �̸��Ϸ� �����ϱ� 
		
		// ������ �̸��� ���� ����
		final String adminEmail = "s25hj936@naver.com";
		final String password = "5BK7W8WQH8B7";
		
		// ������ �̸��� ȯ�漳�� ���
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.naver.com");	// smtp������
		prop.put("mail.smtp.port", "587");		// smtp��Ʈ��ȣ
		prop.put("mail.smtp.starttls.enable", "true"); //tls��뿩��
		prop.put("mail.smtp.auth", "true");	// smtp��������
		
		// ���Ǳ��� ��ϵǸ�� ������ �̸��Ϸ� ���� �Ǿ�� �Ѵ�. 
		// ������ ������޴� ����� �ʿ��ѵ� ������ ����� Ŭ���̾�Ʈ������ ���� Ŭ���̾�Ʈ ���Ͽ��� �߼۵Ǵ°� �ƴ϶�
		// �ڹٿ��� �߼��ϴ� ���̱� ������ �����ڰ� ������ �ް��� �ؾ��Ѵ�. 
		Session adminAuth = Session.getInstance (prop, new javax.mail.Authenticator() {
									protected PasswordAuthentication getPasswordAuthentication() {
										return new PasswordAuthentication(adminEmail, password);
										}
									});
	
		try {
			MimeMessage msg = new MimeMessage(adminAuth);
			msg.setFrom( new InternetAddress(adminEmail));	//������ �̸��� �ּ�
			
			msg.setHeader("Content-Tupe",  "text/html;charset=utf-8");
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(adminEmail));	// �޴� �̸����ּ�
			
			msg.setHeader("Content-Type", "text/html;charset=utf-8");
			msg.setSubject("���� �� ��� ["+title+"]-"+fromEmail);	// �̸��� ����
			
			
			msg.setContent(
					"<h3>���� ����</h3><b>"+content+"</b> "
					+ "<div><a href ='http://localhost:8080/jsp_study_1/study/?part=inquiry'>"
					+"���Ǳ� Ȯ��</a></div>", "text/html;charset=utf-8");
			
			Transport.send(msg);	//���� ����
			
		}catch(MessagingException e) {
			e.printStackTrace();
			System.out.println("�̸��� ���� ����");;
		}
		
		
	}	

}