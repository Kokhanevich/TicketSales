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
        String from=request.getParameter("from");

        return null;
    }
}
