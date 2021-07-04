package ddp2.uas;

import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        double val, sum = 0;
        Scanner scan = new Scanner(System.in);
        String line;

        System.out.println("Type a line of text: ");
        Scanner scanLine = new Scanner(scan.nextLine());

        while(scanLine.hasNext()) {
            try {
                val = Double.parseDouble(scanLine.next());
                sum += val;
            }
            catch(NumberFormatException e) {}
        }

        System.out.println(sum);
    }
}
