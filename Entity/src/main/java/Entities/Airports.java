package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Николай on 04.07.2017.
 */
@Entity
@Table(name = "Airports")
public class Airports {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "code_airport")
    private int codeAirport;

    @Column(name = "name_airport")
    private String nameAirport;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fromAirport")
    private List<Route> firstAirport= new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "toAirport")
    private List<Route> lastStations= new ArrayList<>();




    public Airports(){nameAirport=null;}

    public Airports(Airports stations){
        nameAirport=stations.getNameStation();
    }

    public int getCodeAirport() {
        return codeAirport;
    }

    public void setCodeAirport(int codeAirport) {
        this.codeAirport = codeAirport;
    }

    public String getNameStation() {
        return nameAirport;
    }

    public void setNameStation(String nameStation) {
        this.nameAirport = nameAirport;
    }

    public List<Route> getFirstAirport() {
        return firstAirport;
    }

    public void setFirstAirport(List<Route> firstAirport) {
        this.firstAirport = firstAirport;
    }

    public List<Route> getLastStations() {
        return lastStations;
    }

    public void setLastStations(List<Route> lastStations) {
        this.lastStations = lastStations;
    }


}
