package core.managers;

import java.util.ArrayList;

import core.Clan;
import core.Province;
import events.*;

public class TurnManager {
    public int turn; //Track which turn it is
    public int playerTurn; //Track which clan is playing
    public ArrayList<Clan> clans;
    public ArrayList<Province> provinces;

    public TurnManager(ArrayList<Clan> clans, ArrayList<Province> provinces) {
        this.clans = clans;
        this.provinces = provinces;
    }

    //+1 to the turn count
    public void nextTurn() {
        turn += 1;
    }


    //Go back to player 0 turns, used at the end of everyone turn
    public void turnReset() {
        playerTurn = 0;
    }

    //Adds gold income to each clan ( used at the start of each turn)
    public void income() {
        for (Clan clan : clans) {
            clan.golds = clan.golds + clan.income;
        }
    }

    //Put all clans at max actions
    public void resetActions() {
        for (Clan clan : clans){
            clan.actions = clan.maxActions;
        }
    }


    //Remove one action from clans
    public void actionUsed(Clan clan) {
        clan.actions -= 1;
    }



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

}

