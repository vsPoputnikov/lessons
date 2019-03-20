package homework5;

import homework5.Calc.Calc;

public class Homework5 {
    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.addFirst(7);
        myList.addFirst(8);
        System.out.println(myList);
        myList.removeFirst();
        System.out.println(myList);
        myList.removeFirst();
        System.out.println(myList);
        Calc.solve();

    }
}
