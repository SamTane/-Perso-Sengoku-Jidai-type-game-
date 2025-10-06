package events;
import core.*;

public class LazyCommanders extends Event {
    public LazyCommanders (Province province) {
        super(0, "Lazy Commanders", "Commanders are too buzy taking a nap...", province);
    }

    @Override
    public void triggerEvent() {
        System.out.println("[" + province.owner.name + "] triggers |" + name + "| in " + province.name +  "!");
        System.out.println(description);
        province.owner.actions -= 1;

    }

}