package ru.netology.manager;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import java.util.Arrays;

public class OfferManager {
    OfferRepository repository;

    public OfferManager(OfferRepository repository) {
        this.repository = repository;
    }

    public void add(Offer item) {
        repository.save(item);
    }

    public Offer[] searchByAirports(String from, String to) {
        Offer[] result = new Offer[0];
        for (Offer item : repository.findAll()) {
            if (item.matches(from, to)) {
                Offer[] tmp = new Offer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Offer findWithID(int id) {
        return repository.findWithID(id);
    }

    public void removeByID(int id) {
        try {
            repository.removeByID(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

    }
}
