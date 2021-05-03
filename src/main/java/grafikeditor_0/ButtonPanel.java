package grafikeditor_0;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;

@SuppressWarnings("serial")
class ButtonPanel extends JPanel {

    private EditorControl editorControl;
    private EditorFrame editorFrame;

    ButtonPanel(EditorControl control, EditorFrame ef) {
        editorFrame = ef;
        editorControl = control;
        JButton colorButton = new JButton("Farbe");
        colorButton.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Choose Color", ((JButton) e.getSource()).getBackground());
                if (newColor != null) {
                    ((JButton) e.getSource()).setBackground(newColor);
                    ((JButton) e.getSource()).setForeground(newColor);
                    editorControl.setFarbe(newColor);
                    editorFrame.focusSetzen();
                }
            }
        });
        this.add(colorButton);
        String[] choices = { "Ausgefüllt", "Nicht Ausgefüllt" };
        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cb.getSelectedItem().equals("Ausgefüllt")) {
                    editorControl.setAusgefuellt(true);
                    editorFrame.focusSetzen();
                }
                if (cb.getSelectedItem().equals("Nicht Ausgefüllt")) {
                    editorControl.setAusgefuellt(false);
                    editorFrame.focusSetzen();
                }
            }
        });
        cb.setBounds(50, 50,20,20);
        this.add(cb);
    }
}
