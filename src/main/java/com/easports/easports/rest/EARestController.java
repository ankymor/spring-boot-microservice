package com.easports.easports.rest;
import java.util.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easports.easports.rest.entity.EASportDetails;
import com.easports.easports.rest.entity.EntityManager;
import com.easports.easports.rest.entity.EntityManager.Producer;

@RestController
public class EARestController {

    EntityManager em;
    
    @GetMapping("/rest/version")
    public List<String> getEAGamesVersion(){
        List<String> gamesList = new ArrayList<>();
        gamesList.add("2010");
        gamesList.add("2011");
        gamesList.add("2016");
        gamesList.add("2018");
        gamesList.add("2022");

        return gamesList;
    }

    @GetMapping("rest/games")
    public List<EASportDetails> getAllEASportsGames(){
        return em.getAllEASportsGames();
    }

    @RequestMapping(value = "rest/games/{producer}" , method = RequestMethod.GET)
    public List<EASportDetails> getEASportDetails(@PathVariable Producer producer){
        return em.getEASportsGames(producer);
    }

    @RequestMapping(value = "rest/games/{producer}" , method = RequestMethod.POST)
    public void addEASportDetails(@PathVariable Producer producer , @RequestBody List<EASportDetails> details){
        em.addEASportGames(producer, details);
    }

    @RequestMapping(value = "rest/games/products", method = RequestMethod.GET)
    public List<String> getProductList(){
        return em.getProductList();
    }
}
