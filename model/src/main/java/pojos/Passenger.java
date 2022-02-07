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
    private CompositeKey id;
    private String email;
    private String name;
    private String surname;
    private Integer seat;
    private List<Bagagge> baggage;

    static class CompositeKey implements Serializable {
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

    @JsonCreator
    public Passenger(@JsonProperty("nif") String nif,
                     @JsonProperty("flighNumber") Integer flighNumber,
                     @JsonProperty("email") String email,
                     @JsonProperty("name") String name,
                     @JsonProperty("surname") String surname,
                     @JsonProperty("seat") Integer seat,
                     @JsonProperty("baggage") List<Bagagge> baggage) {

        this.id = new CompositeKey(nif, flighNumber);
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.seat = seat;
        this.baggage = baggage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(id, passenger.id) && Objects.equals(email, passenger.email) && Objects.equals(name, passenger.name) && Objects.equals(surname, passenger.surname) && Objects.equals(seat, passenger.seat) && Objects.equals(baggage, passenger.baggage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, surname, seat, baggage);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Passenger{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", seat=").append(seat);
        sb.append(", baggage=").append(baggage);
        sb.append('}');
        return sb.toString();
    }
}
