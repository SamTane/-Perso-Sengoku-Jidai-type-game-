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
        Province province1 = new Province(0, "The Middle", clan1, 60, new int[]{1, 2, 3, 4});
        clan1.addProvince(province1);
        Province province2 = new Province(1, "Rififi Forest",  clan2, 35, new int[]{0, 2, 4});
        clan2.addProvince(province2);
        Province province3 = new Province(2, "Coco Hills", clan3, 50, new int[]{0, 1, 3, 5});
        clan3.addProvince(province3);
        Province province4 = new Province(3, "Porto Maestro", clan4, 50, new int[]{0, 2, 4, 5});
        clan4.addProvince(province4);
        Province province5 = new Province(4, "Miko Mountains", clan5, 50, new int[]{0, 1, 3});
        clan5.addProvince(province5);
        Province province6 = new Province(5, "Talmud", clan4, 50, new int[]{0, 2, 3});
        clan4.addProvince(province6);



        // Clans & provinces list
        Clan[] clans = {clan1, clan2, clan3, clan4, clan5};
        ArrayList<Clan> clanList = new ArrayList<>(Arrays.asList(clans));
        Province[] allProvinces = {province1, province2, province3, province4, province5, province6};
        ArrayList<Province> provinceList = new ArrayList<>(Arrays.asList(allProvinces));

        MapManager mm = new MapManager(clanList, provinceList);

        //neighbors
        mm.neighborsSetting();

        for (Clan clan : clans) {
            System.out.println("[" + clan.name + "] Bordering clans are :");
            for (Clan clanNeighbor : clan.clanNeighbors) {
                System.out.println("    " + clanNeighbor.name + " :");
                for (Province clanNeighborProvince : clanNeighbor.provinces) {
                    if (clan.provinceNeighbors.contains(clanNeighborProvince)) {
                        System.out.println("        P" + clanNeighborProvince.id + " " + clanNeighborProvince.name);
                    }

                }
            }
        }

        //Events

        /* Universal personal events : events that are in every provinces, are triggered by the owner,
        targets them and have 1 effect */
        // 0 = LazyCommanders, 1 = TroopStrike, 2 = Sabotage
        Integer[] universalPersonalEvents = {0, 1, 2};
        ArrayList<Integer> universalPersonalEventsList = new ArrayList<>(Arrays.asList(universalPersonalEvents));

        for (Integer event : universalPersonalEventsList) {
            if (event == 0) {
                for (Province province : provinceList) {
                    LazyCommanders lazy = new LazyCommanders(province, province.owner);
                    lazy.addTarget(province.owner, 0);
                    province.addEvent(lazy);
            }
            } else if (event == 1) {
                for (Province province : provinceList) {
                    TroopStrike strike = new TroopStrike(province, province.owner);
                    strike.addTarget(province.owner, 0);
                    province.addEvent(strike);
                }
            } else {
                for (Province province : provinceList) {
                    Sabotage sabotage = new Sabotage(province, province.owner);
                    sabotage.addTarget(province.owner, 0);
                    province.addEvent(sabotage);
                }
            }
        }





/*
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
                    for (Province neighbor : province.neighbors) {
                        System.out.println(neighbor.id + " : " + neighbor.name);
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


        }*/
    }

}