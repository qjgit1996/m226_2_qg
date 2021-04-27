package grafikeditor_0;

import grafikeditor_0.figuren.Figur;
import grafikeditor_0.figuren.Kreis;
import grafikeditor_0.figuren.Linie;
import grafikeditor_0.figuren.Rechteck;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Die Klasse Display stellt ein Fenster auf dem Bildschirm zur Verf�gung, in welchem
 * Figur-Objekte dargestellt werden k�nnen.
 * Siehe auch Java-Grundkurs Abschnitt 10.2 und 10.3.
 * 
 * @author Andres Scheidegger
 */
@SuppressWarnings("serial")
public class Display extends JFrame {
  /** Die Liste der dargestellten Figur-Objekte */
  private List<Figur> figuren = new ArrayList<Figur>();

  /**
   * Konstruktor. Initialisiert das Fenster in der Mitte des Bildschirms und erzeugt ein
   * JFrame-Objekt, auf welchem die Figuren gezeichnet werden.
   */
  public Display() {
    Dimension windowSize = new Dimension(800, 600);
    setSize(windowSize);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int windowPositionX = (screenSize.width - windowSize.width) / 2;
    int windowPositionY = (screenSize.height - windowSize.height) / 2;
    Point windowPosition = new Point(windowPositionX, windowPositionY);
    setLocation(windowPosition);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    createAndAddDrawingPanel();
    setVisible(true);
  }

  private void createAndAddDrawingPanel() {
    // Das JPanel-Objekt ist ein Objekt einer anonymen Unterklasse von JPanel
    // Siehe Java-Grundkurs Abschnitt 3.9
    add(new JPanel() {
      // Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
      // Methode beim Dsiplay aufruft.
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        zeichneFiguren(g);
      }
    });
  }

  /**
   * Zeichnet alle Figuren.
   * @param g Referenz auf das Graphics-Objekt zum zeichnen.
   */
  private void zeichneFiguren(Graphics g) {
    for (Figur f : figuren) {
      if (f instanceof Rechteck) {
        Rechteck r = (Rechteck)f;
        g.drawRect(r.getX(), r.getY(), r.getBreite(), r.getHoehe());
      }
      if (f instanceof Linie) {
        Linie l = (Linie)f;
        g.setColor(l.getFarbe());
        l.move(200,200);
        g.drawLine(l.getX(), l.getY(), l.getBreite(), l.getHoehe());
      }
      if (f instanceof Kreis) {
        Kreis k = (Kreis)f;
        g.drawOval(k.getX()-k.getRadius(), k.getY()-k.getRadius(), 2*k.getRadius(), 2*k.getRadius());
      }


      /* TODO: Hier muss für jede weitere Figur-Klasse, welche dargestellt werden k�nnen muss,
       * ein analoger Abschnitt, wie für die Rechteck-Klasse folgen.
       */
    }
  }

  /**
   * F�gt eine weitere Figur hinzu und l�st die Auffrischung des Fensterinhaltes aus.
   * @param figur Referenz auf das weitere Figur-Objekt.
   */
  public void hinzufuegen(Figur figur) {
    figuren.add(figur);
    repaint();
  }

  public void save(Figur figur) {
    BufferedWriter writer = null;
    try {
      //create a temporary file
      File logFile = new File("/Users/quintengroenveld/Documents/m226_2_qg");
      writer = new BufferedWriter(new FileWriter(logFile));
      if (figur instanceof Rechteck) {
        Rechteck r = (Rechteck)figur;
        writer.write("Origin: " + r.getX() + " " + r.getY());
        writer.newLine();
        writer.write("Height/Width: " + r.getHoehe() + " " + r.getBreite());
      }
      if (figur instanceof Linie) {
        Linie l = (Linie)figur;
        writer.write("Origin: " + l.getX() + " " + l.getY());
        writer.newLine();
        writer.write("Height/Width: " + l.getHoehe() + " " + l.getBreite());
      }
      if (figur instanceof Kreis) {
        Kreis k = (Kreis)figur;
        writer.write("Origin: " + k.getX() + " " + k.getY());
        writer.newLine();
        writer.write("Radius: " + k.getRadius());
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        // Close the writer regardless of what happens...
        writer.close();
      } catch (Exception e) {
      }
    }
  }

  public void load() {}
}
