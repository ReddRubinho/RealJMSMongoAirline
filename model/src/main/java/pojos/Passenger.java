package pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Document(collection = "passengers")
public class Passenger {

    @Id
    private CompositeKey passengerId;
    private String email;
    private String name;
    private String surname;
    private Integer seat;
    private List<Bagagge> baggage;

    @JsonCreator
    public Passenger(@JsonProperty("nif") String nif,
                     @JsonProperty("flighNumber") Integer flighNumber,
                     @JsonProperty("email") String email,
                     @JsonProperty("name") String name,
                     @JsonProperty("surname") String surname,
                     @JsonProperty("seat") Integer seat,
                     @JsonProperty("baggage") List<Bagagge> baggage) {

        this.passengerId = new CompositeKey(nif, flighNumber);
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.seat = seat;
        this.baggage = baggage;
    }

    public CompositeKey getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(CompositeKey passengerId) {
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

    public List<Bagagge> getBaggage() {
        return baggage;
    }

    public void setBaggage(List<Bagagge> baggage) {
        this.baggage = baggage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
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

    public static class CompositeKey implements Serializable {
        private String nif;
        private Integer flightNumber;

        @JsonCreator
        public CompositeKey(@JsonProperty("nif") String nif,
                            @JsonProperty("flightNumber") Integer flightNumber) {
            this.nif = nif;
            this.flightNumber = flightNumber;
        }

        public String getNif() {
            return nif;
        }

        public void setNif(String nif) {
            this.nif = nif;
        }

        public Integer getFlightNumber() {
            return flightNumber;
        }

        public void setFlightNumber(Integer flightNumber) {
            this.flightNumber = flightNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CompositeKey that = (CompositeKey) o;
            return Objects.equals(nif, that.nif) && Objects.equals(flightNumber, that.flightNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nif, flightNumber);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("CompositeKey{");
            sb.append("nif='").append(nif).append('\'');
            sb.append(", flightNumber=").append(flightNumber);
            sb.append('}');
            return sb.toString();
        }
    }
}
