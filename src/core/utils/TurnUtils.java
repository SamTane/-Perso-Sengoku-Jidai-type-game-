package core.utils;

import java.util.ArrayList;

import core.clans.Clan;
import core.provinces.Province;
import core.events.*;

public class TurnUtils {
    public int turn; //Track which turn it is
    public int playerTurn; //Track which clan is playing
    public ArrayList<Clan> clans;
    public ArrayList<Province> provinces;

    public TurnUtils(ArrayList<Clan> clans, ArrayList<Province> provinces) {
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



    public void SimulateActions(Clan clan, Event event) {
        event.triggerEvent();
        actionUsed(clan);
    }

    //Updates the gold income of all clans
    public void incomeUpdate() {
        for (Clan clan : clans) {
            int provincesIncome = 0;
            int otherIncomes = 0;
            for (Province province : clan.provinces) {
                provincesIncome = provincesIncome + province.income;
            }
            clan.income = otherIncomes + provincesIncome;
            //Later I will add other source income, otherIncomes is placeholder
        }
    }

    public static void showGolds(Clan clan) {
        if (clan.golds < 0) {
            clan.golds = 0;
        }
        System.out.println(clan.name + " Golds : " + clan.golds);
    }

}

