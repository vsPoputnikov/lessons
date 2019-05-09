package homework16;

import java.util.Random;
import java.util.concurrent.*;

public class Macdonalds {
    public static void main(String[] args) {
        LinkedBlockingDeque<Client> clients = new LinkedBlockingDeque<>();
        Generator generator = new Generator(clients);
        new Thread(generator).start();





        Cashbox cashbox1 = new Cashbox(clients);
        new Thread(cashbox1).start();
        Cashbox cashbox2 = new Cashbox(clients);
        new Thread(cashbox2).start();

    }
}

class Generator implements Runnable{
    LinkedBlockingDeque<Client> clients;

    public Generator(LinkedBlockingDeque<Client> clients) {
        this.clients = clients;
    }

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            clients.addFirst(new Client());


                System.out.println(clients);

        }


    }
}



class Cashbox implements Runnable {
    LinkedBlockingDeque<Client> queqe = new LinkedBlockingDeque<>();
     int cashboxNumeber;
    static int number;

    public Cashbox(LinkedBlockingDeque<Client> queqe) {
        this.queqe = queqe;
        cashboxNumeber = ++number;

    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            while (!queqe.isEmpty()) {
                Client client = queqe.takeLast();
                System.out.println("кассой # "+ this.cashboxNumeber+" брабатывается очередной клиент с заказом объёмом: " + client.getTime());
                Thread.sleep(client.getTime() * 1000);
                System.out.println(queqe);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}