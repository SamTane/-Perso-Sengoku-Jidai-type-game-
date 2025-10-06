public class LazyCommanders extends Event {
    public LazyCommanders (Province province, Clan clan) {
        super(0, "Lazy Commanders", "Commanders are too buzy taking a nap...", province, clan);
    }

    @Override
    public void triggerEvent() {
        System.out.println("[" + clan.name + "] triggers Event : " + name + " in " + province.name +  "!");
        System.out.println(description);

    }

}