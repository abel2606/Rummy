/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
/**
 *
 * @author Abe
 */
public class PanelArrastrable extends JPanel{
    private JPanel draggablePanel;
    private int mouseX, mouseY;

    public PanelArrastrable() {
        setSize(400, 400);
        setLayout(null); // Set layout to null to manually control positioning

        draggablePanel = new JPanel();
        draggablePanel.setBackground(Color.BLUE);
        draggablePanel.setBounds(50, 50, 100, 100); // Initial position and size

        // Add MouseListener to detect when the mouse is pressed
        draggablePanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // Save the mouse coordinates relative to the panel
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        // Add MouseMotionListener to detect when the panel is dragged
        draggablePanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                // Calculate the new position of the panel
                int x = e.getXOnScreen() - mouseX;
                int y = e.getYOnScreen() - mouseY;

                // Set the new position of the panel
                draggablePanel.setLocation(x, y);
            }
        });

        add(draggablePanel);
        setVisible(true);
    }

   
}
