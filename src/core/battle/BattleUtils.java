package core.battle;

import java.util.ArrayList;
import java.util.Scanner;


public class BattleUtils {

    public BattleUtils(){
    }


    public static int damageCalc(Commander cAttacker, Commander cDefender){
        int troopLoss = 0;
        if (cAttacker.currentTroops > 0) {
            float damageFloat = cAttacker.currentTroops * cAttacker.offenseModifier * cAttacker.troopType.attack * cDefender.defenseModifier;
            int damages = (int) Math.ceil(damageFloat);
            troopLoss = (damages / cDefender.troopType.hp);
            if (troopLoss <= 0 ) { troopLoss = 1; }
            System.out.println(troopLoss + " damages !");
            return troopLoss;
        } else {
            return troopLoss;
        }
    }


    public static int retaliationCalc(Commander cAttacker, Commander cDefender) {
        int troopLoss = 0;
        if ((!cAttacker.troopType.isRanged) && cDefender.troopType.canRetaliate){
            if (cAttacker.currentTroops > 0) {
                float damageFloat = (cDefender.currentTroops * cDefender.offenseModifier * cDefender.troopType.attack * cAttacker.defenseModifier)*0.5f;
                int damages = (int) Math.ceil(damageFloat);
                troopLoss = (damages / cAttacker.troopType.hp);
                if (troopLoss <= 0 ) { troopLoss = 1; }
                System.out.println(troopLoss + " retaliation damages !");
                return troopLoss;
            } else {
                return troopLoss;
            }
        } else {
            return troopLoss;
        }
    }



    public static void attackPrint(Commander cAttacker, Commander cDefender){
        if (cAttacker.currentTroops > 0){
            System.out.println(cAttacker.name + " : " + cAttacker.currentTroops + "/" + cAttacker.maxTroops);
            System.out.println(cAttacker.name + " attacks " + cDefender.name);
        }
    }

    public static Commander getCommander(ArrayList<Commander> commanders){
        Scanner scanner = new Scanner(System.in);
        Commander commander1 = null;
        boolean chosen = false;
        do {
            System.out.println("Choose your commander by it's name !");
            String commanderName = scanner.nextLine();
            for (Commander commander : commanders) {
                if (commander.name.equals(commanderName)) {
                    commander1 = commander;
                    chosen = true;
                    break;
                }
            }
            if (!chosen) {
                System.out.println("Commander not found ");
            }
        } while (chosen == false);
        return commander1;
    }
}
