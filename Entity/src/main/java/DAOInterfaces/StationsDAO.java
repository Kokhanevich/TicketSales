package DAOInterfaces;

import Entities.Stations;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Николай on 13.07.2017.
 */
public interface StationsDAO {
    public void addStation(Stations station) throws SQLException;
    public void updateStation(Stations station) throws SQLException;
    public Stations getStationByID(int code) throws SQLException;
    public List<Stations> getStationByName(String nameStation) throws SQLException;
    public List<Stations> getAllStations() throws SQLException;
    public void deleteStation(Stations station) throws SQLException;
}
