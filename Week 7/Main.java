import java.util.Scanner;


class WrongAgeException extends Exception {
    public WrongAgeException(String message) {
        super(message);
    }
}


class InvalidSonAgeException extends Exception {
    public InvalidSonAgeException(String message) {
        super(message);
    }
}


class Father {
    protected int fatherAge;

    
    public Father(int age) throws WrongAgeException {
        if (age < 0) {
            throw new WrongAgeException("Father's age cannot be negative: " + age);
        }
        this.fatherAge = age;
        System.out.println("Father's age is: " + this.fatherAge);
    }
}


class Son extends Father {
    private int sonAge;

    
    public Son(int fatherAge, int sonAge) throws WrongAgeException, InvalidSonAgeException {
        super(fatherAge); 
        if (sonAge < 0) {
            throw new WrongAgeException("Son's age cannot be negative: " + sonAge);
        }
        if (sonAge >= fatherAge) {
            throw new InvalidSonAgeException("Son's age cannot be greater than or equal to Father's age.");
        }
        this.sonAge = sonAge;
        System.out.println("Son's age is: " + this.sonAge);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter Father's age: ");
	    int fAge = scanner.nextInt();

	    System.out.print("Enter Son's age: ");
	    int sAge = scanner.nextInt();


            Son son1 = new Son(fAge, sAge); 

        } catch (WrongAgeException | InvalidSonAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}