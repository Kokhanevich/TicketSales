package entities;

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
    @Column(name = "ID_Route")
    private int idRoute;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "from_airport")
    private Airports fromAirport;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "to_airport")
    private Airports toAirport;

    @Column(name = "Prise")
    private Double prise;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route")
    private List<Plane> planes=new ArrayList<>();

    @OneToMany( fetch = FetchType.LAZY, mappedBy = "route")
    private List<Ticket> ticketList=new ArrayList<>();

    public Route(){}

    public int getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute = idRoute;
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

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public Double getPrise() {
        return prise;
    }

    public void setPrise(Double prise) {
        this.prise = prise;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public String toString() {
        return "Route" +
                ": " + fromAirport +
                " - " + toAirport +
                "; prise: " + prise +
                " $";
    }
}
