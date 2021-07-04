package tp1.ddp2;

import javax.swing.JOptionPane;

public class CreditCardValidation {
    static void inputIsValid(String s) throws NullPointerException, StringIndexOutOfBoundsException {
        if("QUIT".equals(s.toUpperCase())) {
            throw new NullPointerException();
        }

        if(s.length() > 16) {
            throw new StringIndexOutOfBoundsException();
        }

        Long.parseLong(s); // Throws NumberFormatException

//        It is separated to distinguish yourmom *sorry* and 123123, throwing correct error message.
        if(s.length() < 13) {
            throw new StringIndexOutOfBoundsException();
        }
    }

    static String askInput() {
        return JOptionPane.showInputDialog(
                null,
                "Enter a Credit/Debit card number as a long integer,\n" +
                        "QUIT to end:",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    static String issuerIsValid(String s) throws ClassNotFoundException {
        if("4".equals(s.substring(0, 1))) {
            return "Visa";
        }

        if("5".equals(s.substring(0, 1))) {
            return "Mastercard";
        }

        if("6".equals(s.substring(0, 1))) {
            return "Discover";
        }

        if("37".equals(s.substring(0, 2))) {
            return "American Express";
        }

        throw new ClassNotFoundException();
    }

//    This is a bit unique. As i'm too lazy to use Integer.parseInt(),
//    I'd rather subtract char's ascii code ("".charAt()) with ascii code of '0'.
    static int parseDigit(String s, int i) {
        return s.charAt(i) - '0';
    }

    static boolean isValid(String s) {

//        Uses Luhn's Algorithm to Check Validity.
//        Loops the string from right to left.
        int ans = 0;
        for(int i = s.length() - 1; i >= 0 ; i--) {
            if((s.length() - i)%2 != 0) {
//                Even index from right is added.
                ans += parseDigit(s, i);
            } else {
//                Odd index from right is doubled and it's digits is added.
                ans += (parseDigit(s, i)*2)%10 + (parseDigit(s, i)*2)/10;
            }
        }

        return ans%10 == 0;
    }

    public static void main(String[] args) {

//        This Program loops until null or QUIT is found on the Input
        while(true) {
            String input = null;
            String issuer;
            try {
                input = askInput();

//                Checks the Validity of Input
//                Throws NullPointerException, StringIndexOutOfBoundsException, NumberFormatException
                inputIsValid(input);

//                Checks Validity of Issuer, I know there are many more, but i'm too lazy to compile them all...
//                Throws ClassNotFoundException
                issuer = issuerIsValid(input);
            } catch(NullPointerException e) {
//                As User intended to QUIT, main() is returned which ended the program.
                return;
            } catch(StringIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Number has to be between 13 and 16 digits."
                );
//                Continues as it is User Error, not intended QUIT
                continue;
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "String " + input + " is Invalid."
                );
//                Continues as it is User Error, not intended QUIT
                continue;
            } catch(ClassNotFoundException e) {
                JOptionPane.showMessageDialog(
                         null,
                        "Issuer is not found."
                );
//                Continues as it is User Error, not intended QUIT
                continue;
            }

//            isValid Parses the Input and checks through Luhn Algorithm, returns boolean
            if(isValid(input)) {
                JOptionPane.showMessageDialog(
                        null,
                        "The Credit/Debit card number " + input + " issued by " + issuer + " is Valid."
                );
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "The Credit/Debit card number " + input + "is Invalid."
                );
            }
        }
    }
}