// Program to Print Area of different Shapes



import java.util.Scanner;



abstract class Shape {
    int dim1;
    int dim2;

    
    public Shape() {
        this.dim1 = 0;
        this.dim2 = 0;
    }


    public Shape(int dim1, int dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }


    public abstract void printArea();
}






class Rectangle extends Shape {
    public Rectangle(int length, int width) {
        dim1 = length;
        dim2 = width;
    }


    public void printArea() {
        int area = dim1 * dim2;
        System.out.println("Area of Rectangle: " + area);
    }
}





class Triangle extends Shape {
    public Triangle(int base, int height) {        
        dim1 = base;
        dim2 = height;
    }


    public void printArea() {
        double area = 0.5 * dim1 * dim2;
        System.out.println("Area of Triangle: " + area);
    }
}





class Circle extends Shape {
    public Circle(int radius) {  
        dim1 = radius;
        dim2 = 0;
    }


    public void printArea() {
        double area = Math.PI * dim1 * dim1;
        System.out.println("Area of Circle: " + area);
    }
}





public class shapes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter length and width for Rectangle:");
        int length = scanner.nextInt();
        int width = scanner.nextInt();
        Shape rectangle = new Rectangle(length, width);
        rectangle.printArea();


        System.out.println("Enter base and height for Triangle:");
        int base = scanner.nextInt();
        int height = scanner.nextInt();
        Shape triangle = new Triangle(base, height);
        triangle.printArea();


        System.out.println("Enter radius for Circle:");
        int radius = scanner.nextInt();
        Shape circle = new Circle(radius);
        circle.printArea();



        scanner.close();
    }
}