// Class for the first thread that prints "BMS College of Engineering" every 10 seconds
class Thread1 extends Thread {
    String a;
    int timer;

    int i = 0;
    int numTimesEx;

    Thread1(String inp, int time, int numTimes){
	this.a = inp;
	this.timer = time;
	this.numTimesEx = numTimes;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(this.a);
                Thread.sleep(this.timer);
		i++;
		
		if(i >= numTimesEx){
			this.interrupt();
		}  
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}



public class ThreadExample {
    public static void main(String[] args) {
        
        Thread1 thread1 = new Thread1("BMS College of Engineering", 10000, 5);
        Thread1 thread2 = new Thread1("CSE", 2000, 25);

        
        thread1.start();
        thread2.start();
    }
}

