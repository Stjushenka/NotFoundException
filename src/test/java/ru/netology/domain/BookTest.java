package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book book = new Book(1, "Мастер и Маргарита", 250, "Булгаков", 450, 1882);

    @Test
    public void shouldMatchByName() {
        String match = "Мастер и Маргарита";

        assertTrue(book.matches(match));
    }

    @Test
    public void shouldMatchByAuthor() {
        String match = "Булгаков";

        assertTrue(book.matches(match));
    }

    @Test
    public void shouldFalseByAuthor() {
        String match = "Толстой";

        assertFalse(book.matches(match));
    }

    @Test
    public void shouldCompareFalseName(){
        String text = "Удушье";
        assertFalse(book.matches(text));
    }

}