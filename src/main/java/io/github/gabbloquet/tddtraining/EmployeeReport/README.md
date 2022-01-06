# Employee Report

**Niveau :** Facile 

Ce Kata a été développé pour montrer comment la surspécification des assertions nuit à la maintenabilité des tests.   
Un article de blog avec une solution possible => [ici](https://dev.to/webpapaya/writing-better-test-assertions-lml).

## Problème

Vous construisez un système de gestion des employés d'une épicerie locale.   
Le propriétaire du magasin souhaite ouvrir le magasin le dimanche et, en raison de restrictions légales, les employés de moins de 18 ans ne sont pas autorisés à travailler le dimanche.  
L'employée demande une fonctionnalité d'établissement de rapports afin de pouvoir planifier les horaires de travail. 

_Tous les employés sont déjà stockés quelque part et ont les propriétés suivantes :_  
**Name** : chaîne de caractères (le nom de l'employé)  
**Âge** : nombre (l'âge en années de l'employé)


```javascript
const employees = [
  { name: 'Max', age: 17 },
  { name: 'Sepp', age: 18 },
  { name: 'Nina', age: 15 },
  { name: 'Mike', age: 51 },
];
```

## Les règles :

Commencez par la première User Story et écrivez au moins un test pour chaque exigence.  
Essayez de ne pas tenir compte des exigences futures dès le départ et suivez strictement le cycle TDD.

1. En tant que propriétaire d'un magasin, je souhaite afficher la liste de tous les employés âgés de plus de 18 ans, afin de savoir qui est autorisé à travailler le dimanche.
2. En tant que propriétaire de magasin, je veux que la liste des employés soit triée par leur nom, afin de pouvoir les retrouver plus facilement.
3. En tant que propriétaire du magasin, je souhaite que la liste des employés soit écrite en majuscules, afin que je puisse la lire plus facilement.
4. En tant que propriétaire du magasin, je souhaite que la liste des employés soit triée par nom en ordre décroissant plutôt qu'en ordre croissant.

Amusez-vous bien :) 