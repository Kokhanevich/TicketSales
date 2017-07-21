package DAOImpl;

import DAOInterfaces.SeatsDAO;
import Entities.Seat;
import Entities.Wagon;
import Factory.HibernateUtil;
import org.hibernate.HibernateException;
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
public class SeatsDAOImpl implements SeatsDAO {

    @Override
    public void addSeat(Seat seat) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(seat);
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
    public void updateSeat(Seat seat) throws SQLException {
        Session session=null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(seat);
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
    public List<Seat> getSeatsByWagon(Wagon wagon) throws SQLException {
       List seats= new ArrayList<Seat>();
       try (Session session=HibernateUtil.getSessionFactory().openSession()){
           seats=session.createCriteria(Wagon.class).add(Restrictions.eq("wagon", wagon)).list();
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return seats;
    }

    @Override
    public void deleteSeat(Seat seat) throws SQLException {
        Session session=null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(seat);
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
