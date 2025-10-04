public class Main {
    public static void main(String[] args) {
        //Clans :
        Clan clan1 = new Clan(1, "Central", 120);
        Clan clan2 = new Clan(2, "Bandits", 70);
        Clan clan3 = new Clan(3, "Forgerons", 100);
        Clan clan4 = new Clan(4, "Happy Merchants", 140);
        Clan clan5 = new Clan(5, "Nun Institute", 100);


        //Provinces :
        Province province1 = new Province(1, "The Middle", new int[]{2, 3, 4, 5}, clan1);
        clan1.addProvince(province1);
        Province province2 = new Province(2, "Rififi Forest", new int[]{1, 3, 5}, clan2);
        clan2.addProvince(province2);
        Province province3 = new Province(3, "Coco Hills", new int[]{1, 2, 4}, clan1);
        clan3.addProvince(province3);
        Province province4 = new Province(4, "Porto Maestro", new int[]{1, 3, 5}, clan1);
        clan4.addProvince(province4);
        Province province5 = new Province(5, "Miko Mountains", new int[]{1, 3, 4}, clan1);
        clan5.addProvince(province5);
        Province province6 = new Province(6, "Talmud", new int[]{1, 3, 4}, clan1);
        clan4.addProvince(province6);


        Clan[] clans = {clan1, clan2, clan3, clan4, clan5};


        for (Clan clan : clans) {

            System.out.println(clan.name + " owns " + clan.provinces.size() + " provinces :");
            for (Province province : clan.provinces) {
                System.out.println(province.name + "." + " Borders :");
                for (int neighborId : province.neighbors) {
                    System.out.println(neighborId);
                }
            }
        }
    }
}