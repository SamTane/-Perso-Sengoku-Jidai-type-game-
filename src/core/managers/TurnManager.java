package core.managers;

import java.util.ArrayList;

import core.clans.*;
import core.events.*;
import core.other.Player;
import core.provinces.*;
import core.utils.*;

public class TurnManager {

    ArrayList<Province> provinces;
    ArrayList<Clan> clans;
    EventManager em;

    public TurnManager(ArrayList<Clan> clans, ArrayList<Province> provinces, EventManager em) {
        this.clans = clans;
        this.provinces = provinces;
        this.em = em;
    }

    public void turnLoop() {
        TurnUtils tUtils = new TurnUtils(clans, provinces);
        Player player = new Player(clans.get(0));
        Clan playerClan = player.getPlayerClan();
        PlayerTurnManager pTurn = new PlayerTurnManager(playerClan, tUtils, clans, provinces);
        for (int i = 0; i <= 2; i++) { //Number of turns
            tUtils.nextTurn(); //+1 turn at the start of the loop
            tUtils.resetActions(); //Each clans actions are reset to max at the start of the turn
            tUtils.incomeUpdate(); //Each clan income is updated at the start of the turn
            System.out.println("\n \n \n \n************");
            System.out.println("** Turn " + tUtils.turn + " **");
            System.out.println("************");
            for (Clan clan : clans) {
                em.addAvalaibleEvents();
                System.out.println(" \n ");
                if (clan == player.getPlayerClan()) {
                    pTurn.playerTurn();
                } else {
                    System.out.println("< " + clan.name + ">");
                    System.out.println(clan.actions + " actions");
                    TurnUtils.showGolds(clan);
                    do {
                        if (!clan.availableEvents.isEmpty()) {
                            int IndexEvent = (int)(Math.random() * clan.availableEvents.size());
                            Event event = clan.availableEvents.get(IndexEvent);
                            System.out.println();
                            tUtils.SimulateActions(clan, event);
                            System.out.println(clan.actions + " actions left.");
                        } else {
                            clan.actions = 0;
                        }
                    } while (clan.actions > 0);
                }
            }
            tUtils.income();
        }
    }
}
