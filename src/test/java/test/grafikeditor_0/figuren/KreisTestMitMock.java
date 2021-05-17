package test.grafikeditor_0.figuren;

import grafikeditor_0.figuren.Kreis;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KreisTestMitMock {

    private Graphics g = Mockito.mock(Graphics.class);

    @Test
    public void testZeichnen() {
        Kreis k = new Kreis(15, 6, 23, Color.BLACK, false);
        Kreis l = new Kreis(15, 6, 23, Color.BLACK, false);
        k.zeichnen(g);
        l.zeichnen(g);
        assertEquals(15, 15);
        assertEquals(6, 6);
        Mockito.verify(g, Mockito.times(2)).drawOval(15 - 23, 6 - 23, 2 * 23, 2 * 23);
    }
}
