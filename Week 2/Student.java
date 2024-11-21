// Program to calculate SGPA of a Student



import java.util.Scanner;


class Student{
    private String usn;
    private String name;
    private int[] credits;
    private int[] marks;

    public Student(int numberOfSubjects){
        credits = new int[numberOfSubjects];
        marks = new int[numberOfSubjects];
    }


    public void acceptDetails(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter USN: ");
        usn = scanner.nextLine();

        System.out.print("Enter Name: ");
        name = scanner.nextLine();


        for (int i = 0; i < credits.length; i++){
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = scanner.nextInt();

            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }


    public void displayDetails(){
        System.out.println();
        System.out.println("Student Details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);

        for(int i = 0; i < credits.length; i++){
            System.out.println("Subject " + (i + 1) + ": Credits = " + credits[i] + ", Marks = " + marks[i]);
        }
    }


    public double calculateSGPA(){
        int totalCredits = 0;
        double weightedMarks = 0;

        for (int i = 0; i < credits.length; i++){
            weightedMarks += (marks[i] / 10) * credits[i];
            totalCredits += credits[i];
        }

        return totalCredits > 0 ? weightedMarks / totalCredits : 0;
    }



    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        Student student = new Student(numberOfSubjects);

        student.acceptDetails();
        student.displayDetails();

        double sgpa = student.calculateSGPA();
        System.out.printf("SGPA: %.2f%n", sgpa);

        scanner.close();
    }
}