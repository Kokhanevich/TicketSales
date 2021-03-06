package entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Seats")
public class Seat {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "seat_ID")
    private int seatId;

    @Column(name = "number")
    private int number;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Plain")
    private Plane plane;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "seat")
    private Ticket ticket;

    public Seat(){}

    public Seat(int number) {
        this.number = number;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int id) {
        this.seatId = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
}
