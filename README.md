# SAÉ 2.02 – Exploration algorithmique d'un problème

## Recherche de plus court chemin dans un graphe



## Membres du binôme

\- Eroglu Hasan (je suis seul)



# Structure du projet

## Dossier

\- 'SAE\_ALGO/src/' : contient le code source Java

\- 'SAE\_ALGO/test/' : contient les tests unitaires JUnit

\- 'stan.nodes.txt' : fichier des arrêts du réseau STAN

\- 'stan.edges.txt' : fichier des connexions du réseau STAN



## Classe Java

\-Arc.java : représente un arc orienté avec un poids positif vers un nœud cible.

\-Arcs.java : gère une liste d'arcs adjacents.

\-Graphe.java : interface définissant les opérations de base d'un graphe.

\-GrapheListe.java : implémentation du graphe sous forme de liste d'adjacence.

\-Valeurs.java : stocke les distances minimales calculées, les parents des sommets et permet de reconstruire le chemin optimal.

\-BellmanFord.java : implémentation de l'algorithme du point fixe (Bellman-Ford).

\-Dijkstra.java : implémentation de l'algorithme de Dijkstra.

\-LireReseau.java : lecture et analyse des fichiers du réseau STAN avec prise en charge des connexions bidirectionnelles.

\-Main.java : point d'entrée principal du programme.

\-MainTransport.java : comparaison des performances entre Bellman-Ford et Dijkstra.



## Génération du fichier JAR

Avec IntelliJ IDEA

Ouvrir File → Project Structure → Artifacts

Cliquer sur + → JAR → From modules with dependencies

Sélectionner la classe principale : Main

Valider puis cliquer sur :

Build en haut → Build Artifacts → Build 



Le fichier JAR exécutable sera alors généré.

## Lancer les tests unitaires

Dans IntelliJ : clic droit sur le dossier test → Run All Tests



## Lancer le programme

Depuis un terminal :

java -jar sae\_algo.jar <id\_depart> <id\_arrivee>





## Exemple

java -jar sae\_algo.jar NYSIV0 NYJUI0





## Objectif



Comparer les performances des algorithmes de Dijkstra et Bellman-Ford sur le réseau de transport STAN afin de déterminer le plus court chemin entre deux arrêts.



## Technologies utilisées

Java

IntelliJ IDEA

JUnit 5

Réseau de transport STAN

