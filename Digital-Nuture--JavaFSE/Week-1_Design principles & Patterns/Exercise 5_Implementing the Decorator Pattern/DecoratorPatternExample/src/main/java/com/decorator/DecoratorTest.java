package com.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        // Create base email notifier
        System.out.println("1. Sending notification via Email only:");
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Hello, this is a test message!");
        System.out.println();

        // Add SMS notification
        System.out.println("2. Sending notification via Email and SMS:");
        Notifier emailAndSMSNotifier = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSMSNotifier.send("Hello, this is a test message!");
        System.out.println();

        // Add Slack notification
        System.out.println("3. Sending notification via Email and Slack:");
        Notifier emailAndSlackNotifier = new SlackNotifierDecorator(new EmailNotifier());
        emailAndSlackNotifier.send("Hello, this is a test message!");
        System.out.println();

        // Combine all notification methods
        System.out.println("4. Sending notification via all channels:");
        Notifier allNotifiers = new SlackNotifierDecorator(
                                new SMSNotifierDecorator(
                                    new EmailNotifier()));
        allNotifiers.send("Hello, this is a test message!");
    }
}
