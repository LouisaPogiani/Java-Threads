
public class SharedCounterArrayGlobal_SimpleProgramWithThreadsSharedMon_1_2 {

    public static void main(String[] args) {
    	
        int numThreads = 4;

   	
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
		check_array (numThreads, counter);
   }
   
    
   static void check_array (int numThreads, SharedCounter counter)  {
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

   	    int end;
        int[] array;
   

       public SharedCounter (){
   		this.end = 1000;
   		this.array = new int[end];
       }
       
       public synchronized void inc (int i) {
       	for (int j = 0; j < i; j++)
				array[i]++;	
       }
      
   }


    class CounterThread extends Thread {
   	 
   	 SharedCounter count;
 	
      public CounterThread(SharedCounter counter) {
   	   count=counter;
      }
 	
      public void run() {
 
           for (int i = 0; i < count.end; i++) {
					count.inc(i);		
           } 
		}            	
   }
