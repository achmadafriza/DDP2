package lab7.ddp2;

public class Lab07_2020 {
    public static void main(String[] args) {
        Circle2D c1 = new Circle2D();
        Circle2D c2 = new Circle2D(2, 2, 2.5);
        Circle2D c3 = new Circle2D(5.0, 6.0, 3.1);
        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
        System.out.println("c3: " + c3);
        System.out.printf("Area of %s is %.2f%n", "c2", c2.getArea());
        System.out.printf("Perimeter of %s is %.2f%n", "c2", c2.getPerimeter());
        System.out.println("c2 contains point (3, 3)? "
                + c2.contains(3, 3));
        System.out.println("c3 contains circle Circle2D(4, 5, 8.5)? "
                + c3.contains(new Circle2D(4, 5, 8.5)));
        System.out.println("c1 overlaps circle Circle2D(3, 5, 0.3)? "
                + c1.overlaps(new Circle2D(3, 5, 0.3)));
        System.out.println("c2 overlaps c3? "
                + c2.overlaps(c3));
        System.out.println("c1 contains c1? "
                + c1.contains(c1));
        System.out.println("Circle Circle2D(1, 0, 7) contains c1? "
                + new Circle2D(1,0,7).contains(c1));
        System.out.printf("The hashcode of c1 is %h%n", c1);
        System.out.println("Total number of circles created: " +
                Circle2D.getNumberOfCircle());
    }
}
