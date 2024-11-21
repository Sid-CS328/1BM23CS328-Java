// Internals.java in CIE




package CIE;

public class Internals {
    private int[] internalMarks;

    
    public Internals(int[] internalMarks) {
        if (internalMarks.length == 5) {
            this.internalMarks = internalMarks;
        } else {
            throw new IllegalArgumentException("Internal marks must be an array of size 5.");
        }
    }

    
    public int getTotalInternalMarks() {
        int total = 0;
        for (int mark : internalMarks) {
            total += mark;
        }
        return total;
    }

    
    public void displayInternalMarks() {
        System.out.print("Internal Marks: ");
        for (int mark : internalMarks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }
}
