public class TroopStrike extends Event {
    public TroopStrike(Province province, Clan clan) {
        super(0, "Troop Strike!", "Local troops go on a strike! ", province, clan);
    }

    @Override
    public void triggerEvent() {
        System.out.println("[" + clan.name + "] triggers Event : " + name + " in " + province.name +  "!");
        System.out.println(description);

    }

}