package core;

import java.util.ArrayList;

import core.battle.Commander;
import core.clans.*;
import core.events.*;
import core.managers.*;
import core.provinces.*;
import core.utils.*;
import core.other.*;


public class Main {
    public static void main(String[] args) {

        // Setup
        GameInitialization gInit = new GameInitialization();
        ArrayList<Clan> clanList = gInit.getClans(); //Creating clans
        ArrayList<Province> provinceList = gInit.getProvinces(); //Creating provinces
        ArrayList<Commander> commanderList = gInit.getCommanders();

        MapManager mm = new MapManager(clanList, provinceList);
        mm.neighborsSetting(); //Assigning neighbors

        EventManager em = new EventManager(clanList, provinceList); //Assigning Events
        em.registerOwnerEvents(); //adding OwnerEvents to provinces
        em.registerOutsiderEvents(); //adding OutsiderEvents to provinces
        em.addAvalaibleEvents(); //adding available events to clans



        /*
        gInit.basicStateOfTheGame(); //Show the basic state of the game
        */

        //Turn Loop
        TurnManager tm = new TurnManager(clanList, provinceList, em, commanderList);
        tm.turnLoop();
    }

}