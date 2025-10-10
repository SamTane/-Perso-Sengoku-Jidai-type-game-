package core.managers;

import core.clans.Clan;
import core.Province;

import java.util.ArrayList;

public class MapManager {
    public ArrayList<Clan> clans;
    public ArrayList<Province> provinces;

    public MapManager(ArrayList<Clan> clans, ArrayList<Province> provinces) {
        this.clans = clans;
        this.provinces = provinces;
    }

    public void neighborsSetting() {
        //Listes des provinces voisines d'une province.
        for (Province province : provinces) {
            for (int neighborId : province.neighborsID) {
                for (Province neighbor : provinces) {
                    if (neighborId == neighbor.id) {
                        if (!province.neighbors.contains(neighbor)) {
                            province.addNeighbor(neighbor);
                        }
                    }
                }
            }
        }

        //Liste des provinces voisines d'un clan.
        for (Clan clan : clans) {
            for (Province province : clan.provinces) {
                for (Province provinceNeighbor : province.neighbors) {
                    if (!clan.provinceNeighbors.contains(provinceNeighbor) && !clan.provinces.contains(provinceNeighbor)) {
                        clan.addProvinceNeighbor(provinceNeighbor);
                    }
                }
            }
        }

        //Liste des clans voisins d'un clan.
        for (Clan clan : clans) {
                for (Province province : clan.provinceNeighbors) {
                    if (!clan.clanNeighbors.contains(province.owner) && !(clan == province.owner)) {
                        clan.addClanNeighbor(province.owner);
                    }
                }
        }

    }
}
