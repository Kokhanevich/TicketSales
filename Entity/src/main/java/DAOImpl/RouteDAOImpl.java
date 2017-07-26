package DAOImpl;

import DAOInterfaces.RouteDAO;
import Entities.Airports;
import Entities.Route;
import Factory.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            e.printStackTrace();
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
            e.printStackTrace();
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }

    }

    @Override
    public Route getRouteByName(String fromAirport, String toAirport) throws SQLException {
        Session session=null;
        Route route=null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();

            Query query1=session.createQuery(" FROM Airports WHERE nameAirport=:paramNameFrom");
            query1.setParameter("paramNameFrom",fromAirport);
           Airports codeFrom= (Airports) query1.getSingleResult();

            Query query2=session.createQuery(" FROM Airports WHERE nameAirport=:paramNameTo");
            query2.setParameter("paramNameTo",toAirport);
            Airports codeTo= (Airports) query2.getSingleResult();

            Query query =session.createQuery("FROM Route WHERE fromAirport =:paramFrom AND toAirport=:paramTo");
            query.setParameter("paramFrom",codeFrom);
            query.setParameter("paramTo", codeTo);
            route =(Route) query.getSingleResult();
        }
        catch (Exception e){
            e.printStackTrace();
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
            e.printStackTrace();
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }

    }
}
