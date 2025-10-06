package events;
import core.*;

public class TroopStrike extends Event {
    public TroopStrike(Province province) {
        super(0, "Troop Strike!", "Local troops go on a strike! ", province);
    }

    @Override
    public void triggerEvent() {
        System.out.println("[" + province.owner.name + "] triggers : |" + name + "| in " + province.name +  "!");
        System.out.println(description);


    }

}