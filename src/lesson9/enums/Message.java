package lesson9.enums;

import java.util.*;

enum MessagePriority{
    LOW, MEDIUM, HIGH, URGENT;

    public static MessagePriority getPriority(int ord){
        for (MessagePriority mp: values()){
            if (ord == mp.ordinal()){
                return mp;
            }
        }
        throw new AssertionError(("Wrong ordinal: " + ord));
    }
}



public class Message {
    private int code;
    private MessagePriority priority;

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", priority=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Message message = (Message) object;

        if (code != message.code) return false;
        return priority == message.priority;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public MessagePriority getPriority() {
        return priority;
    }

    public void setPriority(MessagePriority priority) {
        this.priority = priority;
    }

    public Message(int code, MessagePriority priority) {
        this.code = code;
        this.priority = priority;
    }

    public static void main(String[] args) {
        System.out.println(MessagePriority.LOW);
        System.out.println(MessageGenerator.generate(34));
    }
}

class MessageGenerator{
    public static List<Message> generate(int num){
        if (num<=0)
            return Collections.emptyList();

        Random random = new Random();
        List<Message> messages = new ArrayList<>(num);

        int typesCount = MessagePriority.values().length;

        for (int i = 0; i < num ; i++) {
            messages.add(new Message(random.nextInt(10), MessagePriority.getPriority(random.nextInt(typesCount))));
        }
        return messages;

    };
}