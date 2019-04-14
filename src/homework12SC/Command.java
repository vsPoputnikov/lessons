package homework12SC;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Command implements Externalizable {
    private String sender;
    private String command;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(command);
        out.writeUTF("from "+ sender);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

    public Command(String sender, String command) {
        this.sender = sender;
        this.command = command;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
