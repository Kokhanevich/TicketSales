import entities.Plane;
import entities.Route;
import factory.Factory;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        Route route=Factory.getInstanse().getRouteDAO().getRouteByName("Токио","Лондон");
        List<Plane> planes= Factory.getInstanse().getGetPlainDAO().getPlainsByRoute(route);

        for (int i=0;i<planes.size();i++){
            System.out.println(planes.get(i).getName()+" "+planes.get(i).getRoute());
        }



    }
}
