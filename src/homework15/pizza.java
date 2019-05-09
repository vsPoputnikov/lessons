package homework15;

//три потока
//Клиент, повар, официант
//три очереди: заказы новыеб заказы для кухни, готовые блюда
//официант берёт из очереди 1 и добавляет в 2
//повар из 2 в 3
//клиент забирает из очереди 3


import java.util.concurrent.ArrayBlockingQueue;

public class pizza {
    public static void main(String[] args) {
        ArrayBlockingQueue<Order> newOrders = new ArrayBlockingQueue<>(3, true);
        ArrayBlockingQueue<Order> forCook = new ArrayBlockingQueue<>(3, true);
        ArrayBlockingQueue<Order> done = new ArrayBlockingQueue<>(3, true);
        Order meat = new Order("meat");
        Order cheese = new Order("meat");
        Order veg = new Order("veg");
        Order tomato = new Order("tomato");
        Waiter waiter1 = new Waiter(forCook,newOrders);
        Waiter waiter3 = new Waiter(forCook,newOrders);
        Waiter waiter2 = new Waiter(forCook,newOrders);
        waiter1.start();
        waiter2.start();
        waiter3.start();

        Client client1 = new Client(done,newOrders);
        Client client2 = new Client(done,newOrders);
        Client client3 = new Client(done,newOrders);

        client1.makeOrder(meat);
        client2.makeOrder(cheese);

        client1.start();
        client2.start();
        client3.start();








    }

    Client clients;
}

class Waiter extends Thread {
    ArrayBlockingQueue<Order> forCook;
    ArrayBlockingQueue<Order> newOrders;

    public Waiter(ArrayBlockingQueue<Order> forCook, ArrayBlockingQueue<Order> newOrders) {
        this.forCook = forCook;
        this.newOrders = newOrders;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Order order = newOrders.take();
                System.out.println("Официант принял новый заказ" + order.getName());
                forCook.put(order);
                System.out.println("for cook: " + order.getName());
            } catch (Exception e) {
            }
        }
    }
}

class Chef {
}

class Client extends Thread {
    public Client(ArrayBlockingQueue<Order> done, ArrayBlockingQueue<Order> newOrders) {
        this.done = done;
        this.newOrders = newOrders;
    }

    ArrayBlockingQueue<Order> done;
    ArrayBlockingQueue<Order> newOrders;

    public void makeOrder(Order order) {
        try {
            newOrders.put(order);
            System.out.println(order.getName());
        } catch (Exception e) {
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(done.take());
            } catch (Exception e) {
            }
        }
    }
}

class Order {
    String name;

    public Order(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}