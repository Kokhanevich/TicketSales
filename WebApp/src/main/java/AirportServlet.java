import entities.Plane;
import entities.Route;
import factory.Factory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Николай on 20.07.2017.
 */
public class AirportServlet extends APIHandlerServlet.APIRequestHandler {

    public static final AirportServlet instance = new AirportServlet();

    public static AirportServlet getInstance() {
        return instance;
    }

    ;

    private AirportServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        Route route = Factory.getInstanse().getRouteDAO().getRouteByName(from, to);
        List<Plane> planes = Factory.getInstanse().getGetPlainDAO().getPlainsByRoute(route);
        JSONArray jsonArray = new JSONArray();

        for (int i=0;i<planes.size();i++){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("planeId",planes.get(i).getPlainId());
            jsonObject.put("planeRoute",planes.get(i).getRoute());
            jsonArray.add(jsonObject);
        }



        return jsonArray;

    }
}
