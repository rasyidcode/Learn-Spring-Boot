package queue_example;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerServiceQueue {

	public static void main(String[] args) {
		// Create a queue to represent customers waiting for the service
		Queue<String> customerQueue = new LinkedList<>();

		// Customer call and are added to the queue
		customerQueue.add("Customer 1");
		customerQueue.add("Customer 2");
		customerQueue.add("Customer 3");

		// Service agents handle the calls
		while (!customerQueue.isEmpty()) {
			// Inspect the next customer in the queue
			String customer = customerQueue.peek();
			System.out.println("Handling " + customer);

			// Simulate customer service
			// (In a real application, there would be more logic here)

			// Remove the customer from the queue after service is complete
			customerQueue.poll();
		}

		System.out.println("All customers have been helped.");
	}

}
