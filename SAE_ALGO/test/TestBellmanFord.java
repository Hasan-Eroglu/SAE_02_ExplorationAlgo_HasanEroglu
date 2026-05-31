import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

/**
 * Tests unitaires pour vérifier l'algorithme de Bellman-Ford
 */
public class TestBellmanFord {


    public GrapheListe creerGraphe() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("E", "D", 43);
        return g;
    }

    @Test
    public void testValeurDepart() {
        GrapheListe g = creerGraphe();
        BellmanFord bf = new BellmanFord();
        Valeurs v = bf.resoudre(g, "A");


        assertEquals(0.0, v.getValeur("A"), 0.001);
    }

    @Test
    public void testValeurB() {
        GrapheListe g = creerGraphe();
        BellmanFord bf = new BellmanFord();
        Valeurs v = bf.resoudre(g, "A");


        assertEquals(12.0, v.getValeur("B"), 0.001);
    }

    @Test
    public void testValeurC() {
        GrapheListe g = creerGraphe();
        BellmanFord bf = new BellmanFord();
        Valeurs v = bf.resoudre(g, "A");

        assertEquals(76.0, v.getValeur("C"), 0.001);
    }

    @Test
    public void testChemin() {
        GrapheListe g = creerGraphe();
        BellmanFord bf = new BellmanFord();
        Valeurs v = bf.resoudre(g, "A");
        List<String> chemin = v.calculerChemin("C");


        assertEquals("A", chemin.get(0));
        assertEquals("B", chemin.get(1));
        assertEquals("E", chemin.get(2));
        assertEquals("D", chemin.get(3));
        assertEquals("C", chemin.get(4));
    }

    @Test
    public void testParents() {
        GrapheListe g = creerGraphe();
        BellmanFord bf = new BellmanFord();
        Valeurs v = bf.resoudre(g, "A");
        assertEquals("fin", v.getParent("A"));
        assertEquals("A", v.getParent("B"));
        assertEquals("D", v.getParent("C"));
        assertEquals("E", v.getParent("D"));
        assertEquals("B", v.getParent("E"));
    }
}