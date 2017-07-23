package Factory;

import DAOImpl.*;
import DAOInterfaces.*;

/**
 * Created by Николай on 04.07.2017.
 */
public class Factory {
    private static PassengersDAO namePassengersDAO=null;
    private static SeatsDAO getSeatDAO=null;
    private static AirportsDAO getStationDAO=null;
    private static TariffDAO getTariffDAO=null;
    private static TicketDAO getTicketDAO=null;
    private static PlainDAO getTrainDAO=null;
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

    public AirportsDAO getStationDAO(){
        if (getStationDAO==null){
            getStationDAO=new AirportsDAOImpl();
        }
        return getStationDAO;
    }

    public TariffDAO gettariffDAO(){
        if (getTariffDAO==null){
            getTariffDAO= new TariffDAOImpl();
        }
        return getTariffDAO;
    }

    public TicketDAO getTicketDAO(){
        if (getTicketDAO==null){
            getTicketDAO=new TicketDAOImpl();
        }
        return getTicketDAO;
    }

    public PlainDAO getTrainDAO(){
        if (getTrainDAO==null){
            getTrainDAO=new PlainDAOImpl();
        }
        return getTrainDAO;
    }



}
