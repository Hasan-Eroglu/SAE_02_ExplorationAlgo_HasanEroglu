import java.util.ArrayList;
import java.util.List;

/**
 * Représente une liste d'arcs pour un nœud donné.
 */
public class Arcs {

    private List<Arc> listeArcs;

    /**
     * Constructeur qui crée une liste vide d'arcs.
     */
    public Arcs() {
        this.listeArcs = new ArrayList<>();
    }

    /**
     * Ajoute un arc à la liste.
     * @param arc l'arc à ajouter
     */
    public void ajouterArc(Arc arc) {
        this.listeArcs.add(arc);
    }

    /**
     * @return la liste de tous les arcs
     */
    public List<Arc> getArcs() {
        return this.listeArcs;
    }
}