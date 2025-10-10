package core;

import java.util.ArrayList;

import core.clans.Clan;
import core.events.*;

public class Province {
    public int id;
    public String name;
    public int[] neighborsID;
    public ArrayList<Province> neighbors;
    public Clan owner;
    public ArrayList<Event> availableEvents;
    public int income;

    public Province(int id, String name, Clan owner, int income, int[] neighborsID) {
        this.id = id;
        this.name = name;
        this.neighborsID = neighborsID;
        this.neighbors = new ArrayList<>();
        this.owner = owner;
        this.availableEvents = new ArrayList<>();
        this.income = income;
    }
    public void addEvent(Event event) {
        availableEvents.add(event);
    }

    public void addNeighbor(Province neighbor) { neighbors.add(neighbor);}
    public void removeNeighbor(Province neighbor) { neighbors.remove(neighbor);}


}
