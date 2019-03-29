package homework9;

import java.lang.reflect.Array;
import java.util.*;

public class Problem9_6MessageTask {
    public static void solve(){
       List<Message> messages = MessageGenerator.generate(10);
        print(messages);
        countEachPriority(messages);
        countEachCode(messages);
        uniqueMessageCount(messages);
        print(uniqueMessagesInOriginalOrder(messages));
        removeEach(messages, MessagePriority.MEDIUM);
        removeOther(messages, MessagePriority.MEDIUM);

    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        ArrayList<Message> msgList = new ArrayList<>(messageList);
        for (int i = 0; i < msgList.size() ; i++) {
            if(msgList.get(i).getPriority()!=priority){
                msgList.remove(i);
                i--;
            }
        }
        print(msgList);
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        ArrayList<Message> msgList = new ArrayList<>(messageList);
        for (int i = 0; i < msgList.size() ; i++) {
               if(msgList.get(i).getPriority()==priority){
               msgList.remove(i);
               i--;
            }
        }
        print(msgList);
    }

    public static LinkedHashSet<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        LinkedHashSet<Message> uniqueMessages = new LinkedHashSet<>(messageList);

        //System.out.println(uniqueMessages.size());

        // вернуть только неповторяющиеся сообщения и в том порядке, в котором они
        // встретились в первоначальном списке
        // Например, было
//        [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        // на выходе:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        return uniqueMessages;
    }

    private static void uniqueMessageCount(List<Message> messageList) {
        HashSet<Message> uniqueMessages = new HashSet<>(messageList);
        System.out.println(uniqueMessages.size());
    }

    public static void countEachCode(List<Message> messageList) {
        HashSet<Integer> inCodes = new HashSet<>();
        for(Message msg: messageList){
            int code = msg.getCode();
            if(inCodes.contains(code)){
                continue;
            } else {
                inCodes.add(code);
                int count = 0;
                for(Message ms: messageList)
                {
                    if(ms.getCode()==code)
                        count++;
                }
                System.out.println("code "+ code + "contained " + count + "times");
            }
        }
    }

    public static void countEachPriority(List<Message> msgList){
        int low=0,medium=0,high=0,urgent=0;
        for(Message msg: msgList){
            switch (msg.getPriority()){
                case LOW:
                    low++;
                    break;
                case MEDIUM:
                    medium++;
                    break;
                case HIGH:
                    high++;
                    break;
                case URGENT:
                    urgent++;
                    break;
            }
        }
        System.out.println("Low " + low + "; Medium " + medium +"; High " + high + "; Urgent " + urgent);
    }

    public static void print(List<Message> list){
        System.out.println();
        for(Message msg: list) {

            System.out.println(msg);
        }
    }

    public static void print(LinkedHashSet<Message> linkedHashSet){
        for(Message msg: linkedHashSet) {
            System.out.println(msg);
        }
    }
}
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



class Message {
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