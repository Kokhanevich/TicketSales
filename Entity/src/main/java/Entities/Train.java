package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Train")
public class Train {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "train_ID")
    private long trainId;

    @Column(name = "train_number", length = 10)
    private int number;

    @OneToMany(mappedBy = "train")
    private List<Wagon> wagonsList;

    @OneToMany(mappedBy = "train")
    private List<Ticket> ticketList;

    @ManyToOne
    @JoinColumn(name = "route_ID")
    private Route route;

    public Train(){}

    public Train(List<Wagon> wagonsList) {
        this.wagonsList = wagonsList;
    }

    public long getTrainId() {
        return trainId;
    }

    public void setTrainId(long trainId) {
        this.trainId = trainId;
    }

    public List<Wagon> getWagonsList() {
        return wagonsList;
    }

    public void setWagonsList(List<Wagon> wagonsList) {
        this.wagonsList = wagonsList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
