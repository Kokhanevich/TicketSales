package Factory;

import DAOImpl.*;
import DAOInterfaces.*;

/**
 * Created by Николай on 04.07.2017.
 */
public class Factory {
    private static PassengersDAO namePassengersDAO=null;
    private static SeatsDAO getSeatDAO=null;
    private static StationsDAO getStationDAO=null;
    private static TariffDAO getTariffDAO=null;
    private static TicketDAO getTicketDAO=null;
    private static TrainDAO getTrainDAO=null;
    private static TypeWagons getTypeDAO=null;
    private static WagonDAO getWagonDAO=null;
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

    public StationsDAO getStationDAO(){
        if (getStationDAO==null){
            getStationDAO=new StationsDAOImpl();
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

    public TrainDAO getTrainDAO(){
        if (getTrainDAO==null){
            getTrainDAO=new TrainDAOImpl();
        }
        return getTrainDAO;
    }

    public TypeWagons getTypeDAO(){
        if (getTypeDAO==null){
            getTypeDAO=new TypeWagonsDAOImpl();
        }
        return getTypeDAO;
    }

    public WagonDAO getWagonDAO(){
        if (getWagonDAO==null){
            getWagonDAO=new WagonDAOImpl();
        }
        return getWagonDAO;
    }

}
