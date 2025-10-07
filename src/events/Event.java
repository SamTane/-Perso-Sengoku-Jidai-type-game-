package events;
import core.*;

import java.util.ArrayList;
import java.lang.reflect.Array;

public abstract class Event {
    public String name;
    public int id;
    public Province province;
    public Clan source;
    public ArrayList<Clan> targets;
    public ArrayList<Integer> results;

    public Event (int id, String name, Province province, Clan source) {
        this.id = id;
        this.name = name;
        this.province = province;
        this.source = source;
        this.targets = new ArrayList<>();
        this.results = new ArrayList<>();
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




}
