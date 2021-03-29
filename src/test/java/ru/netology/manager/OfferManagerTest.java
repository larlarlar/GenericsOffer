package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;


import static org.junit.jupiter.api.Assertions.*;

public class OfferManagerTest {
    int nonexistentID = 7;
    OfferRepository repository = new OfferRepository();
    OfferManager manager = new OfferManager(repository);

    Offer fstOffer = new Offer(1, 1111, 11, "CDG", "AMS");
    Offer scndOffer = new Offer(2, 2222, 22, "CDG", "AMS");
    Offer thrdOffer = new Offer(3, 3333, 33, "MOW", "LED");
    Offer frthOffer = new Offer(4, 4444, 44, "MOW", "LED");
    Offer fthOffer = new Offer(5, 5555, 55, "LED", "AMS");
    Offer sxthOffer = new Offer(6, 6666, 66, "LED", "MOW");

    @BeforeEach
    void setup() {
        manager.add(fstOffer);
        manager.add(scndOffer);
        manager.add(thrdOffer);
        manager.add(frthOffer);
        manager.add(fthOffer);
        manager.add(sxthOffer);
    }

    @Test
    public void ShouldFindTwoOffer() {
        Offer[] expected = new Offer[]{fstOffer, scndOffer};
        Offer[] actual = manager.searchByAirports("CDG", "AMS");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindOffer() {
        Offer[] expected = new Offer[]{fthOffer};
        Offer[] actual = manager.searchByAirports("LED", "AMS");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByID() {
        Offer actual = manager.findWithID(5);
        assertEquals(fthOffer, actual);
    }

    @Test
    public void shouldNotFindByID() {
        assertNull(manager.findWithID(nonexistentID));
    }

    @Test
    public void shouldNotFindByAirport() {
            Offer[] expected = new Offer[]{};
            Offer[] actual = manager.searchByAirports("HEL", "AMS");
            assertArrayEquals(expected, actual);
    }
    }

