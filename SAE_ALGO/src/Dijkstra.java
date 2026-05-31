import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de l'algorithme de Dijkstra
 * pour la recherche du plus court chemin dans un graphe.
 */
public class Dijkstra {

    /**
     * @param g le graphe orienté pondéré
     * @param depart le nœud de départ
     * @return un objet Valeurs contenant les distances et parents de chaque nœud
     */
    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs valeurs = new Valeurs();


        List<String> Q = new ArrayList<>();

        for (String noeud : g.getNoeuds()) {
            valeurs.setValeur(noeud, Double.MAX_VALUE);
            valeurs.setParent(noeud, null);
            Q.add(noeud);
        }
        valeurs.setValeur(depart, 0);
        valeurs.setParent(depart, "fin");

        while (!Q.isEmpty()) {

            String u = null;
            double valeurMin = Double.MAX_VALUE;
            for (String noeud : Q) {
                if (valeurs.getValeur(noeud) < valeurMin) {
                    valeurMin = valeurs.getValeur(noeud);
                    u = noeud;
                }
            }


            if (u == null) break;


            Q.remove(u);


            for (Arc arc : g.getAdjacence(u).getArcs()) {
                String v = arc.getNoeuds();

                if (Q.contains(v)) {
                    double nouvelleValeur = valeurs.getValeur(u) + arc.getPoids();
                    if (nouvelleValeur < valeurs.getValeur(v)) {
                        valeurs.setValeur(v, nouvelleValeur);
                        valeurs.setParent(v, u);
                    }
                }
            }
        }
        return valeurs;
    }
}