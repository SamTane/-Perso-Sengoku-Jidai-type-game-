package core.other;
import core.clans.*;

public class Player {
    private Clan playerClan;

    public Player(Clan playerClan) {
        this.playerClan = playerClan;
    }

    public Clan getPlayerClan() {
        return playerClan;
    }
}
