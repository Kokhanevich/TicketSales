package daoInterfaces;


import entities.Passengers;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Николай on 04.07.2017.
 */
public interface PassengersDAO {
    public void addNamePassengers(Passengers namePassengers) throws SQLException;
    public void updateNamePassengers(Passengers namePassengers) throws SQLException;
    public Passengers getPassengerByLastName(String lastName) throws SQLException;
    public Passengers getPassengerByFirstName(String firstName) throws SQLException;
    public List<Passengers> getAllPassengers() throws SQLException;
    public void deletePassenger(Passengers namePassengers) throws SQLException;

}
