 /--------------------------------------\
|                                        |
|             Projet donjon              |
|                                        |
|   KARTI Adeniss PELAGE François-Xavier |
|                                        |
 \--------------------------------------/


 ## Le projet :

   Ce projet a été réalisé dans le cadre de l'unité de Conception Orientée Objet.
Le but était de réalisé un jeu de donjon où le joueur visite des salles afin de trouver la sortie.



 ## HOW TO :

    Pour récupérer le dépôt, il faut éxecuter la commande :
git clone git@gitlab-etu.fil.univ-lille1.fr:karti/COO-TP02.git

    Pour générer la documentation situé dans le dossier "target/site/apidocs", la commande est :
    #problème avec la génération des tests qui ne veut pas s'effectuer
mvn javadoc:javadoc

    Pour générer le projet qui se trouve dans le dossier target :
mvn package

    Pour exécuter l'archive précédement créer, la commande est la suivante :
java -jar target/projet-donjon-1.0-SNAPSHOT.jar
