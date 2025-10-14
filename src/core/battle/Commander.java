package core.battle;

import core.battle.battleSkills.BattleSkill;
import core.clans.*;

import java.util.ArrayList;
import java.util.Arrays;


public class Commander {
    public String name;
    public Clan owner;
    public Troop troopType;
    public int maxTroops;
    public int currentTroops;
    public int offenseLevel;
    public int defenseLevel;
    public int speedLevel;
    public int id;
    public float offenseModifier;
    public float defenseModifier;
    public boolean used;
    public ArrayList<BattleSkill> battleSkills;

    public static int clampStat(int commanderLevel) {
            if (commanderLevel < 1) {
                commanderLevel = 1;
            } else if (commanderLevel > 9) {
                commanderLevel = 9;
            }
            return commanderLevel;
    }

    public Commander(String name, Clan owner, Troop troopType, int maxTroops, int offenseLevel,
                     int defenseLevel, int speedLevel, int id) {
        this.name = name;
        this.owner = owner;
        this.troopType = troopType;
        this.maxTroops = maxTroops;
        this.currentTroops = maxTroops;
        this.offenseLevel = clampStat(offenseLevel);
        this.defenseLevel = clampStat(defenseLevel);
        this.speedLevel = clampStat(speedLevel);
        this.id = id;
        ArrayList<Float> offenseModifiers = new ArrayList<>(Arrays.asList(1f, 1f, 1.25f, 1.5f, 1.75f, 2f, 2.25f,
                2.5f, 2.75f, 3f));
        this.offenseModifier = offenseModifiers.get(this.offenseLevel);
        ArrayList<Float> defenseModifiers = new ArrayList<>(Arrays.asList(1f, 1f, 0.8f, 0.66f, 0.57f, 0.5f, 0.44f,
                0.4f, 0.36f, 0.33f));
        this.defenseModifier = defenseModifiers.get(this.defenseLevel);
        this.used = false;
        this.battleSkills = new ArrayList<>();

    }
    public void addBattleSkill(BattleSkill battleSkill) {battleSkills.add(battleSkill); }
    public void removeBattleSkill(BattleSkill battleSkill) { battleSkills.remove(battleSkill); }
}

