
public class HelloThread {

	 public static void main(String[] args) { 

		  
	        MyThread thread= new MyThread();
	          thread.start();
	        MySecondThread thread1= new MySecondThread(1,2);
	          thread1.start();
	          
	        /* wait for threads to finish */
	        
	            try {
	            	thread.join();
	            	thread1.join();
	            }
	            catch (InterruptedException e) {
	                System.err.println("this should not happen");
	            }
	        

	        System.out.println("In main: threads all done");
	   }
	}

	/* class containing code for each thread to execute */
	class MyThread extends Thread {

	    /* thread code */
	    public void run() {
	        System.out.println("Hello from thread " + Thread.currentThread().getName());
	    } 

	}
	
	/* class containing code for each thread to execute */
	class MySecondThread extends Thread {

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
	
