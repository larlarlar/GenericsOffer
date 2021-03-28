package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter

public class Offer implements Comparable<Offer> {
    int id;
    int price;
    int time;
    String departureAirport;
    String arrivalAirport;

    public boolean matches(String from, String to) {
        return this.departureAirport().equalsIgnoreCase(from) && this.arrivalAirport().equalsIgnoreCase(to);
    }

    private String arrivalAirport() {
        return this.arrivalAirport;
    }

    private String departureAirport() {
        return this.departureAirport;
    }

    @Override
    public int compareTo(Offer o) {
        return price - o.price;
    }

    public int id() {
        return this.id;
    }
}
