package lab4.ddp2;

import java.util.Scanner;
public class GaltonBox {
    /**
     GaltonBox.java
     Idea of the program:
     Construct an array named slots. Each element in slots stores the number
     of balls in a slot. Each ball falls randomly into a slot via a path.
     The number of Rs in a path is the position of the slot where the ball falls.
     For example, for the path LRLRLRR, the ball falls into slots[4] (because
     there are 4 Rs), and for the path RRLLLLL, the ball falls into slots[2]
     (because there are 2 Rs).
     */

    public static void main(String[] args) {
        final int numberOfSlots = 15;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of balls: ");
        int numberOfBalls = input.nextInt();

        // Create the slots array
        int[] slots = new int[numberOfSlots];

        System.out.println();
        // Accumulate the balls into the slots
        for (int i = 0; i < numberOfBalls; i++) {
            slots[onePath(numberOfSlots)]++;
        }

        printHistogram(slots);

        input.nextLine(); //clean up the input buffer
        System.out.println("Press any key to continue…");
        input.nextLine();

        input.close();
    }

    /**
     Return the slot position of the ball for a random path and
     also print the path
     */
    public static int onePath(int numberOfSlots) {
        int position = 0;

        for (int i = 0; i < numberOfSlots - 1; i++)
            if (Math.random() < 0.5) {
                System.out.print("L");
            }
            else {
                System.out.print("R");
                position++;
            }

        System.out.println();
        return position;
    }

    /**
     Print the histogram for the slots, from top to bottom row by row
     */
    public static void printHistogram(int[] slots) {
        int maxSlotHeight = max(slots);

//        for(int slot : slots) {
//            System.out.print(slot + ", ");
//        }
//        System.out.println("\n" + maxSlotHeight);

        System.out.println();
        for (int h = maxSlotHeight; h > 0; h--) {
            for (int i = 0; i < slots.length; i++) {
                if (slots[i] < h) {
                    System.out.print(" ");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < slots.length; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    /**
     Get the max element in slots
     */
    public static int max(int[] slots) {
        int ans = -1;

        for (int i = 0; i < slots.length; i++) {
            if(ans < slots[i]) {
                ans = slots[i];
            }
        }

        return ans;
    }
}