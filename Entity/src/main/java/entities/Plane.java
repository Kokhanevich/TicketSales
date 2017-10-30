package entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Plane")
public class Plane {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "plain_ID")
    private int plainId;

    @Column(name = "Name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Route")
    private Route route;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "plane")
    private List<Seat> seats = new ArrayList<>();

    @OneToMany(mappedBy = "plane", fetch = FetchType.LAZY)
    private Set<Ticket> tickets = new HashSet<>();

    public Plane() {
    }

    public int getPlainId() {
        return plainId;
    }

    public void setPlainId(int plainId) {
        this.plainId = plainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "plainId=" + plainId +
                ", name='" + name + '\'' +
                ", route=" + route +
                '}';
    }
}




