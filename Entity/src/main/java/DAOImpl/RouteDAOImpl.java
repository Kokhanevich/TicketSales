package DAOImpl;

import DAOInterfaces.RouteDAO;
import Entities.Airports;
import Entities.Route;
import Factory.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by Николай on 16.07.2017.
 */
public class RouteDAOImpl implements RouteDAO {
    @Override
    public void addRoute(Route route) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(route);
            session.getTransaction().commit();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"joihh io", JOptionPane.OK_OPTION);
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void updateRoute(Route route) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(route);
            session.getTransaction().commit();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"joihh io", JOptionPane.OK_OPTION);
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }

    }


    @Override
    public Route getRoute(Airports fromAirport, Airports toAirport) throws SQLException {
        Session session=null;
        Route route =null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            Query query =session.createQuery("FROM Route WHERE fromAirport =:paramFrom AND toAirport=:paramTo");
            query.setParameter("paramFrom", fromAirport);
            query.setParameter("paramTo", toAirport);
            route =(Route) query.getSingleResult();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"joihh io", JOptionPane.OK_OPTION);
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return route;

    }

    @Override
    public void deleteRoute(Route route) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(route);
            session.getTransaction().commit();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"joihh io", JOptionPane.OK_OPTION);
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }

    }
}
