package core.battle;
import core.clans.*;
import core.utils.GameInitialization;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;


import javax.print.attribute.standard.Sides;
import java.util.Scanner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BattleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BattlePresets presets = new BattlePresets();
        GameInitialization gInit = new GameInitialization();
        ArrayList<Clan> clans = gInit.getClans();
        ArrayList<Commander> commanders = gInit.getCommanders();
        //commander1 = BattleUtils.getCommander(commanders);
        //commander2 = BattleUtils.getCommander(commanders);
        ArrayList<Tile> sideA = new ArrayList<>();
        ArrayList<Tile> sideB = new ArrayList<>();
        ArrayList<Clan> battlingClans = new ArrayList<>(Arrays.asList(clans.get(0), clans.get(1)));
        ArrayList<ArrayList<Tile>> sides = new ArrayList<>(Arrays.asList(sideA, sideB));
        for (int i = 1; i <= 6; i++) {
            sideA.add(new Tile(i, null));
            sideB.add(new Tile(i, null)); // distinct Tile objects with same IDs
        }

            //Before assigning commanders
            int indexSide = 0;
            for (Clan clan : battlingClans) {
                ArrayList<Tile> possibleTiles = new ArrayList<>(sides.get(indexSide));
                Collections.shuffle(possibleTiles);
                for (Tile tile : possibleTiles) {
                    if (!(clan.commanders.isEmpty())) {
                        for (Commander commander : clan.commanders) {
                            if (!commander.used) {
                                tile.commander = commander;
                                tile.commander.used = true;
                                break;
                            }
                        }
                    }
                } indexSide = 1;
            }

            indexSide = 0;
            for (ArrayList<Tile> side : sides) {
                System.out.println(battlingClans.get(indexSide).name + " : ");
                for (Tile tile : side) {
                    if (tile.commander != null) {
                        System.out.println(tile.number + " : " + tile.commander.name);
                    } else {
                        System.out.println(tile.number + " : ");
                    }
                }
                indexSide = 1;
            }







        /*for (Commander commander : commanders) {
            System.out.println("\n" + commander.name + " possesses an army of " + commander.currentTroops + "/" +
                    commander.maxTroops + " " + commander.troopType.name);
            System.out.println("AtkLvl : " + commander.offenseLevel + ", DefLvl : " + commander.defenseLevel +
                    ", SpdLvl : " + commander.speedLevel);
            System.out.println(commander.troopType.name + " : " + commander.troopType.hp + " hp, " +
                    commander.troopType.attack + " attack, " + commander.troopType.speed + " speed\n");
        }





        while (!(commander1.currentTroops <= 0 || commander2.currentTroops <= 0)) {
            BattleUtils.attackPrint(commander1, commander2);
            commander2.currentTroops -= BattleUtils.damageCalc(commander1, commander2);
            commander1.currentTroops -= BattleUtils.retaliationCalc(commander1, commander2);
            BattleUtils.attackPrint(commander2, commander1);
            commander1.currentTroops -= BattleUtils.damageCalc(commander2, commander1);
            commander2.currentTroops -= BattleUtils.retaliationCalc(commander2, commander1);
        } for (Commander commander : commanders) {
            if (commander.currentTroops <= 0) {
                System.out.println(commander.name + " is dead !");
            }
        }*/
    }
}
