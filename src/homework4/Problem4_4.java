package homework4;

public class Problem4_4 {
    public static void solve(){
        Cat cat1 = new Cat("cat1", 2, 3, 4);
        Cat cat2 = new Cat("cat2", 1, 4, 3);
        System.out.println(cat1 + " VS " + cat2);
        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat1));
    }
}
