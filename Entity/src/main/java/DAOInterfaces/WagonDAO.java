package DAOInterfaces;


import Entities.Train;
import Entities.Wagon;

import java.sql.SQLException;
import java.util.List;

public interface WagonDAO {
    public void addWagon(Wagon wagon) throws SQLException;
    public void updateWagon(Wagon wagon) throws SQLException;
    public List<Wagon> getWagonsByTrain(Train train) throws SQLException;
    public void deleteWagon(Wagon wagon) throws SQLException;

}
