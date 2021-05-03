package grafikeditor_0;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class EditorPanel extends JPanel {
    private EditorControl editorControl;

    EditorPanel(EditorControl control) {
        editorControl = control;
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                //System.out.println("1"+e.getPoint());
                editorControl.setErsterPunkt(e.getPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                //System.out.println("2"+e.getPoint());
                editorControl.erzeugeFigurMitZweitemPunkt(e.getPoint());
                repaint();
            }
        });
    }

    // Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
    // Methode beim EditorFrame oder beim EditorPanel aufruft.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        editorControl.allesNeuZeichnen(g);
    }
}
