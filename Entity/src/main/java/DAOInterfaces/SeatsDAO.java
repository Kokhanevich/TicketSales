package DAOInterfaces;

import Entities.Seat;
import Entities.Wagon;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Николай on 13.07.2017.
 */
public interface SeatsDAO {
    public void addSeat (Seat seat) throws SQLException;
    public  void updateSeat (Seat seat) throws SQLException;
    public List<Seat> getSeatsByWagon (Wagon wagon) throws SQLException;
    public void deleteSeat(Seat seat) throws SQLException;
}
