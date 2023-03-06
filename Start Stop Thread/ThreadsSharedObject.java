
public class ThreadsSharedObject{

	public static void main(String[] args)
	{
       
        int numThreads = 0;
	       	
		
		SharedCounter count = new SharedCounter();
		// get current time
		long start = System.currentTimeMillis();

		// create threads
		SqrtGroupThread threads[] = new SqrtGroupThread[numThreads];
		
		// thread execution   
		for(int i = 0; i < numThreads; i++) 
		{
			threads[i] = new SqrtGroupThread(i, numThreads, count);
			threads[i].start();
		}

		// wait for threads to terminate            
		for(int i = 0; i < numThreads; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {}
		}

		// get current time and calculate elapsed time
		long elapsedTimeMillis = System.currentTimeMillis()-start;
		System.out.println("time in ms = "+ elapsedTimeMillis);

	}
}

class SharedCounter {
	
	static int size = 0;
    static  double[] a = new double[size];
    
    public SharedCounter () {
		
		for(int i = 0; i < size; i++)
			a[i] = i;

	}		

}    


class SqrtGroupThread extends Thread
{
	private double [] table;
	private int myStart;
	private int myStop;
	SharedCounter mycount;
	int size;

	// constructor
	public SqrtGroupThread(int myId, int numThreads,SharedCounter count)
	{
		mycount = count;
		table = count.a;
		size = count.size;
		myStart = myId * (size / numThreads);
		myStop = myStart + (size / numThreads);
		if (myId == (numThreads - 1)) myStop = size;
	}

	// thread code
	public void run()
	{
		for(int i = myStart; i < myStop; i++) 
           	table[i] = Math.sqrt(table[i]);
	}
}

