package lab10.ddp2;

import javax.swing.JFrame;

public class Tutorial10 {
    //-----------------------------------------------------------------
    // Creates and displays the application frame.
    //-----------------------------------------------------------------
    public static void main (String[] args) {
        JFrame circlesFrame = new JFrame ("Lab 10 DDP2-2020");
        circlesFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        circlesFrame.getContentPane().add (new CirclePanel2());
        circlesFrame.pack();
        circlesFrame.setVisible(true);
    }
}