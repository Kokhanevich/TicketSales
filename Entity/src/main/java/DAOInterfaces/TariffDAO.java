package DAOInterfaces;

import Entities.Stations;
import Entities.Tariff;
import Entities.TypeWagons;


import java.sql.SQLException;
import java.util.List;

public interface TariffDAO {
    public void addTariff (Tariff tariff) throws SQLException;
    public void updateTariff( Tariff tariff) throws SQLException;
    public List<Tariff> getTariffsByStation(List<Stations> fromStation, List<Stations> toStation) throws SQLException;
    public Tariff getTariff(Stations fromStation, Stations toStation, TypeWagons type) throws SQLException;
    public void deleteTariff( Tariff tariff) throws SQLException;



}
