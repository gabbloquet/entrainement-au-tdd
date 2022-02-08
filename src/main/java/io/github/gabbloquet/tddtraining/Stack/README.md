# Stack / Pile

**Niveau :** Découverte

Cet exercice est intéressant pour découvrir le principe de test driven development.  
Il consiste à développer une pile (liste « dernier arrivé, premier sorti »), et on se rend compte notamment du fait que l'on peut écrire de nombreux tests avant de réellement implémenter une pile.

## Exercice

L'objectif est de créer une pile, une liste dont le paradigme est « dernier arrivé, premier sorti ».  
En d'autres termes, _le dernier élément ajouté à la pile sera le premier à en sortir_.

Nous pouvons donc imaginer ces deux actions : 
 - ajouter un élément à la liste (push)
 - supprimer un élément de la liste (pop)

Bien entendu, nous pouvons y ajouter d'autres méthodes pour, par exemple, controller si celle-ci est vide ? De quelle taille ?

## Notes

Il n'est pas possible de retirer (pop) un élément à une pile vide.