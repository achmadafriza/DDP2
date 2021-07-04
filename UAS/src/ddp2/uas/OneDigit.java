package ddp2.uas;

public class OneDigit {
    public static void main(String[] args) {
        String s = "020160";
        int num = Integer.parseInt(s);
        System.out.println(onedigit(num));
    }

    public static int onedigit(int num) {
        if(num < 10) {
            return num;
        }
        else {
            return onedigit(num%10 + num/10);
        }
    }
}
