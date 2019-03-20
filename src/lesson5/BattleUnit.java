package lesson5;

public class BattleUnit extends Unit {
    private int attackScore;
    public BattleUnit(int health, int attackScore) {
        super(health);
        this.attackScore = attackScore;
    }
    public void attack(BattleUnit enemy){
        if(!this.isAlive()){
            System.out.println("Unit is dead");
            return;
        }
        enemy.health -= this.attackScore;
    }

}
