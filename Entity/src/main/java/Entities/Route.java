package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Routes")
public class Route {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "route_ID")
    private Long route_ID;

    @ManyToOne
    @JoinColumn(name = "From_airport")
    private Airports fromAirport;

    @ManyToOne
    @JoinColumn(name = "To_airport")
    private Airports toAirport;

   public Route(){}

    public Route(Airports fromAirport, Airports toAirport) {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
    }

    public Long getRoute_ID() {
        return route_ID;
    }

    public void setRoute_ID(Long route_ID) {
        this.route_ID = route_ID;
    }

    public Airports getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(Airports fromAirport) {
        this.fromAirport = fromAirport;
    }

    public Airports getToAirport() {
        return toAirport;
    }

    public void setToAirport(Airports toAirport) {
        this.toAirport = toAirport;
    }
}
