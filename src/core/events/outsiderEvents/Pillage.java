package core.events.outsiderEvents;
import core.clans.Clan;
import core.utils.TurnUtils;
import core.events.Event;
import core.provinces.Province;

import java.util.ArrayList;


public class Pillage extends Event {

    public Province holder;
    public Pillage(Province holder , Clan source) {
        super(3, "Pillage", source, holder);
        this.holder =  holder;
    }




    //All event have a set of provinces that are chosen manually.
    public static void register(ArrayList<Province> allProvinces, ArrayList<Clan> allClans) {
        for (Province province : allProvinces) {     //This event is applied to all provinces
            for (Clan clan : allClans) {
                if ( clan != province.owner && clan.provinceNeighbors.contains(province)) {
                    Event event = new Pillage(province, clan);
                    event.addTarget(province.owner, 0);
                    event.addTarget(clan, 1);
                    province.addEvent(event);
                }

            }


        }
    }




    @Override
    public String getDescription(Clan target, int result) {
        if (result == 0) {
            return  "Pillaging goods in " + holder.name + "!\n" +
                    source.name + " stole 15 golds from " + holder.owner.name + "!";
        }  else if (result == 1) {
            return " ";
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
                target.golds -= 15;
                TurnUtils.showGolds(target);
            } else if (result == 1) {
                target.golds += 15;
                TurnUtils.showGolds(target);
            }
        }
    }
    @Override
    public boolean canBeTriggeredBy(Clan clan) {
        if (clan != holder.owner) {
            if (clan.provinceNeighbors.contains(holder)) {
                return true; // Bandits exclusive core.events that only works on neighbors provinces
            }
            return false;
        }
        else {
            return false;
        }
    }

}
