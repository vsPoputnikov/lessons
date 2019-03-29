package homework9;

import java.util.ArrayList;
import java.util.Random;

public class Problem9_2 {
    int number = 0;
    Random random = new Random();
    ArrayList<Integer> intArray = new ArrayList<>();
    ArrayList<Integer> Div3Array = new ArrayList<>();
    ArrayList<Integer> Div2Array = new ArrayList<>();
    ArrayList<Integer> lastArray = new ArrayList<>();


    public void solve() {

        for (int i = 0; i < 20; i++) {
            number = random.nextInt(20) + 1;
            intArray.add(number);
            if (number % 2 == 0) {
                Div2Array.add(number);
            }
            if (number % 3 == 0) {
                Div3Array.add(number);
            }
            if ((number % 3) * (number % 2) != 0) {
                lastArray.add(number);
            }

        }
        printArray(intArray);

    }

    public void printArray(ArrayList<Integer> lst) {
        for (int num : lst) {
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public void printArray(){
        this.printArray(Div2Array);
        this.printArray(Div3Array);
        this.printArray(lastArray);

    }
}
