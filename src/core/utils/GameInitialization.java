package core.utils;

import java.util.ArrayList;
import java.util.Arrays;

import core.clans.*;
import core.provinces.*;
import core.events.*;

public class GameInitialization {

    private ArrayList<Clan> clans;
    private ArrayList<Province> provinces;

    public GameInitialization() {

        //Clans :
        Clan cCentral = new Central();
        Clan cBandits = new Bandits();
        Clan cTheCraftmen = new TheCraftmen();
        Clan cHappyMerchants = new HappyMerchants();
        Clan cNunInstitute = new NunInstitute();


        //Provinces :
        Province pTheMiddle = new TheMiddle(cCentral);//Central

        Province pRififiForest = new RififiForest(cBandits);//Bandits

        Province pCocoHills = new CocoHills(cTheCraftmen);//The Craftmen

        Province pPortoMaestro = new PortoMaestro(cHappyMerchants);
        Province pTalmud = new Talmud(cHappyMerchants);//Happy Merchants

        Province pMikoMountains = new MikoMountains(cNunInstitute);//Nun Institute

        // Clans & provinces list
        this.clans = new ArrayList<>(Arrays.asList(cCentral, cBandits, cTheCraftmen, cHappyMerchants, cNunInstitute));
        this.provinces = new ArrayList<>(Arrays.asList(pTheMiddle, pRififiForest, pCocoHills, pPortoMaestro, pMikoMountains, pTalmud));


    }
    public ArrayList<Clan> getClans() { return clans; }
    public ArrayList<Province> getProvinces() { return provinces; }


    public void basicStateOfTheGame() {
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
            System.out.println(clan.name + " available events are :");
            for (Province province : provinces) {
                System.out.print(province.name + " : ");
                boolean hasEvent = false;
                for (Event provinceEvent : province.availableEvents) {
                    if (clan.availableEvents.contains(provinceEvent)) {
                        System.out.print(provinceEvent.name + ", ");
                        hasEvent = true;
                    }
                }
                if (!hasEvent) {
                    System.out.print("No events");
                }
                System.out.println();
            }
        }
        /*This script gives all clans borders, all clans events and in which province they can trigger this
        event*/
    }

}
