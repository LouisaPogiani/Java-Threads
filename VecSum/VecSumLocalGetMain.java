
public class VecSumLocalGetMain {

	public static void main(String[] args){
		 int numSteps = 100;
		 double size=1.0;
		 double step = size / (double)numSteps;
		 double x;
		

		// get current time
		long start = System.currentTimeMillis();

		// create threads
		VecSumThread threads[] = new VecSumThread[numSteps];
		
		// thread execution   
		for (int i = 0; i < numSteps; i++) 
		{
			x = ((double)i+0.5)*step;
			threads[i] = new VecSumThread(i, numSteps, x, size, step);
			threads[i].start();
		}

		double sum = 0.0;
		// wait for threads to terminate            
		for (int i = 0; i < numSteps; i++) {
			try {
				threads[i].join();
				sum = sum + threads[i].mySum;
			} catch (InterruptedException e) {}
		}

		double pi = sum * step;

		// get current time and calculate elapsed time
		long elapsedTimeMillis = System.currentTimeMillis()-start;

		  System.out.printf("sequential program results with %d steps\n", numSteps);
	      System.out.printf("computed pi = %22.20f\n" , pi);
	      System.out.printf("difference between estimated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
	      System.out.printf("time to compute = %f seconds\n", (double) (elapsedTimeMillis) / 1000);

	}
}

class VecSumThread extends Thread
{
	public double mySum;
	private double myX;
	private int myId;
	private double myStart;
	private double myStop;

	// constructor
	public VecSumThread(int id, int numThreads, double x, double size, double block)
	{
		mySum = 0.0;
		myId = id;
		myX=x;
		myStart = myId * block;
		myStop = myStart + block;
		if (myId == (numThreads - 1)) myStop = (int) size;
	}

	// thread code
	public void run()
	{
		for(double i = myStart; i < myStop; i++) 
			mySum += 4.0/(1.0+myX*myX);

	}
}

