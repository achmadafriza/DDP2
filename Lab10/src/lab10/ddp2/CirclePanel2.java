package lab10.ddp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CirclePanel2 extends JPanel {
    private final int WIDTH = 600, HEIGHT = 400;
    private Circle circle;
    //-----------------------------------------------------------------
    // Sets up this panel to listen for mouse events.
    //-----------------------------------------------------------------
    public CirclePanel2() {
        addMouseListener (new CirclesListener());
        addMouseMotionListener(new MotionListener());
        setBackground(Color.BLACK);
        setPreferredSize (new Dimension(WIDTH, HEIGHT));
    }
    //-----------------------------------------------------------------
    // Draws the current circle, if any.
    //-----------------------------------------------------------------
    public void paintComponent (Graphics page) {
        super.paintComponent(page);
        if (circle != null) circle.draw(page);
    }

    //*****************************************************************
    // Represents the listener for mouse events.
    //*****************************************************************
    private class CirclesListener implements MouseListener {
        //--------------------------------------------------------------
        // Creates a new circle at the current location whenever the
        // mouse button is clicked and repaints.
        //--------------------------------------------------------------
        public void mouseClicked (MouseEvent event) {
//            circle = new Circle(event.getPoint());

            if(circle != null) {
                if(circle.isInside(event.getPoint())) {
                    circle = null;
                }
                else {
                    circle.move(event.getPoint());
                }
            }
            else {
                circle = new Circle(event.getPoint());
            }

            repaint();
        }
        //-----------------------------------------------------------------
        // Provide empty definitions for unused event methods.
        //-----------------------------------------------------------------
        public void mousePressed (MouseEvent event) {}
        public void mouseReleased (MouseEvent event) {}
        public void mouseEntered (MouseEvent event) {
            setBackground(Color.WHITE);
            repaint();
        }
        public void mouseExited (MouseEvent event) {
            setBackground(Color.BLACK);
            repaint();
        }
    }

    private class MotionListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            if(circle != null && circle.isInside(e.getPoint())) {
                circle.move(e.getPoint());
            }

            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {}
    }
}