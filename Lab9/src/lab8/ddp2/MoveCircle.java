package lab8.ddp2;

//******************************************************************
//MoveCircle.java
//
//Uses CirclePanel to display a GUI that lets the user move
//a circle by pressing buttons.
//******************************************************************
import java.awt.*;
import javax.swing.*;


public class MoveCircle {
    //-----------------------------------
//Set up a frame for the GUI.
//-----------------------------------
    public static void main(String[] args) {
        JFrame frame = new JFrame ("Lab 09: MoveCircle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,300));
        frame.getContentPane().add(new CirclePanel(600,300));
        frame.pack();
        frame.setVisible(true);
    }
}