package DAOInterfaces;

import Entities.Airports;
import Entities.Plane;
import Entities.Route;

import java.sql.SQLException;
import java.util.List;

public interface PlainDAO {
    public void addPlain(Plane plane) throws SQLException;
    public void updatePlain (Plane plane) throws SQLException;
    public Plane getPlaneById(int id);
    public List<Plane> getPlainsByRoute(Route route) throws SQLException;
    public void deletePlain( Plane train) throws SQLException;


}
