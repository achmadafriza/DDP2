package ddp2.tp4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class EvaluatorPanel extends JPanel {
    private JLabel inputExpressionLabel, outputExpressionLabel, resultExpressionLabel;
    private JLabel outputExpression, resultExpression;
    private JTextField inputExpression;

    public EvaluatorPanel() {
        setLayout(new GridLayout(3, 2));
        setBorder(new EmptyBorder(5, 10, 5, 10));
        inputExpressionLabel = new JLabel("Infix expression:");
        outputExpressionLabel = new JLabel("Postfix expression:");
        resultExpressionLabel = new JLabel("Result:");
        inputExpression = new JTextField("(1-2)-((((4^5)*3)*6)/(7^(2^2)))");
        inputExpression.addActionListener(new ExpressionListener());
        outputExpression = new JLabel("---");
        resultExpression = new JLabel("---");

        add(inputExpressionLabel);
        add(inputExpression);
        add(outputExpressionLabel);
        add(outputExpression);
        add(resultExpressionLabel);
        add(resultExpression);
        setPreferredSize(new Dimension(500, 100));
        setBackground(Color.orange);
    }

    private class ExpressionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputExpression.getText();
            String output, result;

            try {
                output = InFixtoPostFix.convert(input);
                result = InFixtoPostFix.getCalculation(input);
            }
            catch(NullPointerException error) {
                output = "Expression must have an operand preceding it (e.g. 1 + + 2 is not allowed)";
                result = "Error!";
            }
            catch(ArithmeticException error) {
                output = error.getMessage();
                result = "Error!";
            }
            catch(Exception error) {
                output = "Unexpected error occurred...";
                result = "---";
            }

            outputExpression.setText(output);
            resultExpression.setText(result);
        }
    }
}