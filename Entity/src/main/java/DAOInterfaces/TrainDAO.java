package DAOInterfaces;

import Entities.Route;
import Entities.Stations;
import Entities.Train;

import java.sql.SQLException;
import java.util.List;

public interface TrainDAO {
    public void addTrain(Train train) throws SQLException;
    public void updateTrain (Train train) throws SQLException;
    public List<Train> getTrainsByRoute(Stations fromStation, Stations toStation) throws SQLException;
    public void deleteTrain( Train train) throws SQLException;


}
