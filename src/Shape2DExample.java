// Visitor
interface Visitor {
    double visit(Rectangle rectangle);
    double visit(Circle circle);
}

// Element
interface Shape2D {
    double accept(Visitor visitor);
}

// Concrete Elements
class Rectangle implements Shape2D {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}

class Circle implements Shape2D {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public double getRadius() {
        return radius;
    }
}

// Concrete Visitor
class Shape2DVisitor implements Visitor {
    @Override
    public double visit(Rectangle rectangle) {
        return rectangle.getWidth() * rectangle.getHeight();
    }

    @Override
    public double visit(Circle circle) {
        return Math.PI * Math.pow(circle.getRadius(), 2);
    }
}

class CalcHeightVisitor implements Visitor {
    @Override
    public double visit(Rectangle rectangle) {
        return rectangle.getHeight();
    }

    @Override
    public double visit(Circle circle) {
        // Da ein Kreis keine Höhe hat, geben wir hier 0 zurück.
        return 0;
    }
}

public class Shape2DExample {
    public static void main(String[] args) {
        Shape2D rectangle = new Rectangle(5, 10);
        Shape2D circle = new Circle(7);

        Visitor areaVisitor = new Shape2DVisitor();
        Visitor heightVisitor = new CalcHeightVisitor();

        double areaOfRectangle = rectangle.accept(areaVisitor);
        double areaOfCircle = circle.accept(areaVisitor);

        double heightOfRectangle = rectangle.accept(heightVisitor);
        double heightOfCircle = circle.accept(heightVisitor);

        System.out.println("Area of Rectangle: " + areaOfRectangle);
        System.out.println("Area of Circle: " + areaOfCircle);
        System.out.println("Height of Rectangle: " + heightOfRectangle);
        System.out.println("Height of Circle: " + heightOfCircle);
    }
}
