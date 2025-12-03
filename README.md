# TP Microservices Spring Boot

## Auteur
[Ton Nom]

## Description
Ce projet contient 4 microservices :
1. **Eureka Server** - Service de découverte (port 8761)
2. **Service Client** - Gestion des clients (port 8088)
3. **Service Voiture** - Gestion des voitures (port 8089)
4. **Gateway** - Point d'entrée unique (port 8888)

## Comment exécuter

### Prérequis
- Java 17
- Maven

### Étapes d'exécution
1. **Démarrer Eureka Server** :
```bash
cd eureka-server
mvn spring-boot:run