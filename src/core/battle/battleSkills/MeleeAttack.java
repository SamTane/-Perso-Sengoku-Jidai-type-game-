package core.battle.battleSkills;

import core.battle.*;
import java.util.ArrayList;


import java.util.Arrays;

public class MeleeAttack extends BattleSkill {

    public MeleeAttack(Commander commander) {
        super("Attack", commander, new ArrayList<>(Arrays.asList(1, 2, 3)), 0);
    }

    public static void Register(ArrayList<Commander> allCommanders) {
        for (Commander commander : allCommanders)
            if (commander.troopType.isRanged) {
                BattleSkill battleSkill = new MeleeAttack(commander);

            }
    }

    @Override
    public void triggerBattleSkill() {

    }
}
