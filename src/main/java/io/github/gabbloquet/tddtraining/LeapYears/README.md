# LeapYears / Années bissextiles

**Niveau** : Facile 

## Un peu d'histoire

Avant 1582, le calendrier julien était largement utilisé et définissait les années bissextiles comme toute année divisible par 4. Cependant, on a constaté à la fin du XVIe siècle que l'année civile s'était écartée de l'année solaire d'environ 10 jours. Le calendrier grégorien a été défini afin de réduire le nombre d'années bissextiles et d'aligner plus étroitement l'année civile sur l'année solaire. Il a été adopté dans les pays pontificaux le 15 octobre 1582, en sautant 10 jours de la date du calendrier julien. Les pays protestants ont adopté le calendrier grégorien après un certain temps.

Le calendrier grégorien est assez précis, mais il pourrait être rendu plus précis en ajoutant une règle supplémentaire qui élimine les années divisibles par 4000 comme années bissextiles. Mais je suppose que nous traverserons ce pont quand nous y arriverons. Considérez l'ajout de cette règle comme une deuxième histoire comme une extension de l'exercice.

## User Story :

En tant qu'utilisateur, je veux savoir si une année est une année bissextile, afin de pouvoir planifier un jour supplémentaire le 29 février pendant ces années.

## Critères d'acceptation :

 - Toutes les années divisibles par 400 SONT des années bissextiles (donc, par exemple, 2000 était bien une année bissextile),
 - Toutes les années divisibles par 100 mais pas par 400 ne sont PAS des années bissextiles (ainsi, par exemple, 1700, 1800 et 1900 n'étaient PAS des années bissextiles, et 2100 ne le sera pas non plus),
 - Toutes les années divisibles par 4 mais pas par 100 SONT des années bissextiles (par exemple, 2008, 2012, 2016),
 - Toutes les années non divisibles par 4 ne sont PAS des années bissextiles (par exemple, 2017, 2018, 2019).