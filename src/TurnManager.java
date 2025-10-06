import java.util.ArrayList;

public class TurnManager {
    public int turn; //Track which turn it is
    public int playerTurn; //Track which clan is playing
    public ArrayList<Clan> clans;
    public ArrayList<Province> provinces;

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
        TroopStrike nap = new TroopStrike(province, clan);
        nap.triggerEvent();
        actionUsed(clan);
    }

}
