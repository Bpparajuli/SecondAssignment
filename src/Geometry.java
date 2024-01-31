abstract class GeometricObject implements Comparable<GeometricObject> {
    abstract double getArea();
    abstract double getVolume();

    @Override
    public int compareTo(GeometricObject obj) {
        if (this.getVolume() > obj.getVolume()) {
            return 1;
        } else if (this.getVolume() < obj.getVolume()) {
            return -1;
        } else {
            return 0;
        }
    }

    public static GeometricObject max(GeometricObject obj1, GeometricObject obj2) {
        return (obj1.compareTo(obj2) >= 0) ? obj1 : obj2;
    }
}

class Circle extends GeometricObject {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double getVolume() {
        return 0;
    }
}

class Cylinder extends GeometricObject {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    double getArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    @Override
    double getVolume() {
        return Math.PI * radius * radius * height;
    }
}

class ComparableCylinder extends GeometricObject {
    private double radius;
    private double height;

    public ComparableCylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    double getArea() {
        return 0;
    }

    @Override
    double getVolume() {
        return Math.PI * radius * radius * height;
    }
}

interface Colorable {
    void howToColor();
}

class Square extends GeometricObject implements Colorable {
    @Override
    double getArea() {
        return 0;
    }

    @Override
    double getVolume() {
        return 0;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides of the square.");
    }
}

public class Geometry {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(7);

        Cylinder cylinder1 = new Cylinder(3, 4);
        Cylinder cylinder2 = new Cylinder(2, 6);

        GeometricObject largerCircle = GeometricObject.max(circle1, circle2);
        GeometricObject largerCylinder = GeometricObject.max(cylinder1, cylinder2);

        System.out.println("Larger circle area: " + largerCircle.getArea());
        System.out.println("Larger cylinder volume: " + ((Cylinder)largerCylinder).getVolume());

        ComparableCylinder compCylinder1 = new ComparableCylinder(3, 4);
        ComparableCylinder compCylinder2 = new ComparableCylinder(2, 6);

        ComparableCylinder largerComparableCylinder = (ComparableCylinder) GeometricObject.max(compCylinder1, compCylinder2);
        System.out.println("Larger comparable cylinder volume: " + largerComparableCylinder.getVolume());

        Square square = new Square();
        square.howToColor();
    }
}
