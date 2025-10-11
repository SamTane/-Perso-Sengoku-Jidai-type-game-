package core.events.ownerEvents;
import core.clans.Clan;
import core.events.Event;
import core.provinces.Province;

import java.util.ArrayList;


public class LazyCommanders extends Event {

    public Province holder;
    public LazyCommanders(Province holder , Clan source) {
        super(0, "Lazy Commanders", source, holder);
        this.holder =  holder;
    }

    //All event have a set of provinces that are chosen manually.
    public static void register(ArrayList<Province> allProvinces) {
        for (Province province : allProvinces) {     //This event is applied to all provinces
            Event event = new core.events.ownerEvents.LazyCommanders(province, province.owner); //This event is always triggered by the province owner
            event.addTarget(province.owner, 0); //This event only affect the owner
            province.addEvent(event);
        }
    }




    @Override
    public String getDescription(Clan target, int result) {
        if (result == 0) {
            return "Commanders are goofing around in " + holder.name;
        } else {
            return " ";
        }
    }


    @Override
    public void triggerEvent() {
        System.out.println("[" + source.name + "] triggers |" + name + "| in " + holder.name +  "!");
        for (int i = 0; i < targets.size();i++) {
            Clan target = targets.get(i);
            int result = results.get(i);
            if (result == 0) {
                System.out.println(getDescription(target, result));
                target.actions -= 1;
            }
        }
    }

    @Override
    public boolean canBeTriggeredBy(Clan clan) {
        if (clan == holder.owner && clan.actions > 1) {
            return true; // Owner only event, can only be triggered if actions are more than 1
        }
        else {
            return false;
        }
    }



}
