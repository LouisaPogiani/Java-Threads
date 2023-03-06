//
//public class SharedCounterArrayGlobal_SimpleProgramWithThreadsSharedVol_1_1 {
//
//	static volatile int end = 1000;
//    static volatile int[] array = new int[end];
//    static volatile int numThreads = 4;
//
//    public static void main(String[] args) {
//
//		CounterThread threads[] = new CounterThread[numThreads];
//		
//		for (int i = 0; i < numThreads; i++) {
//			threads[i] = new CounterThread();
//			threads[i].start();
//		}
//	
//		for (int i = 0; i < numThreads; i++) {
//			try {
//				threads[i].join();
//			}
//			catch (InterruptedException e) {}
//		} 
//		check_array ();
//    }
//     
//    static void check_array ()  {
//		int i, errors = 0;
//
//		System.out.println ("Checking...");
//
//        for (i = 0; i < end; i++) {
//			if (array[i] != numThreads*i) {
//				errors++;
//				System.out.printf("%d: %d should be %d\n", i, array[i], numThreads*i);
//			}         
//        }
//        System.out.println (errors+" errors.");
//    }
//}
//
//
//     class CounterThread extends Thread {
//  	
//       public CounterThread() {
//       }
//  	
//       public void run() {
//  
//            for (int i = 0; i < SharedCounterExer.end; i++) {
//				for (int j = 0; j < i; j++)
//					SharedCounterExer.array[i]++;		
//            } 
//		}            	
//    }
//
