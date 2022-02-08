package org.iesfm.controller.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import pojos.Passenger;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PassengerApi {

    @Id
    private CompositeKeyApi passengerId;
    private String email;
    private String name;
    private String surname;
    private Integer seat;
    private List<BagaggeApi> baggage;

    @JsonCreator
    public PassengerApi(@JsonProperty("nif") String nif,
                        @JsonProperty("flighNumber") Integer flighNumber,
                        @JsonProperty("email") String email,
                        @JsonProperty("name") String name,
                        @JsonProperty("surname") String surname,
                        @JsonProperty("seat") Integer seat,
                        @JsonProperty("baggage") List<BagaggeApi> baggage) {

        this.passengerId = new CompositeKeyApi(nif, flighNumber);
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.seat = seat;
        this.baggage = baggage;
    }

    public CompositeKeyApi getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(CompositeKeyApi passengerId) {
        this.passengerId = passengerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public List<BagaggeApi> getBaggage() {
        return baggage;
    }

    public void setBaggage(List<BagaggeApi> baggage) {
        this.baggage = baggage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerApi passenger = (PassengerApi) o;
        return Objects.equals(passengerId, passenger.passengerId) && Objects.equals(email, passenger.email) && Objects.equals(name, passenger.name) && Objects.equals(surname, passenger.surname) && Objects.equals(seat, passenger.seat) && Objects.equals(baggage, passenger.baggage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, email, name, surname, seat, baggage);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Passenger{");
        sb.append("id=").append(passengerId);
        sb.append(", email='").append(email).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", seat=").append(seat);
        sb.append(", baggage=").append(baggage);
        sb.append('}');
        return sb.toString();
    }

    public static class CompositeKeyApi extends Passenger.CompositeKey {

        @JsonCreator
        public CompositeKeyApi(@JsonProperty("nif") String nif,
                               @JsonProperty("flightNumber") Integer flightNumber) {
            super(nif, flightNumber);
        }
    }
}
