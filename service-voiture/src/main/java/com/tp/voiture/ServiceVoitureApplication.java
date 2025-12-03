package com.tp.voiture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import com.tp.voiture.entities.Voiture;
import com.tp.voiture.repositories.VoitureRepository;
import com.tp.voiture.services.ClientService;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceVoitureApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceVoitureApplication.class, args);
    }

    @Bean
    CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService) {
        return args -> {
            System.out.println("Démarrage de l'insertion des voitures...");

            // Attendre 3 secondes pour que le service client soit prêt
            Thread.sleep(3000);

            try {
                // Version SIMPLE sans appel au service client (pour éviter les erreurs)
                voitureRepository.save(new Voiture(null, "Toyota", "A 25 333", "Corolla", 1L, null));
                voitureRepository.save(new Voiture(null, "Renault", "B 6 3456", "Megane", 2L, null));
                voitureRepository.save(new Voiture(null, "Peugeot", "A 55 4444", "301", 3L, null));

                System.out.println("✅ 3 voitures créées avec succès !");
                System.out.println("Toyota pour clientId=1");
                System.out.println("Renault pour clientId=2");
                System.out.println("Peugeot pour clientId=3");

            } catch(Exception e) {
                System.out.println("⚠️ Erreur lors de la création des voitures : " + e.getMessage());
                // On continue même en cas d'erreur
            }
        };
    }
}