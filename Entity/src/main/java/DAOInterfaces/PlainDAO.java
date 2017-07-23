package DAOInterfaces;

import Entities.Airports;
import Entities.Plane;

import java.sql.SQLException;
import java.util.List;

public interface PlainDAO {
    public void addPlain(Plane plane) throws SQLException;
    public void updatePlain (Plane plane) throws SQLException;
    public List<Plane> getPlainsByRoute(Airports fromAipors, Airports toAirport) throws SQLException;
    public void deletePlain( Plane train) throws SQLException;


}
