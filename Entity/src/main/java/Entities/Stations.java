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
@Table(name = "stations")
public class Stations {

    @Id
    @Column(name = "code_station")
    private int codeStation;

    @Column(name = "name_station")
    private String nameStation;

    @OneToMany(mappedBy = "firstStation")
    private List<Main_Route> firstStations= new ArrayList<>();

    @OneToMany(mappedBy = "lastStation")
    private List<Main_Route> lastStations= new ArrayList<>();

    @OneToMany(mappedBy = "fromStation")
    private List<Road> fromRoad=new ArrayList<>();

    @OneToMany(mappedBy = "toStation")
    private List<Road> toRoad=new ArrayList<>();

    @OneToMany(mappedBy = "fromStation")
    private List<Tariff> tariffsFrom= new ArrayList<>();

    @OneToMany(mappedBy = "toStation")
    private List<Tariff> tariffsTo=new ArrayList<>();

    public Stations(){nameStation=null;}

    public Stations(Stations stations){
        nameStation=stations.getNameStation();
    }


    public int getCodeStation() {
        return codeStation;
    }

    public void setCodeStation(int codeStation) {
        this.codeStation = codeStation;
    }

    public String getNameStation() {
        return nameStation;
    }

    public void setNameStation(String nameStation) {
        this.nameStation = nameStation;
    }

    public List<Tariff> getTariffsFrom() {
        return tariffsFrom;
    }

    public void setTariffsFrom(List<Tariff> tariffsFrom) {
        this.tariffsFrom = tariffsFrom;
    }

    public List<Tariff> getTariffsTo() {
        return tariffsTo;
    }

    public void setTariffsTo(List<Tariff> tariffsTo) {
        this.tariffsTo = tariffsTo;
    }

    public List<Road> getFromRoad() {
        return fromRoad;
    }

    public void setFromRoad(List<Road> fromRoad) {
        this.fromRoad = fromRoad;
    }

    public List<Road> getToRoad() {
        return toRoad;
    }

    public void setToRoad(List<Road> toRoad) {
        this.toRoad = toRoad;
    }

    @Override
    public String toString() {
        return "Stations{" +
                "codeStation=" + codeStation +
                ", nameStation='" + nameStation + '\'' +
                '}';
    }
}
