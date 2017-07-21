import Entities.Passengers;
import Factory.Factory;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        List<Passengers> passengers=Factory.getInstanse().getNamePassengersDAO().getAllPassengers();
        System.out.println(passengers);
    }
}
