import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation d'un graphe orienté pondéré
 * via une liste d'adjacence.
 */
public class GrapheListe implements Graphe {

    private List<String> noeuds;
    private List<Arcs> adjacence;

    /**
     * Constructeur qui crée un graphe vide.
     */
    public GrapheListe() {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }

    /**
     * @return la liste des nœuds du graphe
     */
    @Override
    public List<String> getNoeuds() {
        return this.noeuds;
    }

    /**
     * @return la liste d'adjacence du nœud donné
     */
    @Override
    public Arcs getAdjacence(String noeud) {
        int index = this.noeuds.indexOf(noeud);
        if (index == -1) return null;
        return this.adjacence.get(index);
    }

    /**
     * Ajoute un arc entre deux nœuds avec un poids donné.
     * Si les nœuds n'existent pas encore, ils sont créés.
     * @param source le nœud de départ
     * @param destination le nœud d'arrivée
     * @param poids le poids de l'arc
     */
    public void ajouterArc(String source, String destination, double poids) {
        if (!this.noeuds.contains(source)) {
            this.noeuds.add(source);
            this.adjacence.add(new Arcs());
        }

        if (!this.noeuds.contains(destination)) {
            this.noeuds.add(destination);
            this.adjacence.add(new Arcs());
        }
        int index = this.noeuds.indexOf(source);
        this.adjacence.get(index).ajouterArc(new Arc(destination, poids));
    }

    /**
     * Affiche le graphe sous forme textuelle.
     */
    public void afficher() {
        for (String noeud : this.noeuds) {
            StringBuilder sb = new StringBuilder(noeud + " -> ");
            Arcs arcs = this.getAdjacence(noeud);
            for (Arc arc : arcs.getArcs()) {
                sb.append(arc.getNoeuds())
                        .append("(")
                        .append((int) arc.getPoids())
                        .append(") ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    /**
     * @return la liste d'adjacence complète
     */
    public List<Arcs> getAdjacenceListe() {
        return this.adjacence;
    }
}