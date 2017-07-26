package DAOImpl;

import DAOInterfaces.AirportsDAO;
import Entities.Airports;
import Factory.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Николай on 16.07.2017.
 */
public class AirportsDAOImpl implements AirportsDAO {
    @Override
    public void addAirport(Airports airports) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(airports);
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void updateAirport(Airports airports) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(airports);
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }

    }

    @Override
    public Airports getAirportByID(int code) throws SQLException {
        Session session=null;
        Airports station=null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            station=(Airports) session.get(Airports.class, code);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return station;
    }

    @Override
    public List<Airports> getAirportByName(String nameAirport) throws SQLException {
        List airports= new ArrayList<Airports>();
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            airports=session.createCriteria(Airports.class).add(Restrictions.eq("nameStation", nameAirport)).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return airports;


    }

    @Override
    public List<Airports> getAllAirports() throws SQLException {
        Session session=null;
        List stations= new ArrayList<Airports>();
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            stations= session.createCriteria(Airports.class).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }

        return stations;
    }

    @Override
    public void deleteAirport(Airports station) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(station);
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }

    }
}
