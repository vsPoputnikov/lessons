package lesson6.object;

import java.util.Objects;

public class Message implements Cloneable {
    private String messageText;
    private Author author;

    public Message(String messageText, Author author) {
        this.messageText = messageText;
        this.author = author;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Message)) return false;
        Message message = (Message) object;
        return Objects.equals(getMessageText(), message.getMessageText()) &&
                Objects.equals(getAuthor(), message.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessageText(), getAuthor());
    }

    public Message() {
    }

    public Message(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageText() {
        return messageText;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageText='" + messageText + '\'' +
                ", author=" + author +
                '}';
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
