# CQRS Booking

**Niveau** : Moyen

Vous devez mettre en œuvre une solution de réservation simple dans l'architecture CQRS.

## À propos de CQRS

**CQRS** pour Command Query Responsibility Segregation Pattern.

 > Une **requête** renvoie des données et ne modifie pas l'état de l'objet.   
 > Une **commande** change l'état d'un objet mais ne renvoie pas de données.

Nous allons donc diviser notre code **READ** (Lecture) et WRITE (Ecriture) pour faire vivre réellement ce modèle.

## Sujet de réservation

Nous voulons faire une solution de réservation pour un hôtel.

Les 2 User stories sont les suivantes :

 - En tant qu'utilisateur, je veux voir toutes les chambres libres.
 - En tant qu'utilisateur, je veux réserver une chambre.

Ils veulent utiliser le pattern CQRS, pour cela nous aurons :
 - un service de commande avec une fonction `bookARoom(Booking)` ils appellent le WriteRegistry ils notifient le ReadRegistry appelé par le service de requête avec la fonction `Room[] freeRooms(arrival : Date, departure : Date)`.

La structure Booking contient : 
```text
l'identifiant du client
le nom de la chambre
date d'arrivée
date de départ
```

Et la structure Room ne contient que : 
```text
le nom de la chambre
```