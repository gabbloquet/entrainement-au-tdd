# Bowling Rules

Le jeu se compose de 10 tours. Dans chaque tour, le joueur a deux lancers pour faire tomber 10 quilles. Le score du cadre est le nombre total de quilles abattues, plus les bonus pour les strikes et les spares.
 - On parle de réserve lorsque le joueur fait tomber les 10 quilles en deux lancers. Le bonus pour ce cadre est le nombre de quilles abattues au prochain lancer. 
 - On parle de strike lorsque le joueur fait tomber les 10 quilles lors de son premier lancer. Le cadre est alors complété par un seul lancer. Le bonus pour ce cadre est la valeur des deux lancers suivants. 
 - Dans le dixième carreau, un joueur qui a obtenu un spare ou un strike est autorisé à lancer les boules supplémentaires pour terminer le carreau. Toutefois, il ne peut pas lancer plus de trois boules dans le dixième tour.

[Plus de détails ici](https://www.lelooping.com/montivilliers/les-regles-du-bowling/).

## Exigences

Écrivez une classe Game qui possède deux méthodes :
1. **void roll(int)** est appelé chaque fois que le joueur lance une boule. L'argument est le nombre de quilles abattues.
2. **int score()** renvoie le score total pour cette partie.

## Aide

### Step 1 - Règles classiques

input : 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
output : 1

input : 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
output : 2

input : 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
output : 5

input : 1, 6, 3, 5, 1, 2, 9, 0, 3, 2, 7, 2, 5, 4, 4, 3, 6, 2, 7, 2
output : 74

input : empty
output : 0

### Step 2 - Le Spare

input : 1, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
output : 10

input : 1, 9, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
output : 18

input : 1, 9, 7, 3, 7, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
output : 43

### Step 3 - Le Strike

input : 10, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
output : 11

input : 10, 2, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
output : 19

input : 10, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
output : 20

input : 10, 10, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
output : 42

input : 10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
output : 60

### Step 4 - La fin de partie

input : 10, 10, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0
output : 52

input : 10, 10, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 5
output : 57

input : 10, 10, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 7, 2
output : 61

input : 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10
output : 300