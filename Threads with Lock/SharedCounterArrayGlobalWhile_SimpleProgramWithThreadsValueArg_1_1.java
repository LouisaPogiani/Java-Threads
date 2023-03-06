//
//public class SharedCounterArrayGlobalWhile_SimpleProgramWithThreadsValueArg_1_1 {
//
//	 public static void main(String[] args) {
//	    	
//    	 int end = 10000;
//  	     int counter = 0;
//  	     int[] array = new int[end];
//  	     int numThreads = 4;
//
//        CounterThread threads[] = new CounterThread[numThreads];
//	
//		for (int i = 0; i < numThreads; i++) {
//			threads[i] = new CounterThread(end,counter,array);
//			threads[i].start();
//		}
//	
//		for (int i = 0; i < numThreads; i++) {
//			try {
//				threads[i].join();
//			}
//			catch (InterruptedException e) {}
//		} 
//        check_array (array, end);
//    }
//     
//    static void check_array (int array[], int end)  {
//		int i, errors = 0;
//
//		System.out.println ("Checking...");
//
//        for (i = 0; i < end; i++) {
//			if (array[i] != 1) {
//				errors++;
//				System.out.printf("%d: %d should be 1\n", i, array[i]);
//			}         
//		}
//        System.out.println (errors+" errors.");
//    }
//}
//
//     class CounterThread extends Thread {
//    	 
//    	 int table [];
//    	 int count;
//    	 int myend;
//  	
//       public CounterThread(int end, int counter, int array[]) {
//    	   table=array;
//    	   count=counter;
//    	   myend=end;
//       }
//  	
//       public void run() {
//       
//            while (true) {
//				if (count >= myend) 
//                	break;
//				table[count]++;
//            	count++;		
//            } 
//		}            	
//    }
