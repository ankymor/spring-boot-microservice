package com.easports.easports.rest.entity;

import java.util.*;

import com.easports.easports.rest.entity.EntityManager.Producer;

public class EASport {

    
    private static Map<String,List<EASportDetails>>  eaSportDetails = new HashMap<>();

    protected List<EASportDetails> getAllEASportsGames(){
        List<EASportDetails> returnList = new ArrayList<>();
        
        List<String> keys = new ArrayList(eaSportDetails.entrySet());
        Collections.sort(keys);

        for(String key : keys){
            returnList.addAll(eaSportDetails.get(key));
        }
        return returnList;
    }

    protected List<EASportDetails> getEASportsGames(Producer producer){
        List<EASportDetails> returnList = new ArrayList<>();
        
        List<String> keys = new ArrayList(eaSportDetails.entrySet());
        Collections.sort(keys);

        for(String key : keys){
            returnList.addAll(eaSportDetails.get(key));
        }
        return eaSportDetails.get(producer.label);
    }

    protected void addEASportGames(Producer producer, List<EASportDetails> details){
        if(eaSportDetails.get(producer.label) == null){
            eaSportDetails.put(producer.label, details);
        }else{
            List<EASportDetails> newDetails = eaSportDetails.get(producer.label);
            newDetails.addAll(details);
            eaSportDetails.put(producer.label, newDetails);
        }
    }

    protected List<String> getProductList(){
        List <String> producerList = new ArrayList<>();

        Producer[] producer = Producer.values();
        for (Producer p : producer) {
            producerList.add(p.name() +"-<-->"+p.label);
        }
        return producerList;
    }
}
