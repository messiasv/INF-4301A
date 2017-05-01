Rapport de projet Compilation
MESSIAS Valentin
SAUVION Lorkan

Notre compilateur supporte actuellement les fonctionnalités suivantes (note : exp est à remplacer par n'importe quelle expression) :
	- Support des entiers et des décimaux (en séparant avec un point ".")
Ex : 	1
			1.0
	- Les opérations arithmétiques binaires (addition, soustraction, multiplication, division) (+, -, *, /)
Ex : 	1+1
			1.0 / 0.3
	- Les comparaisons (<, <=, >, >=, <>, =)
Ex : 	1<3
			5<>6
	- L'affichage d'un PrettyPrint de façon systématique (Exemple plus bas)
	- L'évaluation d'une expression et son affichage par la commande "print(exp)" (les parenthèses sont importantes)
Ex : 	print(1)
			print(if 2>3 then 1 else 0)	
	- Support du If-Then-Else
Ex : 	if 1<>6 then 56 else 67/41.6
			if 5=5 then 5*5 else 5-5
	- Support des instructions multiples, via une virgule ","
Ex : print(6), print(6+1)
Note : On ne peut pas mettre d'instructions multiple dans un If-Then-Else, car c'est une expression qui doit retourner une valeur.
	- Support du Let-In-End et des déclarations de variables
Ex : 	let var x:=5 in print(x) end
			let var x:= 1 var y:=3 in print(if x>y then 1 else 0) end
	- Support des affectations
Ex : 	let var x:=5 in x:=x-1 end
			let var x:=5 var y:=x in y:=y+y end
	- Support des portées des variables : les scopes peuvent être imbriqués
Ex : 	let var x:=5 in let var x:=x+x in print(x) end, print(x) end
	- La lecture d'un fichier texte en tant que source
	- L'arrêt du programme par la commande "quit" (à utiliser en dehors de tout scope)
	
Pour compiler le programme, il suffit d'utiliser la commande "make".
Pour supprimer les fichiers compilés et ne conserver que le code source, utlisez la commande "make clean"
Pour lancer le programme en utilisant un fichier texte comme source, utilisez la commande "java Tigger NomDuFichier"
Pour lancer le programme en utilsant System.in comme source, utilisez la commande "java Tigger"
Nous fournissons un fichier de test. Pour l'utilisez, lancez la programme avec la commande "java Tigger test"
Celui-ci executera plusieurs lignes de test, toutes fonctionnelles, puis une ligne de test fermant le programme car détection d'une erreur.

Les erreurs détéctées pouvant fermer le programme sont :
	- Déclaration d'une variable dans un scope possédant déjà une variable de même nom (attention, la déclaration d'une variable dans un scope imbriqué dans un scope possédant une variable de même nom fonctionne)
Ex :  let var x:= exp var x:= exp in end 	est une erreur
			ler var x:= exp in let var x:=x in end end 	est correcte
	- Utilisation d'une variable non déclarée (dans le même scope ou dans un scope imbriqué)
Ex :  let in x+1 end		est une erreur
			let in let in x+1 end end 	est une erreur
	- Utilisation d'instructions multiples dans un IfThenElse
Ex : let in if 1 then 4, 6 else 7, 2 end	est une erreur.
	
L'affichage des "print()" se fait avant l'affichage du PrettyPrinter

Au niveau des problèmes non résolus, lorsque l'on fait l'affectation d'une variable déclarée dans la même portée, le PrettyPrinter affiche la déclaration avec la valeur de l'affectation.
Par exemple, let var x:=5 in print(x), x:=x-1, print(x) end affichera :

5
4
Pretty Print:
let
 var x:=(x-1) //A cet endroit, il y a un problème, on devrait avoir normalement var x:=5
in
 print(x)
 x:=(x-1)
 print(x)
end

Cette erreur est dû au fait que le Pretty Printer ne se lance qu'à la toute fin du parsing.
En effet, nous conservons dans une HashMap les expressions parsées et nous les affichons à la fin de la ligne.
Or, l'execution se fait en amont du print, c'est pourquoi l'affectation de x en (x-1) est déjà faite lorsque le PrettyPrinter se lance.
L'Evaluateur, lui, ne se lance qu'avec un print, donc pendant l'execution.
Nous n'avons malheuresement pas réussi à corriger ce problème.

