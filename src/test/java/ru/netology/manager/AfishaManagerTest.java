package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.*;

public class AfishaManagerTest {

    private AfishaManager manager = new AfishaManager();
    private PurchaseItem first = new PurchaseItem(1, 1, "Bloodshot", "Action", "Url1");
    private PurchaseItem second = new PurchaseItem(2, 2, "Forward", "Cartoon", "Url2");
    private PurchaseItem third = new PurchaseItem(3, 3, "HotelBelgrad", "Comedy", "Url3");
    private PurchaseItem fourth = new PurchaseItem(4, 4, "Gentelmens", "Action", "Url4");
    private PurchaseItem fifth = new PurchaseItem(5, 5, "The invisible man", "Horror", "Url5");
    private PurchaseItem sixth = new PurchaseItem(6, 6, "Trolls", "Cartoon", "Url6");
    private PurchaseItem seventh = new PurchaseItem(7, 7, "Number 1", "Comedy", "Url7");
    private PurchaseItem eighth = new PurchaseItem(8, 8, "Pinocchio", "Fantasy", "Url8");
    private PurchaseItem ninth = new PurchaseItem(9, 9, "Bad boys", "Action", "Url9");
    private PurchaseItem tenth = new PurchaseItem(10, 10, "Lighthouse", "Horror", "Url10");
    private PurchaseItem eleventh = new PurchaseItem(11, 11, "Just Mercy", "Drama", "Url11");
    private PurchaseItem twelveth = new PurchaseItem(12, 12, "Fairy", "Fantasy", "Url12");


    @BeforeEach
    void manageAdd() {

        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);

    }

    @Test
    public void shouldGet10LastFilms() {
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        manager.addFilm(twelveth);
        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{twelveth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGet5LastFilms() {
        AfishaManager manager = new AfishaManager(5);
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetFilmsMoreThan10() {
        AfishaManager manager = new AfishaManager(11);
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        manager.addFilm(twelveth);
        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{twelveth,eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetFilms0() {
        AfishaManager manager = new AfishaManager(0);
        manager.addFilm(first);
        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetFilmsLessThan10() {

        PurchaseItem[] actual = manager.getFilm();
        PurchaseItem[] expected = new PurchaseItem[]{eighth, seventh, sixth, fifth, fourth, third, second, first};


        assertArrayEquals(expected, actual);
    }
}
