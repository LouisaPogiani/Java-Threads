
public class SharedCounterArrayGlobal_SimpleProgramWithThreadsSharedStruct_1_1 {

	  static int numThreads = 4;

	    public static void main(String[] args) {
	    	
	    	SharedCounter counter = new SharedCounter();

			CounterThread threads[] = new CounterThread[numThreads];
			
			for (int i = 0; i < numThreads; i++) {
				threads[i] = new CounterThread(counter);
				threads[i].start();
			}
		
			for (int i = 0; i < numThreads; i++) {
				try {
					threads[i].join();
				}
				catch (InterruptedException e) {}
			} 
			check_array (counter);
	    }
	     
	    static void check_array (SharedCounter counter)  {
			int i, errors = 0;

			System.out.println ("Checking...");

	        for (i = 0; i < counter.end; i++) {
				if (counter.array[i] != numThreads*i) {
					errors++;
					System.out.printf("%d: %d should be %d\n", i, counter.array[i], numThreads*i);
				}         
	        }
	        System.out.println (errors+" errors.");
	    }

	}

	class SharedCounter {
		
		int[] array ;
		int end;
		
		public SharedCounter (){
			 end = 1000;
		     array = new int[end];
	    }
		
	}
	     class CounterThread extends Thread {
	    	
	    	 SharedCounter count ;
	  	
	       public CounterThread(SharedCounter counter) {
	    	   count=counter;
	       }
	  	
	       public void run() {
	  
	            for (int i = 0; i < count.end; i++) {
					for (int j = 0; j < i; j++)
						count.array[i]++;		
	            } 
			}            	
	    }
