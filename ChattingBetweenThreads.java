import java.util.Scanner;

class Chat {
    private String message;
    private boolean isExit = false;

    public synchronized void sendMessage(String msg) {
        message = msg;
        if (msg.equalsIgnoreCase("exit")) {
            isExit = true;
        }
        notify(); 
    }

    public synchronized String receiveMessage() throws InterruptedException {
        while (message == null) {
            wait(); 
        }
        String receivedMessage = message;
        message = null; 
        return receivedMessage;
    }

    public synchronized boolean isExit() {
        return isExit;
    }
}

class Person1Thread extends Thread {
    private Chat chat;
    private Scanner scanner;

    public Person1Thread(Chat chat, Scanner scanner) {
        this.chat = chat;
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            System.out.println("Person 1: Enter message to send to Person 2 (or type 'exit' to quit): ");
            String msg = scanner.nextLine();
            chat.sendMessage(msg);  
            System.out.println("Person 1 sent: " + msg);
            if (msg.equalsIgnoreCase("exit")) {
                break;  
            }

            try {
                String reply = chat.receiveMessage(); 
                System.out.println("Person 1 received: " + reply);
                if (reply.equalsIgnoreCase("exit")) {
                    break;  
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Person2Thread extends Thread {
    private Chat chat;

    public Person2Thread(Chat chat) {
        this.chat = chat;
    }

    public void run() {
        while (true) {
            try {
                String msg = chat.receiveMessage();  
                System.out.println("Person 2 received: " + msg);
                if (msg.equalsIgnoreCase("exit") || chat.isExit()) {
                    System.out.println("Person 2 is exiting.");
                    break;  
                }

                System.out.println("Person 2: Enter message to send to Person 1 (or type 'exit' to quit): ");
                String reply = new Scanner(System.in).nextLine();
                chat.sendMessage(reply);  
                System.out.println("Person 2 sent: " + reply);
                if (reply.equalsIgnoreCase("exit")) {
                    break;  
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ChattingBetweenThreads {
    public static void main(String[] args) {
        Chat chat = new Chat();
        Scanner scanner = new Scanner(System.in);

        Person1Thread person1 = new Person1Thread(chat, scanner);
        Person2Thread person2 = new Person2Thread(chat);

        person1.start();
        person2.start();
    }
}