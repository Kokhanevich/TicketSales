package DAOImpl;

import DAOInterfaces.TrainDAO;
import Entities.Stations;
import Entities.Train;
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
public class TrainDAOImpl implements TrainDAO {
    @Override
    public void addTrain(Train train) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(train);
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
    public void updateTrain(Train train) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(train);
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
    public List<Train> getTrainsByRoute(Stations fromStation, Stations toStation) throws SQLException {
        Session session=null;
        List trains= new ArrayList<Train>();
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            trains=session.createCriteria(Train.class).add(Restrictions.eq("from",fromStation)).add(Restrictions.eq("to",toStation)).list();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"joihh io", JOptionPane.OK_OPTION);
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return trains;
    }

    @Override
    public void deleteTrain(Train train) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(train);
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
