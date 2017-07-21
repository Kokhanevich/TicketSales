package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Wagon")
//@Access(AccessType.FIELD)
public class  Wagon {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "wag_ID")
    private long wagId;

    @ManyToOne
    @JoinColumn(name = "type_ID")
    private TypeWagons type;

    @ManyToOne
    @JoinColumn(name = "train_ID")
    private Train train;

    @OneToMany(mappedBy = "wagon")
    private List<Seat> seats=new ArrayList<>();

    @OneToMany(mappedBy = "wagon", fetch = FetchType.LAZY)
    private Set<Ticket> tickets= new HashSet<>();

    public Wagon(){}

    public Wagon(long wagId, TypeWagons type, Set<Ticket> tickets) {
        this.wagId = wagId;
        this.type = type;
        this.tickets = tickets;
    }


    public long getWagId() {
        return wagId;
    }

    public void setWagId(long wagId) {
        this.wagId = wagId;
    }

    public TypeWagons getType() {
        return type;
    }

    public void setType(TypeWagons type) {
        this.type = type;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
