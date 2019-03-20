package lesson5;

public class Unit {
    protected int health;

    public Unit(int health) {
        this.health = health;
    }
    public boolean isAlive(){
        return health>0;
    }
}
