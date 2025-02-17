package ch13.sec02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Message> messageQueue = new LinkedList<>();

        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKaKaoTalk", "홍두께"));
        
        while (!messageQueue.isEmpty()) {
            Message message = messageQueue.poll();
            switch (message.command) {
                case "sendMail":
                    System.out.println(message.to + "님께 메일을 보냅니다.");
                    break;
                case "sendSMS":
                    System.out.println(message.to + "님께 SMS을 보냅니다.");
                    break;
                case "sendKaKaoTalk":
                    System.out.println(message.to + "님께 카카오톡을 보냅니다.");
                    break;
            
                default:
                    break;
            }
        }
    }
}
