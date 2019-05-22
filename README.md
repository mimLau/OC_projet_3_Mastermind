Projet 3 Openclassrooms: Mastermind / Jeu du plus ou moins
  
  
 Version java utilisée:
 Java 11.0.2
 
  
 Contexte:
 
 Mastermind:
 
 Essayer de deviner la combinaison secrète en un nombre limité d'essais.
 A chaque essai, sera affiché un message nous informant, si la proposition est correcte ou non, 
 s'il y a des chiffres qui sont à la bonne place ou s'il y a des chiffre qui sont présents mais à la mauvaise place.
  
  
 Jeu du plus ou moins:
  
 Même principe de base que pour celui du Mastermind, il faut essayer de deviner la combinaison secrète 
 en un nombre limité d'essais. Cette fois-ci, sera affiché pour chaque chiffre un "+" si le le chiffre proposé est 
 trop petit, un "-" si le chiffre proposé est trop grand et un "=" si c'est le bon chiffre.
 
 
 Modes:
	
 Dans le menu principal, il y a la possibilité pour chaque jeu, de choisir entre 3 modes:
 

 
 
 Configuration des jeux:

 Avant de lancer l'application, il va falloir procéder à quelques configurations.
 
 1- Ajouter le chemin absolu du fichier config.properties (qui se trouve dans src/resources), 
    dans la classe Parameters, à la ligne 124. 
    input = new FileInputStream("...................src/resources/config.properties");
 
 2- Mode développeur:
 
	Le mode développeur permet d'afficher la combinaison secrète, pour pouvoir suivre le jeu et voir son évolution. 
	Il est possible de passer en mode développeur en rajoutant true ou false en argument dans run puis 
	dans edit configurations.
	Il est également possible de configurer le mode dev directement dans le fichier config.properties 
	qui se trouve dans le repertoire src/resources.
  
 3- Paramétrage du jeu
 
	Configuration du nombre maximal d'essais possible:	variable trialNbMax
	Configuration de la taille de la combinaison secrète:  variable secretNbSize
	Configuration du le nombre chiffres utilisables (de 4 à 9) pour le mastermind:  variable maxUsableDigit
  
 
 Utilisation des logs:

 Le fichier log4j2.xml se trouve dans le repertoire src et les fichiers logs s'afficheront dans le repertoire logs.
 Pour pouvoir récuperer les logs journaliers, il faudra rajouter les librairies adéquates.
 voir partie librairies utilisées.
 
 
 Librairies utilisées:
	
 Rajouter dans le projet, les librairies Log4j-api-2.11.2 et log4j-core-2.11.2 qui se trouvent dans le dossier lib.
  
  
 Lancement de l'application:
	
 Une fois toutes les configurations effectuées, pour lancer l'application, il faut exécuter la classe Main 
 qui se trouve dans le repertoire src/com/ask/maryam.