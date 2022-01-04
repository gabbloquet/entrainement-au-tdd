# Entrainement au Test Driven Development

Oui c'est en Français ! (Et c'est voulu :D)  
Ce repository a pour but de s'exercer au test driven development à travers des exemples, qui, je l'espère seront de plus en plus nombreux.   

## Comment ?

Pour vous entrainer, rien de plus simple !  
1. Cliquez sur le lien ci-dessous de l'exercice que vous souhaiter faire.
2. Si vous avez cloné ce repo supprimez la classe et celle de test associée
3. Suivez les instructions ;) (En commençant par développer un test bien entendu :D)
4. Have Fun !

## Exercices proposés

1. [FizzBuzz](./src/main/java/io/github/gabbloquet/tddtraining/FizzBuzz/README.md)
2. [BowlingGame](./src/main/java/io/github/gabbloquet/tddtraining/BowlingGame/README.md)

## Qu'est ce que le Test driven Development ?

Les artisans développeurs (software crafters, cf. Software Craftsmanship) recommandent vivement la pratique du TDD (Test Driven Development).

Elle est certainement la méthode de design de code la plus efficace connue actuellement !  
Cependant, malgré son incroyable efficience, elle est souvent très mal comprise.

![Red green refactor](https://www.thinktocode.com/wp-content/uploads/2018/02/red-green-refactor.png)

1️⃣ On commence par RED. Dans cette phase, on va écrire un test qui ne passe pas (s’il ne compile pas, il ne passe pas). À ce moment, on ne se concentre que sur la logique des APIs (exposition des methods, organisation des classes) que l'on veut appeler : est-ce que si j'appelle cet Objet de cette manière cela traduit bien l'intention métier du traitement que je veux faire ?

2️⃣ Vient ensuite la phase GREEN, ici on va écrire le code le plus direct pour faire passer notre test (sans casser un test précédent).

3️⃣ On termine le cycle avec REFACTOR où on va retravailler notre code pour :

 - Avoir du code plus élégant ;
 - Mieux expliciter les traitements qui sont faits ;
 - Apporter une meilleure réponse au métier.

➡️ On répète ce cycle toutes les quelques secondes voire minutes. Il n'est absolument pas question ici de cycle sur plusieurs jours. On fait plusieurs centaines de cycles de TDD dans une journée !

### Comment ?
Il peut être décrit succinctement par l'ensemble des règles suivantes :

1. Ecrire un "seul" test unitaire décrivant un aspect du programme
2. Exécuter le test, qui doit échouer parce que le programme n'a pas cette fonctionnalité
3. écrire "juste assez" de code, le plus simple possible, pour faire passer le test
"remanier" le code jusqu'à ce qu'il soit conforme aux critères de simplicité
4. répéter, en "accumulant" les tests unitaires au fil du temps.

### Avantages
 - Meilleure conception du programme et meilleure qualité du code (petites fonctions, principes DRY)
 - réductions significatives des taux de défauts
 - Augmente la compréhension du code (documentation détaillée du projet)
 - permet de mettre en évidence la marge dans tous les cas
 - réduit le temps nécessaire au développement du projet (feedback rapide, moins de bugs ou d'erreurs)

### Tips

#### Se focaliser sur les cas simples

D'abord se focaliser sur les cas simples.
Par exemple dans le cas de [FizzBuzz](./src/main/java/io/github/gabbloquet/tddtraining/FizzBuzz/README.md), nous commençons par les chiffres non compris dans les règles à implémenter => 1 & 2.

#### Ecrire le code MINIMAL

On ne fait pas ce que les tests ne nous ont pas demandé de faire ! L'objectif est de faire passer le test au plus vite, on va droit au but pour faire passer le test que nous venons d'écrire.
Ensuite, nous pouvons refactor.

#### La triangulation

Après avoir implémenté une règle métier / un test (avec Red-Green-Refactor), assurez-vous de trouver toutes les "bizarreries" ou non-généralités dans le code de production et éliminez-les une par une en écrivant un test qui prouve cette non-généralité.
Assurez-vous de tester les cas à la marge !

### Quelques ressources

 - [Wikipedia](https://fr.wikipedia.org/wiki/Test_driven_development)
 - [OpenClassroom](https://openclassrooms.com/fr/courses/3504461-testez-linterface-de-votre-site/4270571-apprenez-le-test-driven-development-tdd)
 - [Apprendre le TDD par IPPON](https://blog.ippon.fr/2020/02/12/apprendre-le-tdd/)
 - [Vidéo : Comment faire du TDD](https://www.youtube.com/watch?v=wbZ6jWmRY14)
 - [Video : TDD par l'exemple](https://www.youtube.com/watch?v=nbSaq_ykOl4)
