package lesson12;

import java.io.Serializable;
import java.util.Date;

public class LaunchStat implements Serializable {
    private int laaunchCount;
    private Date lastLaunch;

    private String lastUser;

    public boolean isFirstLaunch() {
        return laaunchCount == 0 && lastLaunch == null;
    }

    public void update() {
        laaunchCount++;
        lastLaunch = new Date();
        lastUser = System.getProperty("user.name");
    }

    @Override
    public String toString() {
        return "LaunchStat{" +
                "laaunchCount=" + laaunchCount +
                ", lastLaunch=" + lastLaunch +
                ", lastUser='" + lastUser + '\'' +
                '}';
    }
}
