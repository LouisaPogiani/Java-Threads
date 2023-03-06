# Java-Threads
Parallel programming using Java Threads class.

# VEC SUM 
is refering to a map reduce  problem where we break down an array to do different calculations and then we gather the results back again into ine value.
Here we are breaking down the array to calculate PI but you can use the same technique if you have an array of 1000 values and you want to fins the sum
we break down the array and on the tread subclass we assing to each thread a start and end point that determines from which to whichh point it runs so that 
it won't interfere wit other threads. And then we start each thread in Main into a loop. 
Once the thrads have all run, we call the join() method --> (wait for each thread to finish) 
The, we add the locan sum of each thread into the general sum.
The code below, has 6 different variations that cann be executed, they all give the same result. It has minor differences.
(with static/global variables, with Start-end points, with a lockk operation)

# START A THREAD 
The simple/ basic structure to creating and starting threads
## main
Create a thread--> start the thread --> wait for other threads to finish 
## thread class
Create a thread suclass that extends Thread class --> Create Run method (what to do onnce it runs) !You do not need to call this method! it runs once you start the thread.
