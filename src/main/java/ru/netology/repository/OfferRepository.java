package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Offer;

public class OfferRepository {
    Offer[] offers = new Offer[0];

    public void save(Offer item) {
        int length = offers.length + 1;
        Offer[] tmp = new Offer[length];
        System.arraycopy(offers, 0, tmp, 0, offers.length);;
        int lastIndex = tmp.length -1;
        tmp[lastIndex] = item;
        offers = tmp;
    }

    public Offer[] findAll() { return offers; }

    public Offer findWithID(int id) {
        for (Offer item : offers) {
            if (item.id() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeByID(int id) throws NotFoundException {
        if (findWithID(id) != null) {
            int length = offers.length - 1;
            Offer[] tmp = new Offer[length];
            int index = 0;
            for (Offer item : offers) {
                if (item.id() != id) {
                    tmp[index] = item;
                    index++;
                }
                offers = tmp;
            }
        } else {
            throw new NotFoundException("Element with ID " + id + " not found");
        }
    }
}
