package events;
import core.*;

import java.util.ArrayList;
import java.lang.reflect.Array;


public class LazyCommanders extends Event {
    public LazyCommanders (Province province , Clan source) {
        super(0, "Lazy Commanders",  province, source);
    }



    @Override
    public String getDescription(Clan target, int result) {
        if (result == 0) {
            return "Commanders are taking are goofing around in " + province.name;
        } else {
            return " ";
        }
    }

    @Override
    public void triggerEvent() {
        System.out.println("[" + source.name + "] triggers |" + name + "| in " + province.name +  "!");
        for (int i = 0; i < targets.size();i++) {
            Clan target = targets.get(i);
            int result = results.get(i);
            if (result == 0) {
                System.out.println(getDescription(target, result));
                target.actions -= 1;
            }
            }
        }
}
