package lesson12;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class LaunchStatExt implements Externalizable {
    private static final long serialVersionUID = 0L;
    private static final int VERSION = 1;
    private int laaunchCount;
    private Date lastLaunch;

    private String user;

    public boolean isFirstLaunch() {
        return laaunchCount == 0 && lastLaunch == null;
    }

    public void update() {
        laaunchCount++;
        lastLaunch = new Date();
        user = System.getProperty("user.name");
    }

    @Override
    public String toString() {
        return "LaunchStatExt{" +
                "laaunchCount=" + laaunchCount +
                ", lastLaunch=" + lastLaunch +
                ", user='" + user + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(VERSION);
        out.writeInt(laaunchCount);
        out.writeObject(lastLaunch);
        out.writeUTF(user);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        if (version>VERSION){
            throw new IOException("не та версия");
        }
        laaunchCount = in.readInt();
        lastLaunch = (Date)in.readObject();
        if (version>0){
            user = in.readUTF();
        }
    }
}
