package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Routes")
public class Route {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "route_ID")
    private Long route_ID;

    @ManyToOne
    @JoinColumn(name = "Main_route")
    private Main_Route mainRoute;

    @ManyToOne
    @JoinColumn(name = "Road")
    private Road road;

    @Column(name = "Position")
    private int position;


    @OneToMany(mappedBy = "route")
    private List<Train> trains= new ArrayList<>();

    public Route() {}

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }
}
