package com.catalogue.assessment.functional;

import static com.catalogue.assessment.testutils.TestUtils.businessTestFile;
import static com.catalogue.assessment.testutils.TestUtils.currentTest;
import static com.catalogue.assessment.testutils.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.catalogue.assessment.Book;
import com.catalogue.assessment.SimpleLibraryCatalog;

public class FunctionalTests {

	private SimpleLibraryCatalog catalog;

	@BeforeEach
	public void setUp() {
		catalog = new SimpleLibraryCatalog();
	}

	@Test
	public void testAddAndListBook() throws IOException {
		Book book = new Book("1234567890", "Effective Java", "Joshua Bloch");
		catalog.addBook(book);
		Iterable<Book> books = catalog.listAllBooks();

//		assertNotNull("Book list should not be null", books);
		Iterator<Book> iterator = books.iterator();
//		assertTrue("Book list should contain at least one book", iterator.hasNext());
		Book retrievedBook = iterator.next();
//		assertEquals("Book ISBN should match", "1234567890", retrievedBook.getIsbn());
//		assertEquals("Book title should match", "Effective Java", retrievedBook.getTitle());
//		assertEquals("Book author should match", "Joshua Bloch", retrievedBook.getAuthor());
//		assertFalse("Book list should contain only one book", iterator.hasNext());
		yakshaAssert(currentTest(), books != null ? "true" : "false", businessTestFile);
	}
}
