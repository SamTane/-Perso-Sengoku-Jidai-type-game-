package core.battle.battleSkills;

import core.battle.*;

import javax.swing.border.TitledBorder;
import java.util.ArrayList;


import java.util.Arrays;

public class MeleeAttack extends BattleSkill {

    public MeleeAttack(Commander user) {
        super("Attack", user, new ArrayList<>(Arrays.asList(1, 2, 3)),0, 1);
    }

    public static void Register(ArrayList<Commander> allCommanders) {
        for (Commander commander : allCommanders)
            if (!commander.troopType.isRanged) {
                BattleSkill battleSkill = new MeleeAttack(commander);
                commander.addBattleSkill(battleSkill);
            }
    }

    public int damageCalc(Tile target, int result) {
        int troopLoss = 0;
        if (result == 0) {
            float damageFloat = user.currentTroops * user.offenseModifier * user.troopType.attack * target.commander.defenseModifier;
            int damages = (int) Math.ceil(damageFloat);
            troopLoss = (damages / target.commander.troopType.hp);
            if (troopLoss <= 0 ) { troopLoss = 1; }
            System.out.println(target.commander.name + " suffers " + troopLoss + " casualties !");
            return troopLoss;
        } return 0;
    }

    @Override
    public void triggerBattleSkill() {
        int index = 0;
        for (Tile target : targets) {
            target.commander.currentTroops -= damageCalc(target, results.get(index));
            System.out.println("OK");
        }

    }
}
