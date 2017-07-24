package Factory;

import DAOImpl.*;
import DAOInterfaces.*;

/**
 * Created by Николай on 04.07.2017.
 */
public class Factory {
    private static PassengersDAO namePassengersDAO=null;
    private static SeatsDAO getSeatDAO=null;
    private static AirportsDAO getAirportDAO=null;
    private static RouteDAO getRouteDAO =null;
    private static TicketDAO getTicketDAO=null;
    private static PlainDAO getPlainDAO=null;
    private static Factory instanse=null;
     public static synchronized Factory getInstanse(){
         if (instanse==null){
             instanse= new Factory();
         }
         return instanse;
     }

     public PassengersDAO getNamePassengersDAO(){
         if (namePassengersDAO==null){
             namePassengersDAO=new PassengersDAOImpl();
         }
         return namePassengersDAO;
     }

    public SeatsDAO getSeatDAO(){
        if (getSeatDAO==null){
            getSeatDAO=new SeatsDAOImpl();
        }
        return getSeatDAO;
    }

    public AirportsDAO getAirportDAO(){
        if (getAirportDAO==null){
            getAirportDAO=new AirportsDAOImpl();
        }
        return getAirportDAO;
    }

    public RouteDAO getGetRouteDAO(){
        if (getRouteDAO ==null){
            getRouteDAO = new RouteDAOImpl();
        }
        return getRouteDAO;
    }

    public TicketDAO getTicketDAO(){
        if (getTicketDAO==null){
            getTicketDAO=new TicketDAOImpl();
        }
        return getTicketDAO;
    }

    public PlainDAO getGetPlainDAO(){
        if (getPlainDAO==null){
            getPlainDAO=new PlainDAOImpl();
        }
        return getPlainDAO;
    }



}
