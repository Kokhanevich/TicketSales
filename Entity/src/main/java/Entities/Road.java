package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Roads")
public class Road {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "road_ID")
    Long id;


     @ManyToOne
     @JoinColumn(name = "From_station")
     Stations fromStation;


      @ManyToOne
      @JoinColumn(name = "To_station")
      Stations toStation;

      @OneToMany(mappedBy = "road")
      private List<Route> routes=new ArrayList<>();

    public Road(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
