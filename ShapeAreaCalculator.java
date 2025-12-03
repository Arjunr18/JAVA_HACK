import java.util.Scanner;

interface Shape {
    double area();
}

class Circle implements Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double length, width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double area() {
        return length * width;
    }
}

class Triangle implements Shape {
    private double base, height;
    
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double area() {
        return (base * height) / 2;
    }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nShape Area Calculator (Interface)");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            System.out.print("Choose a shape (1-4): ");
            
            int choice = scanner.nextInt();
            
            if (choice == 4) {
                System.out.println("Exiting...");
                break;
            }
            
            Shape shape = null; 
            
            switch (choice) {
                case 1: 
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    if (radius > 0) {
                        shape = new Circle(radius);
                    } else {
                        System.out.println("Invalid radius. Must be positive.");
                        continue;
                    }
                    break;
                    
                case 2: 
                    System.out.print("Enter length: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter width: ");
                    double width = scanner.nextDouble();
                    if (length > 0 && width > 0) {
                        shape = new Rectangle(length, width);
                    } else {
                        System.out.println("Invalid dimensions. Must be positive.");
                        continue;
                    }
                    break;
                    
                case 3: 
                    System.out.print("Enter base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double height = scanner.nextDouble();
                    if (base > 0 && height > 0) {
                        shape = new Triangle(base, height);
                    } else {
                        System.out.println("Invalid dimensions. Must be positive.");
                        continue;
                    }
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please select 1-4.");
                    continue;
            }
            
            
            if (shape != null) {
                System.out.printf("Area: %.2f\n", shape.area());
            }
        }
        
        scanner.close();
    }
}

