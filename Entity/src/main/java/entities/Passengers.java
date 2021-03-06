package entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Николай on 04.07.2017.
 */
@Entity
@Table(name = "passengers")
@Access(AccessType.FIELD)
public class Passengers {

    @Id
    @GeneratedValue (generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private int userId;

    @Column(name = "Last_name", length = 40)
    private String lastName;

    @Column(name = "First_name", length = 40)
    private String firstName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "passenger")
    private List<Ticket> ticketList= new ArrayList<>();


    public Passengers(){}

    public Passengers(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
