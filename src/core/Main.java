package core;

import java.util.ArrayList;
import java.util.Arrays;
import events.*;

public class Main {
    public static void main(String[] args) {

        //Clans :
        Clan clan1 = new Clan(1, "Central", 120, 0, 2);
        Clan clan2 = new Clan(2, "Bandits", 70, 0, 1);
        Clan clan3 = new Clan(3, "The Craftmen", 100, 0, 2);
        Clan clan4 = new Clan(4, "Happy Merchants", 200, 0, 2);
        Clan clan5 = new Clan(5, "Nun Institute", 100, 0, 3);


        //Provinces :
        Province province1 = new Province(1, "The Middle", new int[]{2, 3, 4, 5}, clan1, 60);
        clan1.addProvince(province1);
        province1.addEvent(new LazyCommanders(province1));
        province1.addEvent(new TroopStrike(province1));
        province1.addEvent(new Sabotage(province1));
        Province province2 = new Province(2, "Rififi Forest", new int[]{1, 3, 5}, clan2, 35);
        clan2.addProvince(province2);
        province2.addEvent(new LazyCommanders(province2));
        province2.addEvent(new TroopStrike(province2));
        province2.addEvent(new Sabotage(province2));
        Province province3 = new Province(3, "Coco Hills", new int[]{1, 2, 4, 6}, clan3, 50);
        clan3.addProvince(province3);
        province3.addEvent(new LazyCommanders(province3));
        province3.addEvent(new TroopStrike(province3));
        province3.addEvent(new Sabotage(province3));
        Province province4 = new Province(4, "Porto Maestro", new int[]{1, 3, 5, 6}, clan4, 50);
        clan4.addProvince(province4);
        province4.addEvent(new LazyCommanders(province4));
        province4.addEvent(new TroopStrike(province4));
        province4.addEvent(new Sabotage(province4));
        Province province5 = new Province(5, "Miko Mountains", new int[]{1, 3, 4}, clan5, 50);
        clan5.addProvince(province5);
        province5.addEvent(new LazyCommanders(province5));
        province5.addEvent(new TroopStrike(province5));
        province5.addEvent(new Sabotage(province5));
        Province province6 = new Province(6, "Talmud", new int[]{3, 4}, clan4, 50);
        clan4.addProvince(province6);
        province6.addEvent(new LazyCommanders(province6));
        province6.addEvent(new TroopStrike(province6));
        province6.addEvent(new Sabotage(province6));



        // Clans & provinces list
        Clan[] clans = {clan1, clan2, clan3, clan4, clan5};
        ArrayList<Clan> clanList = new ArrayList<>(Arrays.asList(clans));
        Province[] allProvinces = {province1, province2, province3, province4, province5, province6};
        ArrayList<Province > provinceList = new ArrayList<>(Arrays.asList(allProvinces));

        // Turn
        TurnManager tm = new TurnManager(clanList, provinceList);
        for (int i = 0; i <= 2; i++) {
            tm.nextTurn();
            tm.resetActions();
            tm.incomeUpdate();
            System.out.println("************");
            System.out.println("** Turn " + tm.turn + " **");
            System.out.println("************");
            for (Clan clan : clans) {

                System.out.println("< " + clan.name + " owns " + clan.provinces.size() + " provinces : >");
                for (Province province : clan.provinces) {
                    System.out.println(province.name + "." + " Borders :");
                     for (int neighborId : province.neighbors) {
                        for (Province p : allProvinces)
                            if (p.id == neighborId)
                                System.out.println(p.id + " : " + p.name + ".");
                     }
                }
                System.out.println(clan.actions + " actions");
                 System.out.println(clan.golds + " G");
                do {
                    int indexProvinces = (int)(Math.random() * clan.provinces.size());
                    tm.SimulateActions(clan, clan.provinces.get(indexProvinces));
                    System.out.println(clan.actions + " actions left.");
                } while (clan.actions > 0);
            }
            tm.income();


        }
    }

}