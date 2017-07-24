import Entities.Passengers;
import Factory.Factory;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Николай on 20.07.2017.
 */
public class StationServlet extends APIHandlerServlet.APIRequestHandler {

    public static final StationServlet instance= new StationServlet();

    public static StationServlet getInstance(){return instance;};

    private StationServlet(){}

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        String last=request.getParameter("last");
        String first=request.getParameter("first");
        Passengers passengers =new Passengers();
        passengers.setLastName(last);
        passengers.setFirstName(first);
        Factory.getInstanse().getNamePassengersDAO().addNamePassengers(passengers);

        return null;
    }
}
