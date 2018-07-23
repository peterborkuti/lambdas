package chapter4.fluentinterfaces;

import java.util.function.Consumer;

class MailData {
	public final String from;
	public final String subject;

	public MailData(String from, String subject) {
		this.from = from;
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "MailData{" +
				"from='" + from + '\'' +
				", subject='" + subject + '\'' +
				'}';
	}
}

public class FluentMailer {
	private String from;
	private String subject;

	private FluentMailer() {}

	public FluentMailer from(String from) {
		this.from = from;

		return this;
	}

	public FluentMailer subject(String subject) {
		this.subject = subject;

		return this;
	}

	public static void send(Consumer<FluentMailer> block, Consumer<MailData> sendService) {
		FluentMailer mailer = new FluentMailer();
		block.accept(mailer);
		sendService.accept(new MailData(mailer.from, mailer.subject));
	}
}
