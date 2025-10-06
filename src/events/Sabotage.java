package events;
import core.*;

public class Sabotage extends Event {
    public Sabotage(Province province) {
        super(0, "events.Sabotage!", "A spy sabotaged us! -30 G ", province);
    }

    @Override
    public void triggerEvent() {
        System.out.println("[" + province.owner.name + "] triggers : |" + name + "| in " + province.name +  "!");
        System.out.println(description);
        province.owner.golds -= 30;


    }

}