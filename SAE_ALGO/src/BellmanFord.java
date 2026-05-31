import java.util.List;

/**
 * Implémentation de l'algorithme de Bellman-Ford
 * pour la recherche du plus court chemin dans un graphe.
 */
public class BellmanFord {

    /**
     * @param g le graphe orienté pondéré
     * @param depart le nœud de départ
     * @return un objet Valeurs contenant les distances et parents de chaque nœud
     */
    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs valeurs = new Valeurs();

        for (String noeud : g.getNoeuds()) {
            valeurs.setValeur(noeud, Double.MAX_VALUE);
            valeurs.setParent(noeud, null);
        }
        valeurs.setValeur(depart, 0);
        valeurs.setParent(depart, "fin");


        boolean modifie = true;
        while (modifie) {
            modifie = false;


            for (String noeud : g.getNoeuds()) {
                double valeurNoeud = valeurs.getValeur(noeud);


                if (valeurNoeud != Double.MAX_VALUE) {
                    Arcs arcs = g.getAdjacence(noeud);


                    for (Arc arc : arcs.getArcs()) {
                        String voisin = arc.getNoeuds();
                        double nouvelleValeur = valeurNoeud + arc.getPoids();


                        if (nouvelleValeur < valeurs.getValeur(voisin)) {
                            valeurs.setValeur(voisin, nouvelleValeur);
                            valeurs.setParent(voisin, noeud);
                            modifie = true;
                        }
                    }
                }
            }
        }
        return valeurs;
    }
}