
# README - Projet Java Spring Boot + MySQL

Bienvenue dans le projet **Api Rest**.  
Ce projet contient une **API REST full Spring Boot** reliée à une base de données **MySQL**.

---

## 📦 Technologies utilisées

- Java 17
- Spring Boot (JPA, Web, Validation, etc.)
- MySQL 8
- Maven
- (À venir : frontend)

---

## 📁 Structure du projet

```
/GestionnaireFormation
│
├── src/main/java/com/afpa/ApiRest/
│   ├── DTO/          → Data Transfer Object (DTO)
│   ├── model/        → Entités JPA (@Entity)
│   ├── repository/   → Interfaces Spring Data JPA
│   ├── service/      → Logique métier
│   ├── controller/   → API REST exposée
│   └── ApiRestApplication.java → Point d’entrée de l’application
├── README.md         → Ce fichier
└── target/ApiRest.jar → Le .jar généré par Maven
```

### 📦 Controller/
Chaque ressource a son contrôleur = 🔥 REST bien segmenté

➡️ Permets de bosser plus facilement en équipe ou ajouter de la sécurité par ressource plus tard.

### 📦 DTO/
Bien organisé, bien nommé, pas de doublon.

➡️ Je sépare les entités de la couche API, je fais le mapping entre les entités et les DTO.

### 📦 Model/
Les entités sont propres, les jointures sont gérées (FormationDocument, FormationRessource).

➡️ Il y a les @Embeddable Key séparés pour une meilleure lisibilité.

### 📦 Repository/
Un repo par entité = Single Responsibility respectée.

### 📦 Service/
Logique métier isolé, pas de dépendance avec le reste du projet. Il sera possible de faire ensuite :
- des validations
- des règles métiers
- de la sécurité ou des logs
- des tests unitaires, .......

➡️ Je peux facilement ajouter des fonctionnalités sans toucher au reste du code. Ou changer de techno sans toucher au reste du code.

---

### 📦 Compiler le projet

```bash
mvn clean package
```

Cela génère un `.jar` dans `/target`.

### 📦 Lancer l’application complète

- Le backend est accessible sur **http://localhost:8080**
- La base de données MySQL écoute sur **localhost:3306**
---

## ⚙️ Configuration base de données (application.properties)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/{nom_de_la_base}
spring.datasource.username={nom_utilisateur}
spring.datasource.password={mot_de_passe}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
- Remplace `{nom_de_la_base}`, `{nom_utilisateur}` et `{mot_de_passe}`.
---

## 👨‍💻 Explication des relations JPA

- **Entité** = table
- **@ManyToMany / @OneToMany / @ManyToOne** = relations entre entités
- Utilisation de **`@JoinTable`** ou **`@JoinColumn`** pour gérer les tables de jointure
- Utilisation de **`@JsonIgnore`** pour casser les boucles infinies dans les relations bidirectionnelles

---

## 🧠 Lexique pro pour expliquer ton code

| Ce que je fais         | Ce que je peux dire                                     |
|------------------------|---------------------------------------------------------|
| Créer une table        | “J’ai modélisé une entité persistante avec JPA”         |
| Lier deux classes      | “J’ai défini une relation bidirectionnelle ManyToMany”  |
| Ajouter un champ       | “J’ai ajouté un attribut mappé via JPA dans l’entité”   |
| Lire ou écrire en base | “Je passe par le repository Spring Data”                |
| Appeler l’API          | “Je consomme l’endpoint REST défini dans le contrôleur” |

---

## 🛠️ À venir

| Étape                                                    | Objectif                                                        |
|----------------------------------------------------------|-----------------------------------------------------------------|
| 🛡️ Spring Security + JWT                                | Authentifier les users, protéger les routes                     |
| 🧪 Tests unitaires (JUnit)                               | Commencer les tests sur services et controllers                 |
| 🐳 Docker / Docker Compose                               | Conteneuriser ton backend et la BDD (t’es déjà presque prêt)    |
| 📄 Swagger / OpenAPI                                     | Générer une doc de ton API automatiquement                      |
| 🔍 Mapper (ModelMapper / MapStruct)                      | Remplacer les `mapToDTO()` manuels pour clean code +            |
| 🌍 Flutter, thymeleaf, javaFX, Angular, Vue.js, React    | Connecter ton backend à ton futur frontend                      |


---

## 🛠️ Exemples de l'entité Utilisateur avec explications

```java
// File: Utilisateur.java
// chemin du fichier : src/main/java/com/afpa/ApiRest/model/Utilisateur.java
package com.ofpo.ApiRest.model;

// Importation des annotations nécessaires pour JPA et Lombok
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

// Importation des classes nécessaires pour la gestion des listes
import java.util.ArrayList;
import java.util.List;

@Entity // Indique que cette classe est une entité JPA
@Table(name = "utilisateur") // Indique le nom de la table correspondante dans la base de données
@Data // Regroupe @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
public class Utilisateur {

    @Id // Indique que cette propriété est la clé primaire de l'entité
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Indique que la valeur de la clé primaire est générée automatiquement
    // Indique que la valeur de la clé primaire est générée automatiquement
    private Long id;
    // Indique les propriétés de l'entité
    private String matricule;
    private String avatar;
    private String nom;
    private String prenom;
    private String adresseMail;
    private String adressePostal;
    private String codePostal;
    private String ville;
    private String motDePasse;
    private Boolean statut;

    // Jointure pour la relation ManyToMany entre Utilisateur et Role
    @ManyToMany
    // Indique que cette propriété est une relation ManyToMany
    @JoinTable(
            name = "utilisateur_role",
            joinColumns = @JoinColumn(name = "id_utilisateur"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    // Indique le nom de la table de jointure et les colonnes correspondantes
    @JsonIgnore // Ignore cette propriété lors de la sérialisation JSON
    // @JsonIgnore est utilisé pour éviter les boucles infinies lors de la sérialisation JSON lorsque la relation est bidirectionnelle
    private List<Role> roles = new ArrayList<>(); // Liste des rôles associés à l'utilisateur
    // new ArrayList<>(); // Initialise la liste des rôles associés à l'utilisateur et évite les NullPointerException
    // NullPointerException // sans sérialisation, il faut vérifier à chaque fois si la liste est null avant de l'utiliser
    // Avec new ArrayList<>();, il est possible de faire un getList() sans vérifier si la liste est null

    // Jointure pour la relation ManyToMany entre Utilisateur et Formation
    @ManyToMany
    @JoinTable(
            name = "utilisateur_formation_fonction",
            joinColumns = @JoinColumn(name = "id_utilisateur"),
            inverseJoinColumns = @JoinColumn(name = "id_formation")
    )
    private List<Formation> formations = new ArrayList<>();
}
```
---
## 🧯 Mon Résumé 😎

> “J’ai structuré le projet en respectant l’architecture MVC, j’ai isolé les services, utilisé des pratiques pro côté JPA, évité les boucles de sérialisation JSON et préparé l’ajout du front.”

---
## 👤 Auteur
**Projet géré par :** Jonathan aka Joker 🃏  

