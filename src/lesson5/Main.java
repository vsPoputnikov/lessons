package lesson5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Knight knight = new Knight(12, 34);
        Archer archer = new Archer(36, 19);
        knight.attack(archer);

        Scanner in = new Scanner(System.in);
        System.out.println("character select");
        String heroType = in.nextLine();
        BattleUnit unit;
        if ("knight".equals(heroType)) {
            // тип класса предка!!!
            unit = new Knight(23, 78);
        } else {
            unit = new Archer(32, 12);
        }
        unit.attack(archer);

        JSONhandler jsoNhandler = new JSONhandler();
        jsoNhandler.write();
        jsoNhandler.read();
    }
}
