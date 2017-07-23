package DAOInterfaces;

import Entities.Airports;
import Entities.Tariff;


import java.sql.SQLException;
import java.util.List;

public interface TariffDAO {
    public void addTariff (Tariff tariff) throws SQLException;
    public void updateTariff( Tariff tariff) throws SQLException;
    public List<Tariff> getTariffsByStation(List<Airports> fromStation, List<Airports> toStation) throws SQLException;
    public Tariff getTariff(Airports fromStation, Airports toStation) throws SQLException;
    public void deleteTariff( Tariff tariff) throws SQLException;



}
