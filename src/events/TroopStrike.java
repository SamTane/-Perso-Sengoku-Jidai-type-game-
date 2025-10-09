package events;
import core.*;
import core.managers.*;

import java.util.ArrayList;
import java.lang.reflect.Array;


public class TroopStrike extends Event {

    public Province holder;
    public TroopStrike(Province holder, Clan source) {
        super(0, "Troop Strike!", source, holder);
        this.holder = holder;
    }

    public static void register(ArrayList<Province> allProvinces) {
        for (Province province : allProvinces) {
            province.addEvent(new TroopStrike(province, province.owner));
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