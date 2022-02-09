package ru.netology.domain;

import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
    public class Book extends Product {
        private String author;
        private int pages;
        private int publishedYear;

        public Book() {
            super();
        }

        public Book(int id, String name, int price, String author, int pages, int publishedYear) {
            super(id, name, price);
            this.author = author;
            this.pages = pages;
            this.publishedYear = publishedYear;
        }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (search.equalsIgnoreCase(author)) {
            return true;
        }
        return false;
    }
    }
