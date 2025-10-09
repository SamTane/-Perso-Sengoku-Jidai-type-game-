package events;
import core.*;
import core.managers.*;

import java.util.ArrayList;
import java.lang.reflect.Array;


public class Sabotage extends Event {

    public Province holder;
    public Sabotage(Province holder, Clan source) {
        super(0, "Sabotage!", source, holder);
        this.holder = holder;
    }

    //All event have a set of provinces that are chosen manually.
    //This event is applied to all provinces, so we can use a loop, but this is an exception
    public static void register(ArrayList<Province> allProvinces) {
        for (Province province : allProvinces) {
            province.addEvent(new Sabotage(province, province.owner));
        }
    }

    @Override
    public String getDescription(Clan target, int result) {
        if (result == 0) {
            return "A rival clan spy made a fuss in " + holder.name  + "! " +
                    "\n- 30 gold !";
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
                target.golds -= 30;;
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