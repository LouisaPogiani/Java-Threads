
public class VecSumGlobalMon {

	public static void main(String[] args)
	{
		 int numSteps = 100;
		 double size=1.0;
		 double step = size / (double)numSteps;
		 double x;
		 
		 sumObj sum = new sumObj();

		// get current time
		long start = System.currentTimeMillis();

		// create threads
		VecSumThread threads[] = new VecSumThread[numSteps];
		
		// thread execution   
		for (int i = 0; i < numSteps; i++) 
		{
			x = ((double)i+0.5)*step;
			threads[i] = new VecSumThread(i, numSteps, x, size, step, sum);
			threads[i].start();
		}

		// wait for threads to terminate            
		for (int i = 0; i < numSteps; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {}
		}

		
		
		double pi = sum.sum * step;

		// get current time and calculate elapsed time
		long elapsedTimeMillis = System.currentTimeMillis()-start;

		  System.out.printf("sequential program results with %d steps\n", numSteps);
	      System.out.printf("computed pi = %22.20f\n" , pi);
	      System.out.printf("difference between estimated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
	      System.out.printf("time to compute = %f seconds\n", (double) (elapsedTimeMillis) / 1000);

	}
}

class sumObj {

    double sum;
    
    public sumObj (){
	this.sum = 0;
    }

    public synchronized void add (double localsum){
		this.sum += localsum;
    }

    public synchronized void printout() {
			System.out.println(this.sum);
    }
}


class VecSumThread extends Thread
{
	private sumObj globalSum;
	private double myX;
	private double mySum;
	private int myId;
	private double myStart;
	private double myStop;

	// constructor
	public VecSumThread(int id, int numThreads, double x, double size, double block,sumObj s)
	{
		globalSum = s;
		myId = id;
		myX=x;
		mySum=0;
		myStart = myId * block;
		myStop = myStart + block;
		if (myId == (numThreads - 1)) myStop = (int) size;
	}

	// thread code
	public void run()
	{
		for(double i = myStart; i < myStop; i++) {
			mySum = 4.0/(1.0+myX*myX);
			globalSum.add(mySum);
		}

	}
}

