package DAOImpl;

import DAOInterfaces.PlainDAO;
import Entities.Airports;
import Entities.Plane;
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
            JOptionPane.showMessageDialog(null,e.getMessage(),"joihh io", JOptionPane.OK_OPTION);
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
            JOptionPane.showMessageDialog(null,e.getMessage(),"joihh io", JOptionPane.OK_OPTION);
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public List<Plane> getPlainsByRoute(Airports fromAirport, Airports toAirport) throws SQLException {
        Session session=null;
        List planes= new ArrayList<Plane>();
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            planes=session.createCriteria(Plane.class).add(Restrictions.eq("from",fromAirport)).add(Restrictions.eq("to",toAirport)).list();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"joihh io", JOptionPane.OK_OPTION);
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
            JOptionPane.showMessageDialog(null,e.getMessage(),"joihh io", JOptionPane.OK_OPTION);
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }

    }
}
