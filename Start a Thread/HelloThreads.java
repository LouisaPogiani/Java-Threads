
public class HelloThreads {
	
	
	public static void main(String[] args) {

        /* allocate array of thread objecst */
        int numThreads = 20;
        Thread[] threads = new Thread[numThreads];


        /* create and start threads */
        for (int i = 0; i < numThreads; ++i) {
            System.out.println("In main: create and start thread " + i);
            threads[i] = new MyThread();
            threads[i].start();
            
            
        }
        /* wait for threads to finish */
        for (int i = 0; i < numThreads; ++i) {
            try {
                threads[i].join();
            }
            catch (InterruptedException e) {
                System.err.println("this should not happen");
            }
        }

        System.out.println("In main: threads all done");
    }

}

/* class containing code for each thread to execute */
   class MyThread extends Thread {
	   
	 Thread thread= new Thread();

    /* thread code */
    public void run() {
    	
        System.out.println("Hello from thread " + Thread.currentThread().getName());
        for(int i=0; i<2; i++) {
        thread = new MySecondThread(i);
        thread.start();
        }
    } 

}


/* class containing code for each thread to execute */
  class MySecondThread extends Thread {

    /* instance variables */
    private int myID;

    /* constructor */
    public MySecondThread(int myID) {
        this.myID = myID;
    }

    /* thread code */
    public void run() {
        System.out.println("Thread " + myID + " exits");
    } 

}
