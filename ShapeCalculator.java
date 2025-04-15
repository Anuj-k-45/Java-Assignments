import java.util.Scanner;

class ShapesData {
    private double radius;
    private double length;
    private double width;
    private int side;   
    private double base;
    private double height;
    private double side1, side2, side3;

    public ShapesData(double radius) {
        this.radius = radius;
    }

    public ShapesData(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public ShapesData(int side) {
        this.side = side;
    }

    public ShapesData(double base, double height, double side1, double side2, double side3) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double calculateCircleArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCirclePerimeter() {
        return 2 * Math.PI * radius;
    }

    public double calculateRectangleArea() {
        return length * width;
    }

    public double calculateRectanglePerimeter() {
        return 2 * (length + width);
    }

    public double calculateSquareArea() {
        return side * side;
    }

    public double calculateSquarePerimeter() {
        return 4 * side;
    }

    public double calculateTriangleArea() {
        return 0.5 * base * height;
    }

    public double calculateTrianglePerimeter() {
        return side1 + side2 + side3;
    }
}

public class ShapeCalculator {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide arguments for the geometric shape in CLI!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        ShapesData shape = null;

        switch (args[0].toLowerCase()) {
            case "circle":
                System.out.print("Enter radius of the circle: ");
                double radius = scanner.nextDouble();
                shape = new ShapesData(radius);
                double circleArea = shape.calculateCircleArea();
                double circlePerimeter = shape.calculateCirclePerimeter();
                System.out.println("Circle - Area: " + circleArea + "\nPerimeter: " + circlePerimeter + "\nRatio (Area/Perimeter): " + circleArea / circlePerimeter);
                break;

            case "rectangle":
                System.out.print("Enter length and width of the rectangle: ");
                double length = scanner.nextDouble();
                double width = scanner.nextDouble();
                shape = new ShapesData(length, width);
                double rectangleArea = shape.calculateRectangleArea();
                double rectanglePerimeter = shape.calculateRectanglePerimeter();
                System.out.println("Rectangle - Area: " + rectangleArea + "\nPerimeter: " + rectanglePerimeter + "\nRatio (Area/Perimeter): " + rectangleArea / rectanglePerimeter);
                break;

            case "square":
                System.out.print("Enter side of the square: ");
                int side = scanner.nextInt();
                shape = new ShapesData(side);
                double squareArea = shape.calculateSquareArea();
                double squarePerimeter = shape.calculateSquarePerimeter();
                System.out.printf("Square - Area: " + squareArea + "\nPerimeter: " + squarePerimeter + "\nRatio (Area/Perimeter): " + squareArea / squarePerimeter);
                break;

            case "triangle":
                System.out.print("Enter base and height of the triangle: ");
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                System.out.print("Enter three sides of the triangle: ");
                double side1 = scanner.nextDouble();
                double side2 = scanner.nextDouble();
                double side3 = scanner.nextDouble();
                shape = new ShapesData(base, height, side1, side2, side3);
                double triangleArea = shape.calculateTriangleArea();
                double trianglePerimeter = shape.calculateTrianglePerimeter();
                System.out.printf("Triangle - Area: " + triangleArea + "\nPerimeter: " + trianglePerimeter + "\nRatio (Area/Perimeter): " + triangleArea / trianglePerimeter);
                break;

            default:
                System.out.println("Invalid shape. Please enter circle, rectangle, square, or triangle.");
                break;
        }
    }
}