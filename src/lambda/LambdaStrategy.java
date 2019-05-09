package lambda;

import java.util.concurrent.ConcurrentSkipListMap;

public class LambdaStrategy {
    public static void main(String[] args) {
        Order order = new Order(700);
        order.payOrder("card");
    }

}

class StrategyRegister<T>{
    public ConcurrentSkipListMap<String,T> map = new ConcurrentSkipListMap<>();
    public void add(String actionName,T action){
        map.putIfAbsent(actionName,action);
    }
    public T get(String actionName){
        return map.get(actionName);
    }

    public void remove(String actionName){
        map.remove(actionName);
    }
}

class Order{
    private int sum;

    private StrategyRegister<Runnable> payActions = new StrategyRegister<>();

    public Order(int sum) {
        this.sum = sum;
        payActions.add("card",()-> System.out.println("оплата по карте: " + sum));
        payActions.add("payPal",()-> System.out.println("оплата по payPal: " + sum));
    }

    public void payOrder(String payName){
        payActions.get(payName).run();
    }
}

enum PayActions{

}