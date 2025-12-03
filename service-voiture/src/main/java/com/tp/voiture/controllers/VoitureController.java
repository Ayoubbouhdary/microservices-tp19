package com.tp.voiture.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import java.util.List;
import com.tp.voiture.entities.Voiture;
import com.tp.voiture.repositories.VoitureRepository;
import com.tp.voiture.services.ClientService;

@RestController
public class VoitureController {
    @Autowired
    VoitureRepository voitureRepository;

    @Autowired
    ClientService clientService;

    @GetMapping("/voitures")
    public List<Voiture> findAll() {
        List<Voiture> voitures = voitureRepository.findAll();
        // Pour chaque voiture, récupérer le client
        for(Voiture v : voitures) {
            try {
                v.setClient(clientService.clientById(v.getClientId()));
            } catch(Exception e) {
                // Ignorer si client non trouvé
            }
        }
        return voitures;
    }
}