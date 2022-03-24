package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;


import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    private ProductRepository repository = new ProductRepository();
    Manager manager = new Manager(repository);

    private Product first = new Book(1, "Мастер и Маргарита", 250, "Булгаков", 450, 1882);
    private Product second = new TShirt(2, "one", 300, "red", "L");
    private Product third = new Book(3, "Удушье", 200, "Чак Паланик", 400, 1995);
    private Product fourth = new TShirt(4, "one", 300, "blue", "S");
    private Product fifth = new Book(5, "Понедельник начинается в субботу", 450, "Стругацкие", 150, 1985);
    private Product sixth = new Book(3, "Проклятые", 200, "Чак Паланик", 250, 2012);


    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    public void shouldFindAuthor() {
        Product[] expected = {fifth};
        Product[] actual = manager.searchBy("Стругацкие");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNameBook() {
        Product[] expected = {third};
        Product[] actual = manager.searchBy("Удушье");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindColor() {
        Product[] expected = {second};
        Product[] actual = manager.searchBy("red");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSize() {
        Product[] expected = {fourth};
        Product[] actual = manager.searchBy("S");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Фет");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTwoBooks() {
        Product[] expected = {third, sixth};
        Product[] actual = manager.searchBy("Чак Паланик");
        assertArrayEquals(expected, actual);
    }
}