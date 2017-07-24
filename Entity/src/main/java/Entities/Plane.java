package Entities;

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
    private long plainId;

    @Column(name = "Name")
    private String name;



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "plane")
    private List<Seat> seats=new ArrayList<>();

    @OneToMany(mappedBy = "plane", fetch = FetchType.LAZY)
    private Set<Ticket> tickets= new HashSet<>();

    public Plane(){}

    public long getPlainId() {
        return plainId;
    }

    public void setPlainId(long plainId) {
        this.plainId = plainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}




