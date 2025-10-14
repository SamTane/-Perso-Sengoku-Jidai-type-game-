package core.battle.battleSkills;

import core.battle.Commander;
import core.battle.Tile;

import java.util.ArrayList;

public abstract class BattleSkill {
    public String name;
    public Commander user;
    public ArrayList<Integer> possibleTargets;
    public int maxTargets;
    public ArrayList<Tile> targets;
    public ArrayList<Integer> results;
    public int id;

    public BattleSkill(String name, Commander commander, ArrayList<Integer> possibleTargets, int id, int maxTargets) {
        this.name = name;
        this.user = commander;
        this.possibleTargets = possibleTargets;
        this.targets = new ArrayList<>();
        this.id = id;
        this.maxTargets = maxTargets;
        this.targets = new ArrayList<>();
        this.results = new ArrayList<>();

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

    public void clearTargets() {
        targets.clear();
        results.clear();
    }

    public boolean canBeUsedBy(Commander commander) {
        return true; // default to true
    }
}
