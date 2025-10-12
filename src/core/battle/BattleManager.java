package core.battle;
import core.clans.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BattleManager {
    public static void main(String[] args) {
        Clan cWesterners = new Clan(99, "Westerners", 0, 0, 2);
        Clan eEasterners = new Clan(100, "Easterners", 0, 0, 2);

        Troop cannonFodder = new Troop("Cannon Fodders", 30, 10, 100, false, true);

        Commander testChan = new Commander("Test-Chan", cWesterners, cannonFodder, 500, 4, 4, 4, 1);
        Commander testKun = new Commander("Test-Kun", eEasterners, cannonFodder, 500, 4, 4, 4, 1);

        ArrayList<Commander> commanders = new ArrayList<>(Arrays.asList(testChan,testKun));

        for (Commander commander : commanders) {
            System.out.println("\n" + commander.name + " possesses an army of " + commander.currentTroops + "/" +
                    commander.maxTroops + " " + commander.troopType.name);
            System.out.println("AtkLvl : " + commander.offenseLevel + ", DefLvl : " + commander.defenseLevel +
                    ", SpdLvl : " + commander.speedLevel);
            System.out.println(commander.troopType.name + " : " + commander.troopType.hp + " hp, " +
                    commander.troopType.attack + " attack, " + commander.troopType.speed + " speed\n");
        }


        while (!(testChan.currentTroops <= 0 || testKun.currentTroops <= 0)) {
            BattleUtils.attackPrint(testChan, testKun);
            testKun.currentTroops -= BattleUtils.damageCalc(testChan, testKun);
            testChan.currentTroops -= BattleUtils.retaliationCalc(testChan, testKun);
            BattleUtils.attackPrint(testKun, testChan);
            testChan.currentTroops -= BattleUtils.damageCalc(testKun, testChan);
            testKun.currentTroops -= BattleUtils.retaliationCalc(testKun, testChan);
        } for (Commander commander : commanders) {
            if (commander.currentTroops <= 0) {
                System.out.println(commander.name + " is dead !");
            }
        }






    }
}
