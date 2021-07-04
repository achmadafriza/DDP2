package lab8.ddp2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//*********************************************************
// VoteCounterPanel.java
//
// Demonstrates a graphical user interface and event listeners to
// tally votes for two candidates, Joe and Sam.
//*********************************************************

public class VoteCounterPanel extends JPanel{
    private int votesForJoe;
    private JButton joe;
    private JLabel labelJoe;

    private int votesForSam;
    private JButton sam;
    private JLabel labelSam;

    private int votesForMary;
    private JButton mary;
    private JLabel labelMary;
    //----------------------------------------------
    // Constructor: Sets up the GUI.
    //----------------------------------------------
    public VoteCounterPanel()
    {

        votesForJoe = 0;
        joe = new JButton("Vote for Joe");
        joe.addActionListener(new JoeButtonListener());
        labelJoe = new JLabel("Votes for Joe: " + votesForJoe);
        add(joe);
        add(labelJoe);

        votesForSam = 0;
        sam = new JButton("Vote for Sam");
        sam.addActionListener(new SamButtonListener());
        labelSam = new JLabel("Votes for Sam: " + votesForSam);
        add(sam);
        add(labelSam);

        votesForMary = 0;
        mary = new JButton("Vote for Mary");
        mary.addActionListener(new MaryButtonListener());
        labelMary = new JLabel("Votes for Mary: " + votesForMary);
        add(mary);
        add(labelMary);

        setPreferredSize(new Dimension(200, 200));
        setBackground(Color.cyan);
    }

    //***************************************************
    // Represents a listener for button push (action) events
    //***************************************************
    private class JoeButtonListener implements ActionListener
    {
        //----------------------------------------------
        // Updates the counter and label when Vote for Joe
        // button is pushed
        //----------------------------------------------
        public void actionPerformed(ActionEvent event)
        {
            votesForJoe++;
            labelJoe.setText("Votes for Joe: " + votesForJoe);
        }
    }

    //***************************************************
    // Represents a listener for button push (action) events
    //***************************************************
    private class SamButtonListener implements ActionListener
    {
        //----------------------------------------------
        // Updates the counter and label when Vote for Joe
        // button is pushed
        //----------------------------------------------
        public void actionPerformed(ActionEvent event)
        {
            votesForSam++;
            labelSam.setText("Votes for Sam: " + votesForSam);
        }
    }

    //***************************************************
    // Represents a listener for button push (action) events
    //***************************************************
    private class MaryButtonListener implements ActionListener
    {
        //----------------------------------------------
        // Updates the counter and label when Vote for Joe
        // button is pushed
        //----------------------------------------------
        public void actionPerformed(ActionEvent event)
        {
            votesForMary++;
            labelMary.setText("Votes for Mary: " + votesForMary);
        }
    }
}
