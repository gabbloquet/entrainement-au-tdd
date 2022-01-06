# Dictionary Replacer

**Niveau :** Facile 

## Introduction

Ce kata consiste à fabriquer un simple remplacement de chaine de caractère.   
Il est inspiré du discours de Corey Haines Lightning sur la pratique.  

## Comment ?

Créez une méthode qui : 
 - prend une chaîne de caractères et un dictionnaire
 - remplace chaque clé du dictionnaire pré et suffixée par un signe dollar, par la valeur correspondante du dictionnaire.

## Les 3 tests :

**Entrée :** “”  
**Dictionnaire :** empty  
**Sortie :** “”

**Entrée :** “$temp$”  
**Dictionnaire :** `[“temp”, “temporary”]`  
**Sortie :** “temporary”  

**Entrée :** “$temp$ here comes the name $name$”  
**Dictionnaire :** `[“temp”, “temporary”] [“name”, “John Doe”]`  
**Sortie :** “temporary here comes the name John Doe”

Amusez vous bien :D