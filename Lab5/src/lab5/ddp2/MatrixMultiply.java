package lab5.ddp2;
import java.util.Scanner;

public class MatrixMultiply {
    public static void main(String[] args) {
        int n = 0; //size of matrices

        //Getting the size of matrices from command line
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
            if (!(n >= 2 && n <= 5)) {
                System.out.println(
                        "The size of the square matrix must be between 2 and 5");
                System.exit(1);
            }
        }
        else {
            System.out.println("Usage: java -jar <jarFile> <size of square matrix>");
            System.exit(1);
        }

        Scanner input = new Scanner(System.in);

        // Enter matrix1
        System.out.printf("Enter matrix1 of size %d X %d: \n", n, n);
        int[][] matrix1 = new int[n][n];
        for (int i = 0; i < matrix1.length; i++)
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = input.nextInt();
            }

        // Enter matrix2
        System.out.printf("Enter matrix2 of size %d X %d: \n", n, n);
        int[][] matrix2 = new int[n][n];
        for (int i = 0; i < matrix2.length; i++)
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = input.nextInt();
            }

        // Multiply two matrices and print the result
        int[][] resultMatrix = multiplyMatrix(matrix1, matrix2);
        System.out.println("\nThe multiplication result of the matrices is ");
        printResult(matrix1, matrix2, resultMatrix, '*');
    }

    /** The method for multiplying two matrices */
    public static int[][] multiplyMatrix(int[][] m1, int[][] m2) {
        int[][] result = new int[m1.length][m2[0].length];
        for(int y1 = 0; y1 < m1.length; y1++){
            for(int x2 = 0; x2 < m2[0].length; x2++){
                for(int i = 0; i < m1[0].length; i++){
                    result[y1][x2] += m1[y1][i] * m2[i][x2];
                }
            }
        }

        return result;
    }

    /** Print result */
    public static void printResult(int[][] m1, int[][] m2, int[][] m3, char op) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                System.out.printf("%4d ", m1[i][j]);
            }

            if (i == m1.length / 2) {
                System.out.print("  " + op + "  ");
            }
            else {
                System.out.print("     ");
            }

            for (int j = 0; j < m2[0].length; j++){
                System.out.printf("%4d ", m2[i][j]);
            }

            if (i == m1.length / 2) {
                System.out.print( "  =  " );
            }
            else {
                System.out.print("     ");
            }

            for (int j = 0; j < m3[0].length; j++) {
                System.out.printf("%4d ", m3[i][j]);
            }

            System.out.println();
        }
    }
}