import java.util.List;


public interface Graphe {


    List<String> getNoeuds();

    /**
     * Retourne la liste d'adjacence (arcs) d'un nœud donné.
     * @param noeud l'identifiant du nœud
     * @return la liste des arcs partant de ce nœud
     */
    Arcs getAdjacence(String noeud);
}