package core;

import java.util.ArrayList;
import java.util.Arrays;

import core.clans.Clan;
import core.events.*;
import core.managers.*;


public class Main {
    public static void main(String[] args) {


        //Clans :
        Clan clan1 = new Clan(0, "Central", 120, 0, 2);
        Clan clan2 = new Clan(1, "Bandits", 70, 0, 1);
        Clan clan3 = new Clan(2, "The Craftmen", 100, 0, 2);
        Clan clan4 = new Clan(3, "Happy Merchants", 200, 0, 2);
        Clan clan5 = new Clan(4, "Nun Institute", 100, 0, 3);


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
        EventManager em = new EventManager(clanList, provinceList);

        //neighbors
        mm.neighborsSetting();



        //Events
        em.registerOtherEvents();
        /*
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
            System.out.println(clan.name + " available core.events are :");
            for (Province province : allProvinces) {
                System.out.print(province.name + " : ");
                boolean hasEvent = false;
                for (Event provinceEvent : province.availableEvents) {
                    if (clan.availableEvents.contains(provinceEvent)) {
                        System.out.print(provinceEvent.name + ", ");
                        hasEvent = true;
                    }
                }
                if (!hasEvent) {
                    System.out.print("No core.events");
                }
                System.out.println();
            }
        }*/
        /*This script gives all clans borders, all clans core.events and in which province they can trigger this
        event*/


        TurnManager tm = new TurnManager(clanList, provinceList);
        for (int i = 0; i <= 2; i++) { //Number of turns
            tm.nextTurn(); //+1 turn at the start of the loop
            tm.resetActions(); //Each clans actions are reset to max at the start of the turn
            tm.incomeUpdate(); //NEEDS CORRECTION Each clan income is updated at the start of the turn
            System.out.println("\n \n \n \n************");
            System.out.println("** Turn " + tm.turn + " **");
            System.out.println("************");
            for (Clan clan : clans) {
                System.out.println(" \n ");
                System.out.println("< " + clan.name + ">");
                System.out.println(clan.actions + " actions");
                 System.out.println(clan.golds + " G");
                do {
                    em.addAvalaibleEvents();
                    int IndexEvent = (int)(Math.random() * clan.availableEvents.size());
                    Event event = clan.availableEvents.get(IndexEvent);
                    System.out.println();
                    tm.SimulateActions(clan, event);
                    System.out.println(clan.actions + " actions left.");
                } while (clan.actions > 0);
            }
            tm.income();
        }
    }

}