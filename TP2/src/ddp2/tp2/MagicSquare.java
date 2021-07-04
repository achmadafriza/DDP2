package ddp2.tp2;

/**
 A magic square that is constructed by a the "right and down" algorithm.
 */
public class MagicSquare
{
    private int[][] square;
    private int size;

    /**
     Construct a MagicSquare object
     (precondition: s is odd).
     @param s the size of the square
     */
    public MagicSquare(int s)
    {
        size = s;
        square = new int[s][s];

//        for(int i = 1, row = size-1, col = (size-1)/2; i <= size*size; i++, row = (row+1)%size, col = (col+1)%size) {
//            // If [row+1][col+1] is filled, then move up
//            if(square[row][col] != 0) {
//                row -= 2;
//                col -= 1;
//            }
//
//            // This is a corner case when "move up" is out of bounds
//            if(row < 0) row += size;
//            if(col < 0) col += size;
//
//            square[row][col] = i;
//        }

        // basically above.
        for(int i = 0; i < size*size; i++) {
             /*
             What i did here is use the starting point [size-1][(size-1)/2], and move south-east.
             Then, if the pointer meet a filled coordinate {every (i+1)%size}, then it moves up i/size times
             */
            square[(((size-1) + i - 2*(i/size))%size + size)%size][(((size-1)/2 + i - (i/size))%size + size)%size] = i+1;
        }
    }

    /**
     Find the sum of the diagonal.
     @return sum: the sum of the diagonal
     */
    public int diagonalSum()
    {
        int sum = 0;
//        Diagonal means same row, col index
        for(int i = 0; i < size; i++) {
            sum += square[i][i];
        }

        return sum;
    }

    /**
     Add the numbers in a column of the square.
     @param col the column index
     @return the sum of the column
     */
    public int columnSum(int col)
    {
        int sum = 0;
        for(int row = 0; row < size; row++) {
            sum += square[row][col];
        }

        return sum;
    }

    /**
     Add the numbers in a row of the square.
     @param row the row index
     @return the sum of the row
     */
    public int rowSum(int row)
    {
        int sum = 0;
        for(int col = 0; col < size; col++) {
            sum += square[row][col];
        }

        return sum;
    }

    /**
     Gets a string representation of the contents of this square.
     @return a string represenation of the square
     */
    public String toString()
    {
        StringBuilder r = new StringBuilder();

//        I dont want to use += appending String. I'll use StringBuilder instead lol.
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                r.append(" ").append(String.format("%3d", square[row][col]));
            }

            r.append("\n");
        }

        return r.toString();
    }
}