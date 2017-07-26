import Entities.Passengers;
import Entities.Plane;
import Entities.Route;
import Factory.Factory;
import org.json.simple.JSONArray;
import org.json.simple.JSONStreamAware;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Николай on 20.07.2017.
 */
public class AirportServlet extends APIHandlerServlet.APIRequestHandler {

    public static final AirportServlet instance= new AirportServlet();

    public static AirportServlet getInstance(){return instance;};

    private AirportServlet(){}

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        Route route=Factory.getInstanse().getRouteDAO().getRouteByName(from,to);
        List<Plane> planes= Factory.getInstanse().getGetPlainDAO().getPlainsByRoute(route);
        JSONArray jsonArray=new JSONArray();
            for (int i=0;i<planes.size();i++){
                jsonArray.add("<br>"+"<p id=\"plane\">"+planes.get(i).getPlainId()+"</p> "+planes.get(i).getName()+" "+planes.get(i).getRoute());
            }

            return jsonArray;




    }
}
