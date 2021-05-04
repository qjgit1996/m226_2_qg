package grafikeditor_0;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
final class EditorFrame extends JFrame {
    private EditorControl editorControl = new EditorControl();
    JPanel panel;
    JPanel container;

    public EditorFrame(int breite, int hoehe) {
        this.setTitle("Q's Grafikeditor 1.0");
        erzeugeUndSetzeEditorPanel();
        fensterEinmitten(breite, hoehe);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                editorControl.setFigurTyp(e.getKeyChar());
            }
        });
    }

    public void erzeugeUndSetzeEditorPanel() {
        this.container = new JPanel();
        this.container.setLayout(new BorderLayout());
        Border blackline = BorderFactory.createLineBorder(Color.black);
        JPanel panel2 = new ButtonPanel(editorControl, this);
        panel2.setLayout(new FlowLayout());
        this.panel = new EditorPanel(editorControl);
        this.panel.setLayout(new FlowLayout());
        this.panel.setBorder(blackline);
        this.container.add(panel2, BorderLayout.NORTH);
        this.container.add(this.panel, BorderLayout.CENTER);
        this.container.setVisible(true);
        setContentPane(this.container);
    }

    private void fensterEinmitten(int breite, int hoehe) {
        Dimension bildschirmGroesse = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle fensterAusschnitt = new Rectangle();
        fensterAusschnitt.width = breite;
        fensterAusschnitt.height = hoehe;
        fensterAusschnitt.x = (bildschirmGroesse.width - fensterAusschnitt.width) / 2;
        fensterAusschnitt.y = (bildschirmGroesse.height - fensterAusschnitt.height) / 2;
        setBounds(fensterAusschnitt);
    }

    public void focusSetzen() {
        this.setVisible(true);
        this.toFront();
        this.requestFocus();
    }
}
