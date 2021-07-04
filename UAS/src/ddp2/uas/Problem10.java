package ddp2.uas;

interface Bentuk {
    public double area();
    public double volume();
}

class Point implements Bentuk {
    protected int x, y;
    public Point() {
        this(0, 0);
        System.out.println("Point()");
    }
    public Point(int xCoord, int yCoord) {
        x = xCoord; y = yCoord;
        System.out.println("Point(int, int)");
    }

    @Override
    public String toString() {
        return "Point[" + x + "," + y + "]";
    }

    @Override
    public double area() {
        return 0.0;
    }

    @Override
    public double volume() {
        return 0.0;
    }
}

class Rect extends Point {
    protected int width, height;
    public Rect() {
        this(0, 0);
        System.out.println("Rect()");
    }

    public Rect(int w, int h) {
        super(0, 0); width = w; height = h;
        System.out.println("Rect(int, int)");
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Luas = " + area();
    }
}

public class Problem10 {
    public static void main(String[] args) {
        Point a = new Point(3, 5);
        Rect b = new Rect(7, 8);
        Bentuk bt = a;
        System.out.println(bt);
        bt = b;
        System.out.println(bt);
        System.out.println(((Point) bt));
    }
}
