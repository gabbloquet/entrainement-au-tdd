# Bowling Game hardcore

**Niveau :** Difficile

Le jeu se compose de 10 tours. Dans chaque tour, le joueur a deux lancers pour faire tomber 10 quilles. Le score du cadre est le nombre total de quilles abattues, plus les bonus pour les strikes et les spares.
 - On parle de réserve lorsque le joueur fait tomber les 10 quilles en deux lancers. Le bonus pour ce cadre est le nombre de quilles abattues au prochain lancer. 
 - On parle de strike lorsque le joueur fait tomber les 10 quilles lors de son premier lancer. Le cadre est alors complété par un seul lancer. Le bonus pour ce cadre est la valeur des deux lancers suivants. 
 - Dans le dixième carreau, un joueur qui a obtenu un spare ou un strike est autorisé à lancer les boules supplémentaires pour terminer le carreau. Toutefois, il ne peut pas lancer plus de trois boules dans le dixième tour.

[Plus de détails ici](https://www.lelooping.com/montivilliers/les-regles-du-bowling/).

La complexité de ce Kata réside dans le fait que le score doit-être calculé en live !  
Comme lorsque l'on va au bowling, lorsqu'on lance une boule on a un retour visuel direct.  
La version plus facile [ici](../BowlingGame/README.md).

## Exigences

Écrivez une classe Game qui possède deux méthodes :
1. **void roll(int)** est appelé chaque fois que le joueur lance une boule. L'argument est le nombre de quilles abattues.
2. **int score()** renvoie le score total pour cette partie.

## Exemple

Le premier test pourrait ressembler à quelque chose comme :

```java
  @Test
  void should_return_1_as_score_if_the_player_scores_1() {
    int userScore = 1;

    game.roll(userScore);

    assertEquals(1, game.score());
  }
```


## Aide

### Step 1 - Règles classiques

Entrée : vide  
Score attendu : 0

Entrée : 1  
Score attendu : 1

Entrée : 2  
Score attendu : 2

Entrée : 3, 2  
Score attendu : 5

Entrée : 1, 6, 3, 5, 1, 2, 9, 0, 3, 2, 7, 2, 5, 4, 4, 3, 6, 2, 7, 2  
Score attendu : 74

### Step 2 - Le Spare

Entrée : 1, 9  
Score attendu : 10

Entrée : 1, 9, 4  
Score attendu : 18

Entrée : 1, 9, 7, 3, 7, 2   
Score attendu : 43

### Step 3 - Le Strike

Entrée : 10, 0, 0, 1, 0   
Score attendu : 11

Entrée : 10, 2, 0, 5, 0   
Score attendu : 19

Entrée : 10, 1, 4, 0, 0   
Score attendu : 20

Entrée : 10, 10, 4, 0   
Score attendu : 42

Entrée : 10, 10, 10, 0   
Score attendu : 60

### Step 4 - La fin de partie

Entrée : 10, 10, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0  
Score attendu : 52

Entrée : 10, 10, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 5  
Score attendu : 57

Entrée : 10, 10, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 7, 2  
Score attendu : 61

Entrée : 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10  
Score attendu : 300