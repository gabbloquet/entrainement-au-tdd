# WordWrap

**Niveau :** Moyen

## Description

Vous écrivez une classe appelée `Wrapper`, qui possède une seule fonction statique nommée `wrap` qui prend deux arguments : 
 - une chaîne de caractères 
 - un numéro de colonne. 

La fonction renvoie la chaîne de caractères, mais avec des sauts de ligne insérés aux bons endroits pour s'assurer qu'aucune ligne n'est plus longue que le numéro de colonne.  
Vous essayez de casser les lignes aux limites des mots.

Comme dans un traitement de texte, vous coupez la ligne en remplaçant le dernier espace d'une ligne par une nouvelle ligne.

## Règles
 - Faites tenir autant de mots que possible sur une seule ligne.
 - Essayez toujours de rompre sur les espaces.
 - Si un mot est plus long qu'une ligne, séparez-le en l'ajoutant autant que possible à la ligne précédente, puis séparez-le à nouveau s'il ne tient toujours pas sur la ligne actuelle, etc.
 - Les lignes ne doivent pas contenir d'espaces en tête ou en queue de ligne.

## Exemple

```
 ("test", 7)            -> "test"
 ("hello world", 7)     -> "hello\\world"
 ("a lot of words for a single line", 10) -> "a lot of\\words for\\a single\\line"

 ("this is a test", 4)  -> "this\\is a\\test"
 ("a longword", 6)      -> "a long\\word"
 ("areallylongword", 6) -> "areall\\ylongw\\ord"
 
 ("greedy whenthewordistoolong", 6) -> "greedy\\whenth\\ewordi\\stoolo\\ng"
 ("greedy whenthewordistoolong", 7) -> "greedy\\whenthe\\wordist\\oolong"   (=> no trailing space)
```
 

## Notes 

Ce kata est intéressant pour montrer le smell du `getting stuck`. Le fait de se retrouver coincer à un moment donné à devoir écrire tout l'algo d'un coup.  
La solution ? Supprimer le / les derniers tests écris et en écrire d'autres permettant de faire de plus petits pas. ;)