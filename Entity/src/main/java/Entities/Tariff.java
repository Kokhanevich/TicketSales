package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tariff")
public class Tariff {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID_Tariff")
    private Long idTariff;

    @ManyToOne()
    @JoinColumn(name = "from_station")
    private Stations fromStation;

    @ManyToOne
    @JoinColumn(name = "to_station")
    private Stations toStation;

    @Column(name = "Prise")
    private Double prise;

    @ManyToOne
    @JoinColumn(name = "type_ID")
    private TypeWagons typeWagon;

    @OneToMany(mappedBy = "tariff")
    private List<Ticket> ticketList=new ArrayList<>();

    public Tariff(){}

    public Long getIdTariff() {
        return idTariff;
    }

    public void setIdTariff(Long idTariff) {
        this.idTariff = idTariff;
    }

    public Stations getFromStation() {
        return fromStation;
    }

    public void setFromStation(Stations fromStation) {
        this.fromStation = fromStation;
    }

    public Stations getToStation() {
        return toStation;
    }

    public void setToStation(Stations toStation) {
        this.toStation = toStation;
    }

    public Double getPrise() {
        return prise;
    }

    public void setPrise(Double prise) {
        this.prise = prise;
    }

    public TypeWagons getTypeWagon() {
        return typeWagon;
    }

    public void setTypeWagon(TypeWagons typeWagon) {
        this.typeWagon = typeWagon;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
