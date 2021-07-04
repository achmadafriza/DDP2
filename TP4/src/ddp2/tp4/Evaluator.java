package ddp2.tp4;

import javax.swing.*;

public class Evaluator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Infix to Postfix Evaluator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EvaluatorPanel panel = new EvaluatorPanel();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
