import entities.Passengers;
import factory.Factory;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

public class PassengerServlet extends APIHandlerServlet.APIRequestHandler {
    public static final PassengerServlet instance= new PassengerServlet();

    public static PassengerServlet getInstance(){return instance;};

    private PassengerServlet(){}

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        String lastName=request.getParameter("last");
        String firstName=request.getParameter("first");
        Passengers passenger=new Passengers();
        passenger.setLastName(lastName);
        passenger.setFirstName(firstName);
        Factory.getInstanse().getNamePassengersDAO().addNamePassengers(passenger);
        return null;
    }
}
