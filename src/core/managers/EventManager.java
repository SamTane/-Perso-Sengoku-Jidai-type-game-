package core.managers;


import core.Clan;
import core.Province;
import events.*;
import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;

public class EventManager {

    public ArrayList<Clan> clans;
    public ArrayList<Province> provinces;

    public EventManager(ArrayList<Clan> clans, ArrayList<Province> provinces) {
        this.clans = clans;
        this.provinces = provinces;
    }

    //Trigger all register() methods from events.
    public void registerOtherEvents() {
        LazyCommanders.register(provinces);
        Sabotage.register(provinces);
        TroopStrike.register(provinces);
    }

//add all availableEvents to all clans
    public void addAvalaibleEvents() {
        for (Clan clan : clans) {
            clan.availableEvents.clear();
            for (Province province : provinces) {
                for (Event possibleEvent : province.availableEvents) {
                    if (possibleEvent.canBeTriggeredBy(clan)) {
                        clan.addAvailableEvent(possibleEvent);
                    }
                }
            }
        }
    }
}
