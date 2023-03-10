
public class HelloThread_TwoThreads {
	
	public static void main(String[] args) {

        /* allocate array of thread objecst */
        int numThreads = 20;
        Thread[] threads = new Thread[numThreads];  
        Thread[] threads2 = new Thread[numThreads];


        /* create and start threads */
        for (int i = 0; i < numThreads; ++i) {
            System.out.println("In main: create and start thread " + i);
            threads[i] = new MyThread();
            threads[i].start();
            threads2[i] = new MySecondThread(i, numThreads);
            threads2[i].start();
            
        }
        /* wait for threads to finish */
        for (int i = 0; i < numThreads; ++i) {
            try {
                threads[i].join();
                threads2[i].join();
            }
            catch (InterruptedException e) {
                System.err.println("this should not happen");
            }
        }

        System.out.println("In main: threads all done");
    }



/* class containing code for each thread to execute */
  static class MyThread extends Thread {

    /* thread code */
    public void run() {
        System.out.println("Hello from thread " + Thread.currentThread().getName());
    } 

}


/* class containing code for each thread to execute */
static  class MySecondThread extends Thread {

    /* instance variables */
    private int myID;
    private int totalThreads;

    /* constructor */
    public MySecondThread(int myID, int totalThreads) {
        this.myID = myID;
        this.totalThreads = totalThreads;
    }

    /* thread code */
    public void run() {
        System.out.println("Hello from thread " + myID + " out of " + totalThreads);
        System.out.println("Thread " + myID + " exits");
    } 

}


}
