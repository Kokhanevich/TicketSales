package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Tickets")
public class Ticket {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID_Ticket")
    private Long idTicket;

    @ManyToOne
    @JoinColumn(name = "passenger")
    private Passengers passenger;


    @ManyToOne
    @JoinColumn(name = "plain_ID")
    private Plane plane;

    @OneToOne
    @JoinColumn(name = "seat_ID")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "tariff")
    private Tariff tariff;

    public Ticket(){}

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public Passengers getPassenger() {
        return passenger;
    }

    public void setPassenger(Passengers passenger) {
        this.passenger = passenger;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }
}
