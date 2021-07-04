package lab7.ddp2;

public class Circle2D {
    //data fields
    private double x;
    private double y;
    private double radius;
    private static int numberOfCircle = 0;

    //default constructor for circle with
    //center (0.0,0.0) and radius 1.0
    public Circle2D() {
        this(0.0, 0.0, 1.0);
    }

    //general constructor for circle with center (x,y)
    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        numberOfCircle++;
    }

    //string representation of a circle
    public String toString() {
        String str =
                String.format("Circle: center (%.2f, %.2f), radius %.2f, hashcode %h",
                        this.x, this.y, this.radius, this);
        return str;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPerimeter() {
        return 2 * this.radius * Math.PI;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public static int getNumberOfCircle() {
        return numberOfCircle;
    }

    //Is this circle contains the point (x,y)?
    public boolean contains(double x, double y) {
        double d = distance(x, y, this.x, this.y) ;
        return d <= this.radius;
    }

    //Is this circle contains the circle c?
    public boolean contains(Circle2D c) {
    /* circle c1 contains circle c2 if the sum of the distance
       between the two centers and the radius of c2 is less
       than or equal to the radius of c1  */

        double d = distance(this.x, this.y, c.getX(), c.getY());
        return (d + c.getRadius()) <= this.radius;
    }

    //Is this circle overlaps with the circle c?
    public boolean overlaps(Circle2D c) {
    /* Two circles overlap if the distance between the two centers
       are less than or equal to sum of the radii */
        double d = distance(this.x, this.y, c.getX(), c.getY());
        return d <= (this.radius + c.getRadius());
    }

    //distance between point (x1,y1) and point (x2,y2)
    private static double distance(double x1, double y1,
                                   double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
