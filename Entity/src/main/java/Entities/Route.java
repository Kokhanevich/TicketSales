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
    @Column(name = "ID_Route")
    private Long idRoute;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "from_airport")
    private Airports fromAirport;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "to_airport")
    private Airports toAirport;

    @Column(name = "Prise")
    private Double prise;



    @OneToMany( fetch = FetchType.LAZY, mappedBy = "route")
    private List<Ticket> ticketList=new ArrayList<>();

    public Route(){}

    public Long getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Long idRoute) {
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
}
