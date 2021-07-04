package ddp2.tp2;

public class TestMagicSquare {

    public static void main(String[] args) {

        int n = 9; // size of magic square
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        }
        else {
            System.out.println("Usage: java -jar <jarFile> <odd size of square>");
            System.exit(1);
        }


        //Create an object of MagicSquare
        MagicSquare ms = new MagicSquare(n);

        // Print the results
        System.out.print("Magic Square of size " + n + "x" + n + ":\n\n" + ms +
                "\nMain diagonal sum: " + ms.diagonalSum() +
                "\nColumn sum: " +  ms.columnSum(0) +
                "\nRow sum: " + ms.rowSum(n-1) + "\n");

    }
}