package java_collection_framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello, World!");

		//-- Collection
		Collection<String> fruits = new ArrayList<>();
		fruits.add("Banana");
		fruits.add("Apple");
		fruits.add("Apple");
		fruits.add("Cherry");

		for (String fruit : fruits) {
			System.out.println(fruit);
		}

		//-- Immutable List
		List<String> heroes = new ArrayList<>();
		heroes.add("Axe");
		heroes.add("Invoker");
		heroes.add("Dragon Knight");
		List<String> immutableHeroes = Collections.unmodifiableList(heroes);
		// immutableHeroes.add("Creep"); error, UnsupprtedOperationException

		System.out.println(immutableHeroes);

		//-- Immutable List with new Factory methods introduced in Java 9
		List<String> movies = List.of("Avengers", "Transformers", "The Big Bang Theory");
		// movies.add("Spongebob Squarepants");
		System.out.println(movies);

		//-- Collection method
		List<String> books = new ArrayList<>();
		//-- add element
		books.add("Time Riders");
		books.add("Time Riders: The Day of Predator");
		books.add("Time Riders: The Doomsday Code");
		System.out.println(books);
		//-- remove element at specific index
		books.remove(1);
		System.out.println(books);
		//-- remove the first element
		books.removeFirst();
		System.out.println(books);
		//-- remove the last element
		books.removeLast();
		System.out.println(books);

		//-- Stream
		List<String> cars = List.of("BMW", "Toyota", "Avanza", "McLauren");
		System.out.println(cars.stream());
		cars.stream()
			.map(car -> "Mobil " + car)
			.forEach(System.out::println);

		List<String> animals = List.of("Dog", "Cat", "Cow", "Snake", "Ant", "Goat");
		String searchAnimal = "Cat";
		Optional<String> cat = animals
			.stream()
			.filter(animal -> animal == searchAnimal)
			.findFirst();
		System.out.println(cat.orElse("No " + searchAnimal));

		//-- FIFO (First-In-First-Out)
	}

}
