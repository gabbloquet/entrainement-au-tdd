# ChristmasLight

**Niveau :** Facile

## Probablement un risque d'incendie

Parce que vos voisins ne cessent de vous battre au concours de décoration des maisons de Noël, vous avez décidé de déployer un million de lumières dans une grille de 1000x1000.   
De plus, comme vous avez été particulièrement gentil cette année, le Père Noël vous a envoyé par courrier des instructions sur la façon d'afficher la configuration d'éclairage idéale !  
Les lumières de votre grille sont numérotées de 0 à 999 dans chaque direction ; les lumières de chaque coin sont à 0,0, 0,999, 999,999 et 999,0.  
Les instructions indiquent s'il faut allumer, éteindre ou basculer diverses plages incluses données sous forme de paires de coordonnées.  
Chaque paire de coordonnées représente les coins opposés d'un rectangle, inclusivement ; une paire de coordonnées comme 0,0 à 2,2 fait donc référence à 9 lumières dans un carré 3x3.  
Les lumières commencent toutes par être éteintes. Pour vaincre vos voisins cette année, il vous suffit d'installer vos lumières en suivant dans l'ordre les instructions que le Père Noël vous a envoyées.

### Exemples

 - `Allumer` 0,0 à 999,999 allume (ou laisse allumée) toutes les lumières.
 - `Basculer` 0,0 à 999,0 (basculer de 0,0 à 999,0) bascule la première ligne de 1000 lampes, éteignant celles qui sont allumées et allumant celles qui sont éteintes.
 - `Eteindre` 499,499 à 500,500 éteindrait (ou laisserait éteint) les quatre lumières du milieu.

### Instructions

allumer 887,9 à 959,629
allumer 454,398 à 844,448
éteindre 539 243 à 559 965
éteindre 370,819 à 676,868
éteindre 145,40 à 370,997
éteindre 301,3 à 808,453
allumer 351,678 à 951,908
basculer de 720,196 à 897,994
basculer de 831,394 à 904,860

 > Après avoir suivi les instructions, combien de lampes sont allumées ?

## Deuxième partie

Vous venez de terminer la mise en place de votre schéma lumineux gagnant lorsque vous vous rendez compte que vous avez mal traduit le message du Père Noël de l'ancien elfique nordique.  
La grille d'éclairage que vous avez achetée possède en fait des commandes de luminosité individuelles ; chaque lumière peut avoir une luminosité de zéro ou plus. Les lumières commencent toutes à zéro.

 - L'expression "allumer" signifie en fait que tu dois augmenter la luminosité de ces lumières de 1.
 - L'expression "éteindre" signifie en fait que vous devez diminuer la luminosité de ces lumières de 1, jusqu'à un minimum de zéro.
 - L'expression "basculer" signifie en fait que vous devez augmenter la luminosité de ces lumières de 2.

> Quelle est la luminosité totale de toutes les lumières combinées après avoir suivi les instructions du Père Noël ?

### Par exemple

 - allumer 0,0 à 0,0 augmenterait la luminosité totale de 1.
 - basculer de 0,0 à 999,999 augmenterait la luminosité totale de 2000000.

## Aide

Ne vous focalisez pas sur les instructions, mais plutôt sur les règles.  
Lorsque j'allume le rendu est celui-ci, lorsque j'éteins celui-là...

### Solution

Si vous souhaitez voir mes résultats, il vous suffit d'executer [la classe Solution](./Solution.java).


Have fun :D 