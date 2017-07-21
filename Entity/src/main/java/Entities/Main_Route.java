package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Main_route")
public class Main_Route {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "train_ID")
    private Long id;

    @OneToMany(mappedBy = "mainRoute")
    private List<Route> routes=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "Main_first_station")
    private Stations firstStation;

    @ManyToOne
    @JoinColumn(name = "Main_last_station")
    private Stations lastStation;

    public Main_Route(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Stations getFirstStation() {
        return firstStation;
    }

    public void setFirstStation(Stations firstStation) {
        this.firstStation = firstStation;
    }

    public Stations getLastStation() {
        return lastStation;
    }

    public void setLastStation(Stations lastStation) {
        this.lastStation = lastStation;
    }
}
