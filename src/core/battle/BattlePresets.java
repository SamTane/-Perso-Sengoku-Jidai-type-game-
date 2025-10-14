package core.battle;
import java.util.ArrayList;

import core.clans.Clan;


public class BattlePresets {
    ArrayList<Commander> commanders;

    public BattlePresets() {

        this.commanders = new ArrayList<>();

        Clan cWesterners = new Clan(99, "Westerners", 0, 0, 2);
        Clan eEasterners = new Clan(100, "Easterners", 0, 0, 2);

        Troop cannonFodder = new Troop("Cannon Fodders", 30, 10, 100, false, true);

        Commander testChan = new Commander("Test-Chan", cWesterners, cannonFodder, 500, 4, 4, 4, 1);
        Commander testKun = new Commander("Test-Kun", eEasterners, cannonFodder, 500, 4, 4, 4, 1);
        commanders.add(testChan);
        commanders.add(testKun);

    }

    public ArrayList<Commander> getCommanders() {
        return commanders;
    }
}
