import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests unitaires pour vérifier la construction du graphe
 */
public class TestGraphe {

    @Test
    public void testAjouterArc() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);

        // Vérifier que A est bien dans le graphe
        assertTrue(g.getNoeuds().contains("A"));
        // Vérifier que B est bien dans le graphe
        assertTrue(g.getNoeuds().contains("B"));
    }

    @Test
    public void testAdjacence() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);

        // Vérifier que l'arc A→B a bien un poids de 12
        Arcs arcs = g.getAdjacence("A");
        assertEquals(12.0, arcs.getArcs().get(0).getPoids(), 0.001);
    }

    @Test
    public void testNombreNoeuds() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("B", "E", 11);

        // Vérifier qu'on a bien 4 noeuds (A, B, D, E)
        assertEquals(4, g.getNoeuds().size());
    }
}