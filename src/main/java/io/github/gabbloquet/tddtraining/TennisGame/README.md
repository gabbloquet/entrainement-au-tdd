# Tennis Game

**Niveau :** Moyen 

Ce kata classique vous guide pas à pas dans l'implémentation d'un compteur de point de tennis.

## Règles

### Gagner une partie

 - Pour gagner une partie, un joueur doit avoir 2 points de plus que son adversaire.
 - Le premier joueur qui obtient 4 points dans une partie gagne la partie.
 - Si les deux joueurs ont 3 points dans une partie, c'est le premier qui atteint 5 points, si les deux ont 4 points c'est le premier qui atteint 6, et ainsi de suite.

**Point dans une partie** 

 - Aucun point : "0" 
 - 1er point : "15" 
 - 2ème point : "30" 
 - 3ème point : "40" 
 - 4ème point : "jeu"

Si les deux joueurs ont 40, le point suivant est noté : "avantage".  
Si le même joueur gagne un autre point, il gagne la "partie".  
Dans le cas contraire, les deux joueurs repartent sur un "égalité".

### Gagner un set

Pour gagner un set, un joueur doit avoir 2 jeux de plus que son adversaire.
Le premier joueur à gagner 6 jeux dans un set gagne le set.
Si les deux joueurs ont 5 jeux dans un set, c'est le premier à 7 jeux mais si les joueurs ont 6 jeux, c'est un jeu spécial : le tie break. Le gagnant du tie-break, remporte le set : 7 jeux à 6 !

### Gagner un match

Pour gagner un match dans un tournoi du Slam, c'est le premier joueur qui gagne 3 sets.

### Jeu décisif

Pour gagner un tie-break, un joueur doit avoir 2 points de plus que son adversaire.
Le premier joueur à gagner 7 points dans le tie-break gagne le match (et le set).
Si les deux joueurs ont 6 points dans un match, c'est le premier à 8 points, si les deux ont 47points c'est le premier à 9, et ainsi de suite.

### 5ème set

Il n'y a pas de tie break ! Les joueurs doivent avoir 2 jeux d'écart !

## Étapes

Entrée : la liste des noms, correspondant au gagnant de chaque point (Liste <String>)
Sortie : le score String[][]

### Exemple pour les joueurs A et B

**entrée** : `A,A,A,B,A,B,B,A`

**sortie** :
```text
A 1 0 0 0 0 15
B 0 0 0 0 0 30
```


### Étape 1 - Afficher le score d'un jeu

**entrée** : vide  
**sortie** : A 0 0 0 0 0 0 B 0 0 0 0 0 0

**entrée** : A  
**sortie** : A 0 0 0 0 0 15 B 0 0 0 0 0 0

**entrée** : A,B,A,B,A  
**sortie** : A 0 0 0 0 0 40 B 0 0 0 0 0 30

**entrée** : A,B,A,B,A,A  
**sortie** : A 1 0 0 0 0 0 B 0 0 0 0 0 0

Entrée : A,B,A,B,A,B,A  
**sortie** : A 0 0 0 0 0 avantage B 0 0 0 0 0 0

**entrée** : A,B,A,B,A,B,A,B  
**sortie** : A 0 0 0 0 0 deuce B 0 0 0 0 0 deuce

### Étape 2 - Afficher le score d'un set

**entrée** : A,A,A,A  
**sortie** : A 1 0 0 0 0 0 B 0 0 0 0 0 0"

**entrée** : A,A,A,B,A,A,A,A,B,A,B,B,A,B,B  
**sortie** : A 2 0 0 0 0 0 B 1 0 0 0 0 0

### Étape 3 - Affichage du score pour plusieurs sets

**entrée** : A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A  
**sortie** : A 6 1 0 0 0 0 B 0 0 0 0 0 0"

**entrée** : A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B  
**sortie** : A 6 1 0 0 0 0 B 2 6 0 0 0 0

**entrée** : A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A  
**sortie** : A 7 0 0 0 0 0 B 5 0 0 0 0 0

### Etape 4- Affichage du score avec tie break

**entrée** : A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,B,B,B,B,A,A,A,A,A,A,A  
**sortie** : A 7 0 0 0 0 0 B 6 0 0 0 0 0

**entrée** : A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,B,B,B,B,A,A,A,A,A,A,B,B,B,B,B,B,B,B    
**sortie** : A 6 0 0 0 0 0 B 7 0 0 0 0 0

### Etape 5 - Affichage du score pour 5 sets

**entrée** : A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A  
**sortie** : A 6 1 6 6 0 0 B 2 6 0 0 0 0

**entrée** : A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,A,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,B,A,A,A,A,B,B,B,B,A,A,A,A,A,A,A,A  
**sortie** : A 6 1 6 1 8 0 B 2 6 2 6 6 0