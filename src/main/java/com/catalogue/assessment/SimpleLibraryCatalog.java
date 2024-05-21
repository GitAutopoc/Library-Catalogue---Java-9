package com.catalogue.assessment;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

interface LibraryCatalog {
	void addBook(Book book);

	void removeBook(String isbn);

	Book getBook(String isbn);

	Iterable<Book> listAllBooks();

	default boolean isIsbnValid(String isbn) {
		// Dummy ISBN validation
		return isbn != null && !isbn.trim().isEmpty();
	}
}

public class SimpleLibraryCatalog implements LibraryCatalog {
	private Map<String, Book> books = new HashMap<>();

	@Override
	public void addBook(Book book) {
		if (book == null || !isIsbnValid(book.getIsbn()) || books.containsKey(book.getIsbn())) {
			throw new IllegalArgumentException("Invalid book or duplicate ISBN");
		}
		books.put(book.getIsbn(), book);
	}

	@Override
	public void removeBook(String isbn) {
		if (!books.containsKey(isbn)) {
			throw new IllegalArgumentException("Book not found");
		}
		Map<String, Book> tempMap = new HashMap<>(books);
		tempMap.remove(isbn);
		books = Collections.unmodifiableMap(tempMap);
	}

	@Override
	public Book getBook(String isbn) {
		return books.get(isbn);
	}

	@Override
	public Iterable<Book> listAllBooks() {
		return Collections.unmodifiableCollection(books.values());
	}
}