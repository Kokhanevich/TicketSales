package DAOInterfaces;

import Entities.Airports;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Николай on 13.07.2017.
 */
public interface AirportsDAO {
    public void addAirport(Airports airports) throws SQLException;
    public void updateAirport(Airports airports) throws SQLException;
    public Airports getAirportByID(int code) throws SQLException;
    public List<Airports> getAirportByName(String nameAirport) throws SQLException;
    public List<Airports> getAllAirports() throws SQLException;
    public void deleteAirport(Airports airports) throws SQLException;
}
