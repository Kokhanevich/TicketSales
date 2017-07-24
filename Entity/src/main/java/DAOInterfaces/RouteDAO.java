package DAOInterfaces;

import Entities.Airports;
import Entities.Route;


import java.sql.SQLException;

public interface RouteDAO {
    public void addRoute (Route route) throws SQLException;
    public void updateRoute( Route route) throws SQLException;
    public Route getRoute(Airports fromStation, Airports toStation) throws SQLException;
    public void deleteRoute( Route route) throws SQLException;



}
