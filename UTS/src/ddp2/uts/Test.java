package ddp2.uts;

public class Test {
    public static void main(String[] args) {
        int i=4;
        int j=6;
        switch(--i) {
            case 2: j++; break;
            case 3: j=j--;
            case 4: System.out.println((i != j) || (i++ <= 0)); break;
            case 5: j=j+i;
            default: System.out.println("default case");
                j=j*5;
                i=i*2;
        }
        System.out.printf("i=%d j=%d\n",i,j%-3);
        System.out.println("\u0062b" + 'b' + j);
    }

    public static double m(int i) {
        double sum = 0;

        for (int j = 1; j <= i; j++)
            sum += (j / (2.0*j + 1));

        return sum;
    }
}
