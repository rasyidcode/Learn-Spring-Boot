package queue_example;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	
	public static void main(String[] args) {
		System.out.println("Queue Example!");
		System.out.println("================");
		System.out.println();
		System.out.println();

		//-- Customer service handle customer calls
		// create a queue to hold the calls
		Queue<String> callQueue = new LinkedList<>();

		// add calls to the queue
		callQueue.add("Customer 1");
		callQueue.add("Customer 2");
		callQueue.add("Customer 3");
		callQueue.add("Customer 4");

		// process the call
		while(!callQueue.isEmpty()) {
			// peek at the next task in the queue
			String nextCall = callQueue.peek();
			System.out.println("Handling calls for " + nextCall);

			// remove the call from queue
			callQueue.poll();
		}

		System.out.println("All calls is handled.");
	}

}
