package bridge;

/**
 * Scenario: You're building a notification system that can send messages
 * via different channels (Email, SMS, Push) and
 * different priority levels (Normal, Urgent, Critical).
 */

public class NotificationSystem {
    public static void main(String[] args) {
        System.out.println("=== ENHANCED BRIDGE PATTERN DEMO ===\n");

        // Create different channels
        MessageChannel email = new EmailChannel();
        MessageChannel sms = new SmsChannel();
        MessageChannel push = new PushChannel();

        // Bridge different notifications with different channels
        System.out.println("🎯 Normal Priority:");
        new NormalNotification(email).send("Weekly report is ready");
        new NormalNotification(sms).send("Your package has shipped");

        System.out.println("\n🎯 Urgent Priority:");
        new UrgentNotification(email).send("Server CPU at 95%");
        new UrgentNotification(push).send("Security alert detected");

        System.out.println("\n🎯 Critical Priority:");
        new CriticalNotification(sms).send("DATABASE FAILURE - IMMEDIATE ACTION REQUIRED");
        new CriticalNotification(email).send("Production system offline");

        System.out.println("\n🎯 Mixed Scenarios:");
        // Same message, different priorities and channels
        new NormalNotification(sms).send("Meeting reminder");
        new UrgentNotification(sms).send("Meeting reminder");
        new CriticalNotification(sms).send("Meeting reminder");
    }

}
interface MessageChannel {
    void send(String message);
}

class EmailChannel implements MessageChannel {
    @Override
    public void send(String message) {
        System.out.println("📤 [Email] "+message);
    }
}
class SmsChannel implements MessageChannel {
    @Override
    public void send(String message) {
        System.out.println("💬 [SMS] "+message);
    }

}
class PushChannel implements MessageChannel {
    @Override
    public void send(String message) {
        System.out.println("📌 [Push] "+message);
    }
}

abstract class Notification{
    protected MessageChannel channel;

    public Notification(MessageChannel channel){
        this.channel = channel;
    }

    public final void send( String message){
        String formatedmessage = formatMessage(message);
        channel.send(formatedmessage);
    }

    protected abstract String formatMessage(String message);


}

class NormalNotification extends Notification{
    public NormalNotification(MessageChannel channel){
        super(channel);
    }
    @Override
    protected String formatMessage(String message) {
        return "😌 Normal "+ message;
    }
}
class UrgentNotification extends Notification{
    public UrgentNotification(MessageChannel channel){
        super(channel);
    }
    @Override
    protected String formatMessage(String message) {
        return "🏃🏼 Urgent "+ message;
    }
}

class CriticalNotification extends Notification{
    public CriticalNotification(MessageChannel channel){
        super(channel);
    }
    @Override
    protected String formatMessage(String message) {
        return "⚡ Critical "+message;
    }
}



