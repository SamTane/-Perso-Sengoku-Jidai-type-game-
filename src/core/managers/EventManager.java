package core.managers;


import core.clans.Clan;
import core.Province;
import core.events.*;
import core.events.ownerEvents.LazyCommanders;
import core.events.outsiderEvents.Pillage;
import core.events.ownerEvents.Sabotage;
import core.events.ownerEvents.TroopStrike;

import java.util.ArrayList;

public class EventManager {

    public ArrayList<Clan> clans;
    public ArrayList<Province> provinces;

    public EventManager(ArrayList<Clan> clans, ArrayList<Province> provinces) {
        this.clans = clans;
        this.provinces = provinces;
    }

    //Trigger all register() methods from core.events.
    public void registerOtherEvents() {
        LazyCommanders.register(provinces);
        Sabotage.register(provinces);
        TroopStrike.register(provinces);
        Pillage.register(provinces, clans);
    }

//add all availableEvents to all clans
    public void addAvalaibleEvents() {
        for (Clan clan : clans) {
            clan.availableEvents.clear();
            for (Province province : provinces) {
                for (Event possibleEvent : province.availableEvents) {
                    if (possibleEvent.canBeTriggeredBy(clan) && possibleEvent.source == clan) {
                        clan.addAvailableEvent(possibleEvent);
                    }
                }
            }
        }
    }
}
