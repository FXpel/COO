/--------------------------------------\
|                                        |
|             Projet donjon              |
|                                        |
|   KARTI Adeniss PELAGE François-Xavier |
|                                        |
\--------------------------------------/


## Le projet :

  Ce projet a été réalisé dans le cadre de l'unité de Conception Orientée Objet.
Le but était de réalisé un questionnaire où le joueur doit repondre à des questions pour pouvoir gagner des points,le nombre de points s'affiche à la fin du questionnaire.


## Remarques :
- Il faut remplir au minimum les cases qui se cochent sinon il retourne un NullpointerException.
- Les booleanAnswer prennent oui et non comme reponses.
- Pour lancer il faut ecrire soit terminal ou interface pour repondre dans un terminal ou dans une interface.

## HOW TO :

   Pour récupérer le dépôt, il faut éxecuter la commande :
git clone git@gitlab-etu.fil.univ-lille1.fr:karti/COO-TP04.git

   Pour générer la documentation situé dans le dossier "target/site/apidocs", la commande est :
mvn javadoc:javadoc

   Pour générer le projet qui se trouve dans le dossier target :
mvn package

   Pour exécuter l'archive précédement créer, la commande est la suivante :
java -jar target/projet-COO-TP4-1.0-SNAPSHOT.jar
