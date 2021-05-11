package grafikeditor_0;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

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

        JButton loadButton = new JButton("Laden");
        loadButton.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser j = new JFileChooser(new File(System.getProperty("user.home")));
                int r = j.showOpenDialog(null);

                if (r == JFileChooser.APPROVE_OPTION) {
                    File file = j.getSelectedFile();
                    try {
                        editorControl.load(file);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    editorFrame.focusSetzen();
                    editorFrame.repaint();
                }
            }
        });
        this.add(loadButton);
        JButton saveButton = new JButton("Speichern");
        saveButton.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    editorControl.save();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                editorFrame.focusSetzen();
            }
        });
        this.add(saveButton);

        JButton clearButton = new JButton("Leeren");
        clearButton.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editorControl.arrayLeeren();
                ef.erzeugeUndSetzeEditorPanel();
                editorFrame.focusSetzen();
            }
        });
        this.add(clearButton);

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
