// Main.java in SEE




import CIE.Internals;
import SEE.External;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        
        External[] students = new External[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1));

            
            System.out.print("Enter USN: ");
            String usn = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Semester: ");
            int sem = scanner.nextInt();

            
            int[] internalMarks = new int[5];
            System.out.println("Enter Internal Marks for 5 courses: ");
            for (int j = 0; j < 5; j++) {
                internalMarks[j] = scanner.nextInt();
            }

            
            Internals internals = new Internals(internalMarks);

            
            int[] externalMarks = new int[5];
            System.out.println("Enter External Marks for 5 courses: ");
            for (int j = 0; j < 5; j++) {
                externalMarks[j] = scanner.nextInt();
            }

            
            students[i] = new External(usn, name, sem, externalMarks);

            
            System.out.println("\nStudent Details: ");
            System.out.println("USN: " + students[i].getUsn());
            System.out.println("Name: " + students[i].getName());
            System.out.println("Semester: " + students[i].getSem());

            
            internals.displayInternalMarks();

            
            students[i].displayExternalMarks();

            
            int totalInternalMarks = internals.getTotalInternalMarks();
            int totalExternalMarks = students[i].getTotalExternalMarks();
            int finalMarks = totalInternalMarks + totalExternalMarks;
            System.out.println("Total Internal Marks: " + totalInternalMarks);
            System.out.println("Total External Marks: " + totalExternalMarks);
            System.out.println("Final Marks (Internal + External): " + finalMarks);
        }

        scanner.close();
    }
}