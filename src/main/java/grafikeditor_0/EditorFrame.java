package grafikeditor_0;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
final class EditorFrame extends JFrame {
    private EditorControl editorControl = new EditorControl();

    public EditorFrame(int breite, int hoehe) {
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

    private void erzeugeUndSetzeEditorPanel() {
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        Border blackline = BorderFactory.createLineBorder(Color.black);
        JPanel panel2 = new ButtonPanel(editorControl, this);
        panel2.setLayout(new FlowLayout());
        JPanel panel = new EditorPanel(editorControl);
        panel.setLayout(new FlowLayout());
        panel.setBorder(blackline);
        container.add(panel2, BorderLayout.NORTH);
        container.add(panel, BorderLayout.CENTER);
        container.setVisible(true);
        setContentPane(container);
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
