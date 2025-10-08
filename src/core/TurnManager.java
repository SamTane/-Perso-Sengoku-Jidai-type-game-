package core;

import java.util.ArrayList;
import events.*;

public class TurnManager {
    public int turn; //Track which turn it is
    public int playerTurn; //Track which clan is playing
    public ArrayList<Clan> clans;
    public ArrayList<Province> provinces;
    public int eventRandomizer;

    public TurnManager(ArrayList<Clan> clans, ArrayList<Province> provinces) {
        this.clans = clans;
        this.provinces = provinces;
    }
    //Tracks the list of clans, useful for income and actions count

    public void nextTurn() {
        turn += 1;
    }
    //+1 to the turn count

    public void turnReset() {
        playerTurn = 0;
    }
    //Go back to player 0 turns, used at the end of everyone turn

    public void income() {
        for (Clan clan : clans) {
            clan.golds = clan.golds + clan.income;
        }
    }
    //Used at the end of each turn, adds gold income to each clan at the start of the turn

    public void resetActions() {
        for (Clan clan : clans){
            clan.actions = clan.maxActions;
        }
    }
    //Put all clans at max actions


    public void actionUsed(Clan clan) {
        clan.actions -= 1;
    }
    //Remove one action from clans
    public void SimulateActions(Clan clan, Province province) {
        int index = (int)(Math.random() * province.availableEvents.size());
        Event event = province.availableEvents.get(index);
        event.triggerEvent();
        actionUsed(clan);
    }

    public void incomeUpdate() {
        for (Clan clan : clans) {
            for (Province province : clan.provinces) {
                clan.income = clan.income + province.income;
            }
        }
    }

    public void addNeighbors() {

    }

}

