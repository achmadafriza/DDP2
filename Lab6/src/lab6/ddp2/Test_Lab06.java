package lab6.ddp2;

public class Test_Lab06 {
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]); //get input size from command line

        double[] list = new double[size]; //create a double array of size element

        for (int i = 0; i < list.length; i++) {
            list[i] = Math.random() * list.length;  //fill with random numbers
        }

        StopWatch stopWatch = new StopWatch(); //create a StopWatch object
        selectionSort(list);
        stopWatch.stop();

        int count = 0;
        //print the sorted array, 10 elements per row
        for(double elem: list) {
            System.out.printf("%.2f, ", elem); //print only two digits after the decimal point
            if (++count%10 == 0) System.out.println();
        }
        System.out.println();

        System.out.println("The sort time is " + stopWatch.getElapsedTime());
    }

    /** The selectionSort method for sorting the numbers */
    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum in the list[i..list.length-1]
     		int min_index = i;
     		for(int k = i+1; k < list.length; k++) {
     		    if(list[k] < list[min_index]) {
     		        min_index = k;
                }
            }

            // Swap list[i] with list[currentMinIndex] if necessary;
      		double temp = list[i];
     		list[i] = list[min_index];
     		list[min_index] = temp;
        }
    }
}