package lab3.ddp2;

import javax.swing.JOptionPane;

public class DecimaltoHexConverter {
    public static void main(String[] args) {
        String input;

        // Repeats until User inputs QUIT or pressed Cancel.
        while(true) {
            // Asks user for Input
            input = JOptionPane.showInputDialog(null,
                    "Please enter a positive decimal integer <= " + Integer.MAX_VALUE + "or QUIT to quit:",
                    JOptionPane.PLAIN_MESSAGE);

            // Tries to convert Input. If User inputs wrongly, raises NumberFormatException
            try {
                int num = Integer.parseInt(input);

                if(num < 0) {
                    throw new NumberFormatException();
                }

                // Class for Building String, so that it can be reversed
                StringBuilder ans = new StringBuilder();
                for(int mod; num > 0; num /= 16) {
                    mod = num % 16;

                    // Switch case for ease of conversion
                    switch (mod) {
                        case 10:
                            ans.append("A");
                            break;
                        case 11:
                            ans.append("B");
                            break;
                        case 12:
                            ans.append("C");
                            break;
                        case 13:
                            ans.append("D");
                            break;
                        case 14:
                            ans.append("E");
                            break;
                        case 15:
                            ans.append("F");
                            break;
                        default:
                            ans.append(mod);
                    }
                }

                // Outputs the Hex Value
                JOptionPane.showMessageDialog(null,
                        "The hex number for decimal number " + input + "is:\n"
                                + ans.reverse());
            }
            catch(NumberFormatException e){
                if(input == null || "QUIT".equals(input.toUpperCase())) {
                    break;
                }

                JOptionPane.showMessageDialog(null, "Wrong input.");
            }
            // For Unnecessary Errors.
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}
