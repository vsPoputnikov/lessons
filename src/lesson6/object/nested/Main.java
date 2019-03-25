package lesson6.object.nested;

import homework5.MyList;

public class Main {
    public static void main(String[] args) {
        Food apple = new Food.Builder(4)
                .calories(23)
                .fat(6)
                .build();
        System.out.println(apple);
        MyList list = new MyList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        for (Object o: list){
            System.out.println(o);
        }
    }
}
