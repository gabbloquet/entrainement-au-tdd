# String Calculator

**Niveau :** Moyen 

Ce kata classique vous guide pas à pas dans l'implémentation d'une calculatrice qui reçoit un String en entrée.  
C'est un bon exercice de refactoring et d'implémentation incrémentale.

## Initialisation

Créez une fonction `add` qui prend une chaîne et renvoie une chaîne :

> String add(String number)

 - La méthode peut prendre 0, 1 ou 2 nombres séparés par une virgule, et renvoie leur somme.
 - Une chaîne vide renverra "0".
 - Exemple d'entrées : "", "1", "1.1,2.2". 

## Plusieurs nombres

Faite en sorte que la fonction `add` puisse prendre plusieurs arguments.

## Nouvelle ligne comme séparateur

Permettre à la méthode d'ajout de gérer les nouvelles lignes comme séparateurs :

 - "1\n2,3" devrait renvoyer "6".
 - "175.2,\n35" n'est pas valide et doit renvoyer le message `"Number expected but '\n' found at position 6."`

## Nombre manquant à la dernière position

Ne pas permettre à l'entrée de se terminer par un séparateur.

 - "1,3," n'est pas valide et devrait renvoyer le message `"Number expected but \n or , found."`
 - "2,12\n" n'est pas valide et devrait renvoyer le message `"Number expected but \n or , found."`

## Séparateurs maison

Permet à la méthode `add` de gérer un délimiteur différent. Pour changer le délimiteur, le début de l'entrée contiendra une ligne séparée qui ressemblera à ceci :

> //[delimiter]\n[numbers]

 - "//;\n1;2" should return "3"
 - "//|\n1|2|3" should return "6"
 - "//sep\n2sep3" should return "5"
 - "//|\n1|2,3" is invalid and should return the message `'|' expected but ',' found at position 3.`

Évidemment cette mise à jour ne doit pas casser ce qui a été fait auparavant.

## Nombres négatifs

L'appel de `add` avec des nombres négatifs renverra le message `Negative not allowed : ` en listant tous les nombres négatifs qui étaient dans la liste de nombres.

 - "-1,2" n'est pas valide et doit renvoyer le message "Négatif non autorisé : -1".
 - "2,-4,-5" n'est pas valide et doit renvoyer le message "Négatif non autorisé : -4, -5".

## Erreurs multiples

L'appel d'`add` avec plusieurs erreurs renverra tous les messages d'erreur séparés par des nouvelles lignes.

 - "-1,,2" n'est pas valide et renvoie le message `"Negative not allowed : -1\nNumber expected but ',' found at position 3."`
 - "1,-2,-3,,4" n'est pas valide et renvoie le message `"Negative not allowed : -2, -3\nNumber expected but ',' found at position 8."`
 - "1,-2,-3,\n4" n'est pas valide et renvoie le message `"Negative not allowed : -2, -3\nNumber expected but '\n' found at position 8."`
 - "1,-2,-3,\n4,,5" n'est pas valide et renvoie le message `"Negative not allowed : -2, -3\nNumber expected but '\n' found at position 8.\nNumber expected but ',' found at position 11."`

# BONUS

## Gestion des erreurs

Introduisez une fonction d'addition interne qui renvoie un nombre au lieu d'une chaîne de caractères, et testez plusieurs solutions pour les messages d'erreur.

 - Exception
 - approche peut-être et monade
 - Code de retour POSIX avec gestion des messages
 - tuple avec structure d'erreur comme dans Go
 - etc.

## Multiply

Implémentez une fonction `multiply` pour la multiplication suivant ces règles.