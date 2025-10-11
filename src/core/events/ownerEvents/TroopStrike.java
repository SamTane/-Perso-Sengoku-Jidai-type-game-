package core.events.ownerEvents;
import core.clans.Clan;
import core.events.Event;
import core.provinces.Province;

import java.util.ArrayList;


public class TroopStrike extends Event {

    public Province holder;
    public TroopStrike(Province holder, Clan source) {
        super(2, "Troop Strike!", source, holder);
        this.holder = holder;
    }

    //All event have a set of provinces that are chosen manually.
    //This event is applied to all provinces, so we can use a loop, but this is an exception
    public static void register(ArrayList<Province> allProvinces) {
        for (Province province : allProvinces) {
            Event event = new TroopStrike(province, province.owner);
            event.addTarget(province.owner, 0);
            province.addEvent(event);
        }
    }

    @Override
    public String getDescription(Clan target, int result) {
        if (result == 0) {
            return "Troops are on a strike in " + holder.name  + "!";
        } else {
            return " ";
        }

    }

    @Override
    public void triggerEvent() {
        System.out.println("[" + source.name + "] triggers : |" + name + "| in " + holder.name +  "!");
        for (int i = 0; i < targets.size();i++) {
            Clan target = targets.get(i);
            int result = results.get(i);
            if (result == 0) {
                System.out.println(getDescription(target, result));
            }
        }
    }
    @Override
    public boolean canBeTriggeredBy(Clan clan) {
        if (clan == holder.owner) {
            return true; // Owner only event
        }
        else {
            return false;
        }
    }


}