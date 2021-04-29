package grafikeditor_0;

import grafikeditor_0.figuren.Figur;
import grafikeditor_0.figuren.Kreis;
import grafikeditor_0.figuren.Linie;
import grafikeditor_0.figuren.Rechteck;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
  /**
   * Die Liste der dargestellten Figur-Objekte
   */
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
   *
   * @param g Referenz auf das Graphics-Objekt zum zeichnen.
   */
  private void zeichneFiguren(Graphics g) {
    for (Figur f : figuren) {
      if (f instanceof Rechteck) {
        Rechteck r = (Rechteck) f;
        g.drawRect(r.getX(), r.getY(), r.getBreite(), r.getHoehe());
      }
      if (f instanceof Linie) {
        Linie l = (Linie) f;
        g.setColor(l.getFarbe());
        System.out.println(l.getFarbe());
        //l.move(200,200);
        g.drawLine(l.getX(), l.getY(), l.getBreite(), l.getHoehe());
        save(l);
      }
      if (f instanceof Kreis) {
        Kreis k = (Kreis) f;
        g.drawOval(k.getX() - k.getRadius(), k.getY() - k.getRadius(), 2 * k.getRadius(), 2 * k.getRadius());
      }


      /* TODO: Hier muss für jede weitere Figur-Klasse, welche dargestellt werden k�nnen muss,
       * ein analoger Abschnitt, wie für die Rechteck-Klasse folgen.
       */
    }
  }

  /**
   * F�gt eine weitere Figur hinzu und l�st die Auffrischung des Fensterinhaltes aus.
   *
   * @param figur Referenz auf das weitere Figur-Objekt.
   */
  public void hinzufuegen(Figur figur) {
    figuren.add(figur);
    repaint();
  }

  public void save(Figur figur) {
    int anzahlDateien = Objects.requireNonNull(new File("/Users/quintengroenveld/Documents/m226_2_qg/figuren").list()).length - 1;
    File f = new File("/Users/quintengroenveld/Documents/m226_2_qg/figuren/figur" + (anzahlDateien-1) + ".txt");
    f.delete();
    BufferedWriter writer = null;
    try {
      String dateiName = "/Users/quintengroenveld/Documents/m226_2_qg/figuren/figur" + anzahlDateien + ".txt";
      File logFile = new File(dateiName);
      writer = new BufferedWriter(new FileWriter(logFile));
      if (figur instanceof Rechteck) {
        Rechteck r = (Rechteck) figur;
        writer.write("Figurtyp: Rechteck");
        writer.newLine();
        writer.write("Origin: " + r.getX() + " " + r.getY());
        writer.newLine();
        writer.write("Height/Width: " + r.getHoehe() + " " + r.getBreite());
        if (r.getFarbe() != null) {
          writer.newLine();
          writer.write("RGB: " + r.getFarbe().getRed() + " " + r.getFarbe().getGreen() + " " + r.getFarbe().getBlue());
        }
        writer.newLine();
        writer.write("Ausgefuellt: " + r.getAusgefuellt());
      }
      if (figur instanceof Linie) {
        Linie l = (Linie) figur;
        writer.write("Figurtyp: Linie");
        writer.newLine();
        writer.write("Origin: " + l.getX() + " " + l.getY());
        writer.newLine();
        writer.write("Height/Width: " + l.getHoehe() + " " + l.getBreite());
        if (l.getFarbe() != null) {
          writer.newLine();
          writer.write("RGB: " + l.getFarbe().getRed() + " " + l.getFarbe().getGreen() + " " + l.getFarbe().getBlue());
        }
      }
      if (figur instanceof Kreis) {
        Kreis k = (Kreis) figur;
        writer.write("Figurtyp: Kreis");
        writer.newLine();
        writer.write("Origin: " + k.getX() + " " + k.getY());
        writer.newLine();
        writer.write("Radius: " + k.getRadius());
        if (k.getFarbe() != null) {
          writer.newLine();
          writer.write("RGB: " + k.getFarbe().getRed() + " " + k.getFarbe().getGreen() + " " + k.getFarbe().getBlue());
        }
        writer.newLine();
        writer.write("Ausgefuellt: " + k.getAusgefuellt());
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

  public void load(String pfad) throws IOException {
    File file = new File(pfad);
    BufferedReader br = new BufferedReader(new FileReader(file));
    String string;
    int i = 0;
    String figurTyp = null;
    int x = 0;
    int y = 0;
    int breite = 0;
    int hoehe = 0;
    int radius = 0;
    boolean aufgefuellt = false;
    Color farbe = Color.BLACK;

    while ((string = br.readLine()) != null) {
      String[] arrayString = string.split(" ");
      if (i == 0) {
        figurTyp = arrayString[1];
      }
      if (i == 1) {
        x = Integer.parseInt(arrayString[1]);
        y = Integer.parseInt(arrayString[2]);
      }
      if (i == 2) {
        if (arrayString.length == 3) {
          hoehe = Integer.parseInt(arrayString[1]);
          breite = Integer.parseInt(arrayString[2]);
        } else {
          radius = Integer.parseInt(arrayString[1]);
        }
      }
      if (i == 3) {
        if (arrayString.length > 2) {
          farbe = new Color(Integer.parseInt(arrayString[1]), Integer.parseInt(arrayString[2]), Integer.parseInt(arrayString[3]));
        } else {
          aufgefuellt = Boolean.parseBoolean(arrayString[1]);
        }
      }
      if (i == 4) {
        aufgefuellt = Boolean.parseBoolean(arrayString[1]);
      }
      i++;
    }
    if (i == 3) {
      if (figurTyp.equals("Linie")) {
        this.hinzufuegen(new Linie(x, y, breite, hoehe));
      }
      if (figurTyp.equals("Kreis")) {
        this.hinzufuegen(new Kreis(x, y, radius));
      }
      if (figurTyp.equals("Rechteck")) {
        this.hinzufuegen(new Linie(x, y, breite, hoehe));
      }
    }
    if (i == 4) {
      if (figurTyp.equals("Linie")) {
        this.hinzufuegen(new Linie(x, y, breite, hoehe, farbe));
      }
      if (figurTyp.equals("Kreis")) {
        this.hinzufuegen(new Kreis(x, y, radius, farbe, aufgefuellt));
      }
      if (figurTyp.equals("Rechteck")) {
        this.hinzufuegen(new Rechteck(x, y, breite, hoehe, farbe, aufgefuellt));
      }
    }
    if (i == 5) {
      if (figurTyp.equals("Linie")) {
        this.hinzufuegen(new Linie(x, y, breite, hoehe, farbe));
      }
      if (figurTyp.equals("Kreis")) {
        this.hinzufuegen(new Kreis(x, y, radius, farbe, aufgefuellt));
      }
      if (figurTyp.equals("Rechteck")) {
        this.hinzufuegen(new Rechteck(x, y, breite, hoehe, farbe, aufgefuellt));
      }
    }
  }
}
