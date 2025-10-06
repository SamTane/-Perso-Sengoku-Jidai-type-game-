package core;

import java.util.ArrayList;
import events.*;

public class Province {
    public int id;
    public String name;
    public int[] neighbors;
    public Clan owner;
    public ArrayList<Event> availableEvents;
    public int income;

    public Province(int id, String name, int[] neighbors, Clan owner, int income) {
        this.id = id;
        this.name = name;
        this.neighbors = neighbors;
        this.owner = owner;
        this.availableEvents = new ArrayList<>();
        this.income = income;
    }
    public void addEvent(Event event) {
        availableEvents.add(event);
    }


}
