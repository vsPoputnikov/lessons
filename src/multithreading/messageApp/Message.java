package multithreading.messageApp;

import java.io.Serializable;

public class Message implements Serializable {
    private String text;
    private String sender;

    public Message(String text, String sender) {
        this.text = text;
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
