# Paradise Hotel Management

![Le Paradise](https://github.com/AlphaxHotelxMikexEchoxDelta/Paradise/assets/95902084/5ffb6a1a-2734-4d31-ab0d-8a991d675694)

## 1. Présentation de l'Application

L'application **Paradise Hotel Management** offre une interface conviviale pour gérer efficacement les réservations dans un hôtel. Elle prend en charge diverses fonctionnalités telles que la gestion des détails des clients, la réservation de chambres de quatre types différents, la gestion des commandes de repas, l'affichage des caractéristiques des chambres et de leur disponibilité. L'application utilise des fichiers pour stocker les informations de réservation, assurant ainsi la persistance des données entre les sessions d'utilisation.

## 2. Architecture du Projet

L'architecture du projet suit les principes de l'orienté objet, utilisant des classes et des objets pour modéliser les entités du système. L'héritage est appliqué pour représenter les différentes catégories de chambres. La gestion des fichiers est utilisée pour assurer la persistance des données. Les collections sont employées pour manipuler et organiser les données de manière efficace.

## 3. Organisation du Code

Le code est organisé de manière à garantir la lisibilité, la maintenabilité et l'extensibilité. Les principaux concepts tels que l'héritage, la sérialisation, la gestion des exceptions et les collections sont clairement mis en évidence. Des tests approfondis ont été effectués pour garantir le bon fonctionnement de l'application.



## 4. Partie Spécifique du Code - Gestion de la Sérialisation

La gestion de la sérialisation constitue une partie essentielle du code, garantissant la persistance des données entre les sessions d'utilisation de l'application **Paradise Hotel Management**. La sérialisation en Java est utilisée pour convertir les objets en un format pouvant être stocké dans des fichiers, assurant ainsi la préservation de l'état actuel de l'hôtel.

### Sérialisation

Lorsqu'une réservation est effectuée, les détails du client, les informations sur la chambre réservée et les commandes de repas associées sont sérialisés pour être enregistrés dans un fichier. Cela permet de conserver les réservations même après la fermeture de l'application. Lors du redémarrage, le programme lit le fichier sérialisé pour récupérer les réservations antérieures.

```java
FileOutputStream file = new FileOutputStream( filename );
ObjectOutputStream out = new ObjectOutputStream( file );
        
out.writeObject( objet );
        
out.close();
file.close(); 
```

### Désérialisation

Au démarrage de l'application, la désérialisation est effectuée pour charger les réservations précédemment enregistrées. Cela garantit que l'information des réservations n'est pas perdue entre deux utilisations du programme.

```java
FileInputStream file = new FileInputStream( filename );
ObjectInputStream in = new ObjectInputStream( file );
			
Object object = null ;
object = ( Object )in.readObject();
			
in.close();
file.close();

return object ;
```

La sérialisation offre une solution efficace pour maintenir la cohérence des données et garantir que les informations essentielles de l'hôtel sont préservées entre les sessions d'utilisation de l'application.
