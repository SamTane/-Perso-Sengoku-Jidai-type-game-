package core.battle.battleSkills;

import core.battle.Commander;
import core.battle.Tile;

import java.util.ArrayList;

public abstract class BattleSkill {
    public String name;
    public Commander user;
    public ArrayList<Integer> possibleTargets;
    public ArrayList<Tile> targets;
    public ArrayList<Integer> results;
    int id;

    public BattleSkill(String name, Commander commander, ArrayList<Integer> possibleTargets, int id) {
        this.name = name;
        this.user = commander;
        this.possibleTargets = possibleTargets;
        this.targets = new ArrayList<>();
        this.id = id;
    }

    public abstract void triggerBattleSkill();

    public void addTarget(Tile target, int result) {
        targets.add(target);
        results.add(result);
    }

    public void removeTarget(Tile target) {
        int index = targets.indexOf(target);
        if (index != -1) {
            targets.remove(index);
            results.remove(index);
        }
    }

    public boolean canBeUsedBy(Commander commander) {
        return true; // default to true
    }
}
