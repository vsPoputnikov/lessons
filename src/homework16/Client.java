package homework16;

import java.util.Random;

public class Client {
    int time;
    static Random random = new Random();

    @Override
    public String toString() {
        return "Client{" +
                "time=" + time +
                '}';
    }

    public Client() {
        this.time = random.nextInt(7)+3;
    }

    public int getTime() {
        return time;
    }
}
