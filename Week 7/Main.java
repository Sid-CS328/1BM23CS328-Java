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
            
            System.out.println("Test 1: Valid ages\n");
            Son son1 = new Son(45, 20); 

            
            System.out.println("\nTest 2: Invalid father's age\n");
            Son son2 = new Son(-1, 20); 

        } catch (WrongAgeException | InvalidSonAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            
            System.out.println("\nTest 3: Invalid son's age\n");
            Son son3 = new Son(30, 30); 

        } catch (WrongAgeException | InvalidSonAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            
            System.out.println("\nTest 4: Invalid son's negative age\n");
            Son son4 = new Son(40, -5); 

        } catch (WrongAgeException | InvalidSonAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
