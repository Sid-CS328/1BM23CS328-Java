// Program to solve Quadratic Equation



import java.util.Scanner;


public class QuadraticEquationSolver{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();


        double discriminant = ( (b * b) - (4 * a * c) );


        if (discriminant > 0){
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

            System.out.println("The equation has 2 real solutions:");
            System.out.printf("Root 1: %.2f%n", root1);
            System.out.printf("Root 2: %.2f%n", root2);
        }


        else if (discriminant == 0){
            double root = -b / (2 * a);
            System.out.println("The equation has one real solution:");
            System.out.printf("Root: %.2f%n", root);
        }

        else{
            System.out.println("There are no real solutions.");
        }

        scanner.close();
    }
}