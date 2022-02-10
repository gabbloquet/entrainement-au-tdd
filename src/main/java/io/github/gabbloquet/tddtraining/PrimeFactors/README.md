# Prime Factors / Nombres premiers

**Niveau :** Facile

## Introduction 

Il s'agit d'un Kata très court. L'algorithme final est de trois lignes de code. Il est intéressant de noter qu'il y a 40 lignes de code de test.

Bien qu'assez court, ce kata est fascinant dans la façon dont il montre comment les instructions `if` deviennent des instructions `while` lorsque le nombre de cas de test augmente. C'est aussi un merveilleux exemple de la façon dont les algorithmes deviennent parfois plus simples lorsqu'ils deviennent plus généraux.

## Les nombres premiers 

[Définition Wikipédia](https://fr.wikipedia.org/wiki/Nombre_premier) : 

> Un nombre premier est un entier naturel qui admet exactement deux diviseurs distincts entiers et positifs. Ces deux diviseurs sont 1 et le nombre considéré, puisque tout nombre a pour diviseurs 1 et lui-même (comme le montre l’égalité n = 1 × n), *les nombres premiers étant ceux qui ne possèdent pas d'autre diviseur*. Par exemple, le nombre entier 7 est premier car 1 et 7 sont les seuls diviseurs entiers et positifs de 7. Tout nombre pair étant multiple de 2, les nombres premiers sont par conséquent tous impairs, excepté le nombre 2 lui-même. De plus, tout nombre se terminant par 5 étant un multiple de ce dernier, les nombres premiers (hormis 2 et 5) se terminent tous par 1, 3, 7 ou 9.

![prime_numbers](https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Primencomposite0100.svg/1200px-Primencomposite0100.svg.png)

## Enoncé

Ecrire une classe `PrimeFactors` qui a une seule méthode (statique) `factorsOf`. Cette méthode prend un argument de type entier et retourne un tableau d’entiers représentant les facteurs de ce nombre.

_Exemple :_

```
0 et 1 => []
2 => [2]
4 => [2, 2]
8 => [2, 2, 2]
9 => [3, 3]
```

## Petit à petit

N'oubliez pas, on avance pas à pas. On commence par le cas le plus absurde. Puis on implémente les règles de la plus basique à la plus précise.