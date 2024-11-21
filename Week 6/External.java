// External.java in SEE





package SEE;

import CIE.Student;

public class External extends Student {
    private int[] externalMarks;

   
    public External(String usn, String name, int sem, int[] externalMarks) {
        super(usn, name, sem);  
        if (externalMarks.length == 5) {
            this.externalMarks = externalMarks;
        } else {
            throw new IllegalArgumentException("External marks must be an array of size 5.");
        }
    }

    
    public int getTotalExternalMarks() {
        int total = 0;
        for (int mark : externalMarks) {
            total += mark;
        }
        return total;
    }

    
    public void displayExternalMarks() {
        System.out.print("External Marks: ");
        for (int mark : externalMarks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }
}
