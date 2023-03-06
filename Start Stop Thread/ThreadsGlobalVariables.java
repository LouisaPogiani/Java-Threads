
public class ThreadsGlobalVariables{

	static int size = 10;
	static int numThreads = 10;
	static double[] a = new double[size];

	public static void main(String[] args)
	{

		for(int i = 0; i < size; i++)
			a[i] = i;
		  //a[i] = Math.random()*size; 
  
		/* for debugging */
		for(int i = 0; i < size; i++) 
			System.out.println(a[i]); 
     
		// get current time
		long start = System.currentTimeMillis();

		// create threads
		SqrtGroupThread threads[] = new SqrtGroupThread[numThreads];
		
		// thread execution   
		for(int i = 0; i < numThreads; i++) 
		{
			threads[i] = new SqrtGroupThread(i);
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

		/* for debugging */
		for(int i = 0; i < size; i++) 
			System.out.println(a[i]); 

	}

static class SqrtGroupThread extends Thread
  {
	private double [] table;
	private int myStart;
	private int myStop;

	// constructor
	public SqrtGroupThread(int myId)
	{
		table = a;
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

}
