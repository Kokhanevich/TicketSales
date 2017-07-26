package DAOInterfaces;

import Entities.Airports;
import Entities.Route;


import java.sql.SQLException;
import java.util.List;

public interface RouteDAO {
    public void addRoute (Route route) throws SQLException;
    public void updateRoute( Route route) throws SQLException;
    public Route  getRouteByName(String fromAirport, String toAirport) throws SQLException;
    public void deleteRoute( Route route) throws SQLException;



}
