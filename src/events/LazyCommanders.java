package events;
import core.*;

import java.util.ArrayList;
import java.lang.reflect.Array;


public class LazyCommanders extends Event {

    public Province holder;
    public LazyCommanders(Province holder , Clan source) {
        super(0, "Lazy Commanders", source, holder);
        this.holder =  holder;
    }

    public static void register(ArrayList<Province> allProvinces) {
        for (Province province : allProvinces) {
            province.addEvent(new LazyCommanders(province, province.owner));
        }
    }




    @Override
    public String getDescription(Clan target, int result) {
        if (result == 0) {
            return "Commanders are taking are goofing around in " + holder.name;
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
        if (clan == holder.owner) {
            return true; // Owner only event
        }
        else {
            return false;
        }
    }



}
