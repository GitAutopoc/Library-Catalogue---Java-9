package com.catalogue.assessment;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Catalogue {
	public static void main(String[] args) {
		LibraryCatalog catalog = new SimpleLibraryCatalog();
		catalog.addBook(new Book("1234567890", "Effective Java", "Joshua Bloch"));
		catalog.addBook(new Book("0987654321", "Java Concurrency in Practice", "Brian Goetz"));

		System.out.println("All Books:");
		catalog.listAllBooks().forEach(System.out::println);

		System.out.println("\nRemoving Book:");
		catalog.removeBook("1234567890");
		catalog.listAllBooks().forEach(System.out::println);
	}
}