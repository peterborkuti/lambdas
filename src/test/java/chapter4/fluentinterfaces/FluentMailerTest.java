package chapter4.fluentinterfaces;

import org.junit.Test;

import static org.junit.Assert.*;

public class FluentMailerTest {
	private String from = "BP";
	private String subject = "interesting topic";

	@Test
	public void send() {
		FluentMailer.send(
				mailer -> mailer.from(from).subject(subject), this::testMailData);
	}

	private void testMailData(MailData mailData) {
		assertEquals(from, mailData.from);
		assertEquals(subject, mailData.subject);
	}
}