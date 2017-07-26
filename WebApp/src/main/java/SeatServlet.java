import Entities.Plane;
import Entities.Seat;
import Factory.Factory;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SeatServlet extends APIHandlerServlet.APIRequestHandler {
    public static final SeatServlet instance= new SeatServlet();
    public static SeatServlet getInstance(){return instance;}

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
     String planeId= request.getParameter("plane");
     int planeID=Integer.parseInt(planeId);
     Plane plane=Factory.getInstanse().getGetPlainDAO().getPlaneById(planeID);
     List<Seat> seats=Factory.getInstanse().getSeatDAO().getSeatsByPlane(plane);

        JSONArray jsonArray= new JSONArray();

        for (int i=0;i<seats.size();i++){
            jsonArray.add(seats.get(i).getNumber());
        }

       return jsonArray;
    }
}
