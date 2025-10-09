package events;
import core.*;

import java.util.ArrayList;
import java.lang.reflect.Array;

public abstract class Event {
    public String name;
    public int id;
    public Clan source;
    public ArrayList<Clan> targets;
    public ArrayList<Integer> results;
    public ArrayList<Clan> possibleSources;
    public ArrayList<Province> holders;
    public Province holder;

    public Event (int id, String name, Clan source, Province holder) {
        this.id = id;
        this.name = name;
        this.source = source;
        this.targets = new ArrayList<>();
        this.results = new ArrayList<>();
        this.possibleSources = new ArrayList<>();
        this.holders = new ArrayList<>();
        this.holder = holder;

    }

    public String getDescription(Clan target, int result) {
        return " ";
    }

     public abstract void triggerEvent();

    public void addTarget(Clan target, int result) {
        targets.add(target);
        results.add(result);
    } //Each target must have a corresponding result

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


    public void addHolder(Province holder) {holders.add(holder); }
    public void removeHolder(Province holder) {holders.remove(holder); }
    //Remove or add a province holding this event



}
