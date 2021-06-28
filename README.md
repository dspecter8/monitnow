# monitnow for Sapient
Les entités (package entities)
-	Clawn : représente la pelouse/surface à tondre
-	Repere : représentant les coordonnées
-	Params : Regroupe les paramètres Directions et Instructions de la tondeuse 
-	PositionMower : la position  et la direction de la tondeuse à un instant T
Controller (package Controller)
-	FormaterLine : permet de formater/lire les données en entrée et les instructions.
-	ProcessInstruction : Représente l’ensemble des instructions possibles qu’on peut donner à la tondeuse, se déplacer  vers la gauche/droit, Nord/Sud/Est/Ouest.
-	ProcessMower : Représente les instructions que la tondeuse peut avoir et leur ordre d’exécution.
Parser (package Parser)
-	Parserdata : Permet de lire les instructions en entrée (coordonnées & Direction, liste des instructions) ;
-	ParserMower : Permet de filtrer les opérations que la tondeuse peut effectuer.
Exception (package Exception)
-	ExceptionMower : étend la classe Exception, permet d’afficher le message lié à une exception/erreur.
Utils (package Utils)
-	Utils : regroupe les méthodes nécessaires pour lancer l’application.

Test JUNIT
-	App : test final de l’application avec les fichiers qui se trouvent dans le répertoire resourses.
-	TestController : regroupe les tests des classes du package controller.
-	TestEntities : regroupe les tests des classes du package entities.
-	TestReadDataByParser : regroupe les tests du package Parser
