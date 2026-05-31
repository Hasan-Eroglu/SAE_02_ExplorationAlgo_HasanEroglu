public class Arc {

    private double poids;
    private String noeuds;
    

    /**
     * Constructeur d'un arc.
     * @param n le nœud cible
     * @param p le poids de l'arc
     */
    public Arc(String n, double p) {
        this.poids = p;
        this.noeuds = n;
    }

    public double getPoids() {
        return this.poids;
    }
    public String getNoeuds() {
        return this.noeuds;
    }
}