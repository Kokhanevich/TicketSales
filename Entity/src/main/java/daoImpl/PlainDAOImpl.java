package daoImpl;

import daoInterfaces.PlainDAO;
import entities.Plane;
import entities.Route;
import factory.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Николай on 16.07.2017.
 */
public class PlainDAOImpl implements PlainDAO {
    @Override
    public void addPlain(Plane plane) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(plane);
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
    public void updatePlain(Plane plane) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(plane);
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
    public Plane getPlaneById(int id) {
        Session session=null;
        Plane plane=null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            plane=(Plane) session.get(Plane.class, id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return plane;
    }

    @Override
    public List<Plane> getPlainsByRoute(Route route) throws SQLException {
        Session session=null;
        List planes= new ArrayList<Plane>();
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            planes=session.createCriteria(Plane.class).add(Restrictions.eq("route",route)).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return planes;
    }

    @Override
    public void deletePlain(Plane plane) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(plane);
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
