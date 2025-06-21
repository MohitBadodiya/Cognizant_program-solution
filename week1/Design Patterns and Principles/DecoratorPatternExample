public class  DecoratorPatternExample{
    public static void main(String[] args) {
        Notifier notif1 = new EmailNotifier();
        notif1.send("Hello!");

        System.out.println();

        Notifier notif2 = new SMSDecorator(new EmailNotifier());
        notif2.send("Hello!");

        System.out.println();

        Notifier notif3 = new SlackDecorator(new SMSDecorator(new EmailNotifier()));
        notif3.send("Hello!");
    }
}

interface Notifier {
    void send(String msg);
}

class EmailNotifier implements Notifier {
    public void send(String msg) {  
        System.out.println("Email: " + msg);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;
    public NotifierDecorator(Notifier n) {
notifier = n; 
}
    public void send(String msg) { 
notifier.send(msg);
}
}

class SMSDecorator extends NotifierDecorator {
    public SMSDecorator(Notifier n) { super(n); }
    public void send(String msg) {
        super.send(msg);
        System.out.println("SMS: " + msg);
    }
}

class SlackDecorator extends NotifierDecorator {
    public SlackDecorator(Notifier n) { super(n); }
    public void send(String msg) {
        super.send(msg);
        System.out.println("Slack: " + msg);
    }
}

