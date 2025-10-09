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



    /* Universal personal events : events that are in every provinces, are triggered by the owner,
targets them and have 1 effect */
    // 0 = LazyCommanders, 1 = TroopStrike, 2 = Sabotage
    List<Integer> universalPersonalEventsList = new ArrayList<>(List.of(0, 1, 2));


/*
    public void universalPersonalEvents() {
        for (Integer event : universalPersonalEventsList) {
            if (event == 0) {
                for (Province province : provinces) {
                    LazyCommanders lazy = new LazyCommanders(province, province.owner);
                    lazy.addTarget(province.owner, 0);
                    province.addEvent(lazy);
                }
            } else if (event == 1) {
                for (Province province : provinces) {
                    TroopStrike strike = new TroopStrike(province, province.owner);
                    strike.addTarget(province.owner, 0);
                    province.addEvent(strike);
                }
            } else {
                for (Province province : provinces) {
                    Sabotage sabotage = new Sabotage(province, province.owner);
                    sabotage.addTarget(province.owner, 0);
                    province.addEvent(sabotage);
                }
            }
        }
    }
*/

    //Trigger all register() methods from events.
    public void registerOtherEvents() {
        LazyCommanders.register(provinces);
        Sabotage.register(provinces);
        TroopStrike.register(provinces);
    }


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
