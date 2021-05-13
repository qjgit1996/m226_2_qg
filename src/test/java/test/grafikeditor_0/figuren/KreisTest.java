package test.grafikeditor_0.figuren;

import grafikeditor_0.figuren.Kreis;
import org.junit.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class KreisTest {
    private test.grafikeditor_0.figuren.GraphicsStub g = new test.grafikeditor_0.figuren.GraphicsStub();
    private Kreis k;

    @Test
    public void testZeichnen() {
        Kreis k = new Kreis(15, 6, 23, Color.BLACK, false);
        k.zeichnen(g);
        assertEquals(1, g.nbOfDrawOvalCalls);
        assertEquals(15, 15);
        assertEquals(6, 6);
        assertEquals(2*23, g.width);
        assertEquals(2*23, g.height);
    }
}