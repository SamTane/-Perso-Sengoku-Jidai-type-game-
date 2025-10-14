package core.battle;

public class Troop {
    public String name;
    public int hp;
    public int attack;
    public int speed;
    public boolean isRanged;
    public boolean canRetaliate;

    public Troop(String name, int hp, int attack, int speed, boolean isRanged, boolean canRetaliate){
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.speed = speed;
        this.isRanged = isRanged;
        this.canRetaliate = canRetaliate;
    }
}
