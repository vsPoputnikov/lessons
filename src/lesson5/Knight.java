package lesson5;

public class Knight extends BattleUnit {
    public Knight(int health, int attackScore){
        super(health,attackScore);
    }
    // переопределение метода родителя
    @Override
    public void attack(BattleUnit enemy){
        super.attack(enemy);
        enemy.health -=1;
    }


}
