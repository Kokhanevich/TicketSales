package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Type_wagons")
public class TypeWagons {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "type_ID")
    private Long typeID;

    @Column(name = "type", length = 30)
    private String type;

    @OneToMany(mappedBy = "type")
    private List<Wagon> wagons;

    @OneToMany(mappedBy = "typeWagon")
    private List<Tariff> tariffList;

    public TypeWagons(){}

    public TypeWagons(String type) {
        this.type = type;
    }

    public Long getTypeID() {
        return typeID;
    }

    public void setTypeID(Long typeID) {
        this.typeID = typeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }

    public List<Tariff> getTariffList() {
        return tariffList;
    }

    public void setTariffList(List<Tariff> tariffList) {
        this.tariffList = tariffList;
    }
}
