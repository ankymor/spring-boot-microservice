package com.easports.easports.rest.entity;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

public class EntityManager {

    public enum Producer {	
        EA_SPORT_RALLY_SERIES("EA Sports Rally series"),
        F1("F1 series"),
        FIFA("FIFA series"),
        NFL("Madden NFL series"),
        NBA("NBA Live series"),
        NHL("NHL series"),
        UFC("UFC series"),
        FOOTBALL("EA Sports College Football");
        
        public final String label;
        private Producer(String label){
            this.label = label;
        }
    }


    private static EntityManager em = new EntityManager();

    private void EntityManager(){}

    private static EASport eaSport;

    @Autowired
    static EntityManager getEMInstance(){
        eaSport = new EASport();
        return em;
    }

    public static List<EASportDetails> getAllEASportsGames(){
        return eaSport.getAllEASportsGames();
    }


    public static List<EASportDetails> getEASportsGames(Producer producer){
        return eaSport.getEASportsGames(producer);
    }

    public static void addEASportGames(Producer producer, List<EASportDetails> details){
        eaSport.addEASportGames(producer, details);
    }

    public static List<String> getProductList(){
        return eaSport.getProductList();
    }
}
