# WordWrap

**Niveau :** Facile

## Description

Vous écrivez une classe appelée `Wrapper`, qui possède une seule fonction statique nommée `wrap` qui prend deux arguments : 
 - une chaîne de caractères 
 - un numéro de colonne. 

La fonction renvoie la chaîne de caractères, mais avec des sauts de ligne insérés aux bons endroits pour s'assurer qu'aucune ligne n'est plus longue que le numéro de colonne.  
Vous essayez de casser les lignes aux limites des mots.

Comme dans un traitement de texte, vous coupez la ligne en remplaçant le dernier espace d'une ligne par une nouvelle ligne.

## Exemple

Voici un exemple | 8 => Voici un\nexemple
Voici un second exemple | 5 => Voici\nun\nsecond\nexemple 

## Notes 

Ce kata est intéressant pour montrer le smell du `getting stuck`. Le fait de se retrouver coincer à un moment donné à devoir écrire tout l'algo d'un coup.  
La solution ? Supprimer le / les derniers tests écris et en écrire d'autres permettant de faire de plus petits pas. ;)