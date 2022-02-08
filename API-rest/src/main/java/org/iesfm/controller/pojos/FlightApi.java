package org.iesfm.controller.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.Objects;


public class FlightApi {

    private Integer flightNumber;
    private String origin;
    private String destination;
    @JsonFormat (pattern = "yyyy-MM-dd")
    private Date departure;

    @JsonCreator
    public FlightApi(@JsonProperty("flightNumber") Integer flightNumber,
                     @JsonProperty("origin") String origin,
                     @JsonProperty("destination") String destination,
                     @JsonProperty("departure") Date departure) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightApi flight = (FlightApi) o;
        return Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(origin, flight.origin) && Objects.equals(destination, flight.destination) && Objects.equals(departure, flight.departure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, origin, destination, departure);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Flight{");
        sb.append("flightNumber=").append(flightNumber);
        sb.append(", origin='").append(origin).append('\'');
        sb.append(", destination='").append(destination).append('\'');
        sb.append(", departure=").append(departure);
        sb.append('}');
        return sb.toString();
    }
}
