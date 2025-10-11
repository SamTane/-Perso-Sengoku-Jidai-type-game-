package core.managers;

import core.events.Event;
import core.provinces.*;
import core.clans.*;
import core.utils.TurnUtils;


import java.util.ArrayList;
import java.util.Scanner;

public class PlayerTurnManager {
    private int indexProvince;
    private int indexEvent;
    private int provinceSelection;
    private int eventSelection;
    private ArrayList<Event> possibleEvents;
    private Boolean eventDone;
    public ArrayList<Province> provinces;
    public ArrayList<Clan> clans;
    public Clan clan;
    public Event event;
    public TurnUtils tUtils;

    public PlayerTurnManager(Clan player, TurnUtils tUtils, ArrayList<Clan> clans, ArrayList<Province> provinces) {
        this.clan = player;
        this.tUtils = tUtils;
        this.clans = clans;
        this.provinces = provinces;
    }

    public void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("< " + clan.name + ">");
        System.out.println(clan.actions + " actions");
        TurnUtils.showGolds(clan);
        while (clan.actions > 0) {
            if (!clan.availableEvents.isEmpty()) {
                indexProvince = 0;
                indexEvent = 0;
                possibleEvents = new ArrayList<>();
                eventDone = false;

                for (Province province : provinces) {
                    System.out.println(indexProvince + " : " + province.name);
                    indexProvince = indexProvince+1;
                }
                do {
                    System.out.println("Select a province by typing its id.");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Please enter a valid number.");
                        scanner.next();
                    }
                    provinceSelection = scanner.nextInt();
                    if (0 > provinceSelection || provinceSelection >= provinces.size()) {
                        System.out.println("Please enter a valid number.");
                    }
                } while (0 > provinceSelection || provinceSelection >= provinces.size());
                Province provinceChosen = provinces.get(provinceSelection);
                System.out.println(provinceChosen.name + "Events :");
                if (provinceChosen.availableEvents.isEmpty()) {
                    System.out.println("No events");
                } else {
                    while (!eventDone) {
                        do {
                            for (Event potentialEvent : provinceChosen.availableEvents) {
                                if (clan.availableEvents.contains(potentialEvent)) {
                                    System.out.println(indexEvent + " : " + potentialEvent.name);
                                    possibleEvents.add(potentialEvent);
                                    indexEvent = indexEvent + 1;
                                }
                            }
                            System.out.println("-1 : Go back to Province selection.");
                            eventSelection = scanner.nextInt();
                            if (eventSelection == -1) {
                                eventDone = true;
                            } else if (0 > eventSelection || eventSelection >= possibleEvents.size()){
                                System.out.println("Please enter a valid number.");
                            }
                        } while ((0 > eventSelection || eventSelection >= possibleEvents.size()) && (!eventDone));
                       if (eventSelection != -1) {
                           event = possibleEvents.get(eventSelection);
                           tUtils.SimulateActions(clan, event);
                           System.out.println(clan.actions + " actions left.");
                           eventDone = true;
                       }
                    }
                }

            } else {
                clan.actions = 0;
            }
        }

    }
}
