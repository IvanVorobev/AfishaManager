package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository;
    PurchaseItem first = new PurchaseItem(1, 1, "Bloodshot", "Action", "Url1");
    PurchaseItem second = new PurchaseItem(2, 2, "Forward", "Cartoon", "Url2");
    PurchaseItem third = new PurchaseItem(3, 3, "HotelBelgrad", "Comedy", "Url3");
    PurchaseItem fourth = new PurchaseItem(4, 4, "Gentelmens", "Action", "Url4");
    PurchaseItem fifth = new PurchaseItem(5, 5, "The invisible man", "Horror", "Url5");
    PurchaseItem sixth = new PurchaseItem(6, 6, "Trolls", "Cartoon", "Url6");
    PurchaseItem seventh = new PurchaseItem(7, 7, "Number 1", "Comedy", "Url7");
    PurchaseItem eighth = new PurchaseItem(8, 8, "Pinocchio", "Fantasy", "Url8");
    PurchaseItem ninth = new PurchaseItem(9, 9, "Bad boys", "Action", "Url9");
    PurchaseItem tenth = new PurchaseItem(10, 10, "Lighthouse", "Horror", "Url10");

    @BeforeEach
    void manageAdd() {
        repository = new AfishaRepository();
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
    }

    @Test
    void shouldSave() {
        PurchaseItem eleventh = new PurchaseItem(11, 11, "Just Mercy", "Drama", "Url11");
        repository.save(eleventh);

        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {

        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(1);

        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        PurchaseItem actual = repository.findById(6);

        assertEquals(sixth, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();

        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[0];

        assertArrayEquals(expected, actual);
    }
}