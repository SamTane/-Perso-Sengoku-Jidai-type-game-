package core.clans;

import core.battle.Commander;
import core.provinces.Province;
import core.events.*;

import java.util.ArrayList;

public class Clan {
    public int id;
    public String name;
    public int golds;
    public ArrayList<Province> provinces;
    public ArrayList<Province> provinceNeighbors;
    public ArrayList<Clan> clanNeighbors;
    public int income;
    public int actions;
    public int maxActions; //I plan to add ways to have more actions
    public ArrayList<Event> availableEvents;
    public ArrayList<Commander> commanders;


    public Clan(int id, String name, int golds, int income, int maxActions) {
        this.id = id;
        this.name = name;
        this.golds = golds;
        this.provinces = new ArrayList<>();
        this.provinceNeighbors = new ArrayList<>();
        this.clanNeighbors = new ArrayList<>();
        this.commanders = new ArrayList<>();
        this.income = income;
        this.maxActions = maxActions;
        this.availableEvents = new ArrayList<>();

    }

    //add or remove owned provinces
    public void addProvince(Province province) { provinces.add(province);}
    public void removeProvince(Province province) { provinces.remove(province);}

    //add or remove a provinceNeighbor
    public void addProvinceNeighbor(Province provinceNeighbor) { provinceNeighbors.add(provinceNeighbor);}
    public void removeProvinceNeighbor(Province provinceNeighbor) { provinceNeighbors.remove(provinceNeighbor);}

    //Add or remove a clanNeighbor
    public void addClanNeighbor(Clan clanNeighbor) { clanNeighbors.add(clanNeighbor);}
    public void removeClanNeighbor(Clan clanNeighbor) { clanNeighbors.remove(clanNeighbor);}

    //Remove or add an available event
    public void addAvailableEvent(Event availableEvent) {availableEvents.add(availableEvent); }
    public void removeAvailableEvent(Event availableEvent) {availableEvents.remove(availableEvent); }

    //remove or add a commander
    public void addCommander(Commander commander) {commanders.add(commander); }
    public void removeCommander(Commander commander) {commanders.remove(commander); }


}
