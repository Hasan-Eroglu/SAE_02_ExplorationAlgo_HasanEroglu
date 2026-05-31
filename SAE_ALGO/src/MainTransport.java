import java.util.List;

/**
 * Programme principal pour appliquer les algorithmes
 * de plus court chemin sur le réseau STAN
 */
public class MainTransport {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Erreur : Veuillez fournir l'arrêt de départ et d'arrivée en arguments");
            return;
        }

        String depart = args[0];
        String arrivee = args[1];

        Graphe g = LireReseau.lire("stan.nodes.txt", "stan.edges.txt");

        long startBF = System.nanoTime();
        BellmanFord bf = new BellmanFord();
        Valeurs vBF = bf.resoudre(g, depart);
        long endBF = System.nanoTime();

        List<String> cheminBF = vBF.calculerChemin(arrivee);
        System.err.println("Bellman-Ford" );
        System.err.println("Temps : " + (endBF - startBF) + " ns");
        System.err.println("Coût : " + vBF.getValeur(arrivee));
        System.err.println("Chemin : " + cheminBF);


        long startD = System.nanoTime();
        Dijkstra d = new Dijkstra();
        Valeurs vD = d.resoudre(g, depart);
        long endD = System.nanoTime();

        List<String> cheminD = vD.calculerChemin(arrivee);
        System.err.println("Dijkstra");
        System.err.println("Temps : " + (endD - startD) + " ns");
        System.err.println("Coût : " + vD.getValeur(arrivee));
        System.err.println("Chemin : " + cheminD);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cheminD.size(); i++) {
            sb.append(cheminD.get(i));
            if (i < cheminD.size() - 1) sb.append(";");
        }
        System.out.println(sb.toString());
    }
}
