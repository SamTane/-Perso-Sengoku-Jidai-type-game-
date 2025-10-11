package core.events;
import core.clans.Clan;
import core.provinces.Province;

import java.util.ArrayList;

public abstract class Event {
    public String name; //name of the event
    public int id; //id of the event
    public Clan source; //what clan is triggering the event
    public ArrayList<Clan> targets; //list of clans that are getting consequences from this event
    public ArrayList<Integer> results; //each target must have a corresponding result (outcome)
    public Province holder; //In which province is the event


    public Event (int id, String name, Clan source, Province holder) {
        this.id = id;
        this.name = name;
        this.source = source;
        this.targets = new ArrayList<>();
        this.results = new ArrayList<>();
        this.holder = holder;

    }

    public String getDescription(Clan target, int result) {
        return " ";
    }

     public abstract void triggerEvent();
    //method to trigger an event

    public void addTarget(Clan target, int result) {
        targets.add(target);
        results.add(result);
    } //Each target must have a corresponding result
    //Target = which clan is targeted, and result = what consequences are they getting
    //This way, multiple clans can be targeted by an event, and they can have different outcomes
    //(like one clan losing gold and another clan gaining gold)

    public void removeTarget(Clan target, int result) {
        int index = targets.indexOf(target);
        if (index != -1) {
            targets.remove(index);
            results.remove(index);
        }
    } //Remove the target and it's corresponding result from the list

    public boolean canBeTriggeredBy(Clan clan) {
        return true; // Default to always triggerable
    }

}
