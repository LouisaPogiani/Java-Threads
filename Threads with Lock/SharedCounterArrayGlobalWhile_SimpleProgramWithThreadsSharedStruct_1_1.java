//
//public class SharedCounterArrayGlobalWhile_SimpleProgramWithThreadsSharedStruct_1_1 {
//
//	 public static void main(String[] args) {
//	    	
//	    	int numThreads = 4;
//	    	
//	    	SharedCounter counter = new SharedCounter();
//
//	        CounterThread threads[] = new CounterThread[numThreads];
//		
//			for (int i = 0; i < numThreads; i++) {
//				threads[i] = new CounterThread(counter);
//				threads[i].start();
//			}
//		
//			for (int i = 0; i < numThreads; i++) {
//				try {
//					threads[i].join();
//				}
//				catch (InterruptedException e) {}
//			} 
//	        check_array (counter);
//	    }
//	     
//	    static void check_array (SharedCounter counter)  {
//			int i, errors = 0;
//
//			System.out.println ("Checking...");
//
//	        for (i = 0; i < counter.end; i++) {
//				if (counter.array[i] != 1) {
//					errors++;
//					System.out.printf("%d: %d should be 1\n", i, counter.array[i]);
//				}         
//			}
//	        System.out.println (errors+" errors.");
//	    }
//}
//	    
//class SharedCounter {
//	    	
//	     int end ;
//	     int counter;
//	     int[] array = new int[end];
//	    	
//	    	public SharedCounter (){
//	    		 end = 1000;
//	    	     array = new int[end];
//	    	     counter = 0;
//	        }
//	    	
//	    }
//
//
//class CounterThread extends Thread {
//	  
//	       SharedCounter count;
//	  	
//	       public CounterThread(SharedCounter counter) {
//	    	   count=counter;
//	       }
//	  	
//	       public void run() {
//	       
//	            while (true) {
//					if (count.counter >= count.end) 
//	                	break;
//					count.array[count.counter]++;
//					count.counter++;		
//	            } 
//			}            	
//	    }
