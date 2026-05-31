import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe permettant de lire un réseau de transport
 * depuis deux fichiers textes
 */
public class LireReseau {

    /**
     * Construit et retourne un graphe à partir des fichiers
     * du réseau de transport.
     * @param fichier_stations le fichier des arrêts (stan.nodes.txt)
     * @param fichier_connexions le fichier des connexions (stan.edges.txt)
     * @return le graphe construit
     */
    public static Graphe lire(String fichier_stations, String fichier_connexions) {
        GrapheListe g = new GrapheListe();


        try (BufferedReader br = new BufferedReader(new FileReader(fichier_stations))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {

                String[] parts = ligne.split(";");
                if (parts.length >= 2) {
                    String id = parts[0];
                    if (!g.getNoeuds().contains(id)) {
                        g.getNoeuds().add(id);
                        g.getAdjacenceListe().add(new Arcs());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lecture stations : " + e.getMessage());
        }


        try (BufferedReader br = new BufferedReader(new FileReader(fichier_connexions))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                // Format : id_arret_depart;id_arret_arrivee;distance
                String[] parts = ligne.split(";");
                if (parts.length == 3) {
                    String depart = parts[0];
                    String arrivee = parts[1];
                    double distance = Double.parseDouble(parts[2]);


                    g.ajouterArc(depart, arrivee, distance);
                    g.ajouterArc(arrivee, depart, distance);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lecture connexions : " + e.getMessage());
        }

        return g;
    }
}