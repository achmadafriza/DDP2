package lab1.ddp2.part3;

import java.util.Scanner;

public class Circle {
    public static void main(String[] args)
    {
        final double PI = 3.14159;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a value for the radius: ");
        double radius = input.nextDouble();
        double area = PI * radius * radius;
        double circumference = 2 * radius * PI;
        System.out.println("The area of a circle with radius " + radius + " is " + area);
        System.out.println("The circumference of a circle with radius " + radius + " is " + circumference);

        System.out.print("Please enter a value for the radius: ");
        radius = input.nextDouble();
        area = PI * radius * radius;
        circumference = 2 * radius * PI;
        System.out.println("The area of a circle with radius " + radius + " is " + area);
        System.out.println("The circumference of a circle with radius " + radius + " is " + circumference);
    }

}
