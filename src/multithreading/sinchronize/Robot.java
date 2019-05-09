package multithreading.sinchronize;

public class Robot {
    volatile boolean current = true;
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.start();
    }
    class Leg implements Runnable{
        String name;

        public Leg(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while(true){
                if(true){
                    step();
                    Thread.yield();
                }
            }
        }

        void step(){
            System.out.println(name);
        }
    }

    Leg left = new Leg("Left");
    Leg right = new Leg("Right");
    void start(){
        new Thread(left).start();
        new Thread(right).start();
    }
}
