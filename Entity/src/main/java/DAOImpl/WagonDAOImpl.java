package DAOImpl;

import DAOInterfaces.WagonDAO;
import Entities.Train;
import Entities.Wagon;
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
public class WagonDAOImpl implements WagonDAO {
    @Override
    public void addWagon(Wagon wagon) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(wagon);
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
    public void updateWagon(Wagon wagon) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(wagon);
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
    public List<Wagon> getWagonsByTrain(Train train) throws SQLException {
        List wagons= new ArrayList<Wagon>();
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            wagons=session.createCriteria(Wagon.class).add(Restrictions.eq("Train", train)).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return wagons;
    }

    @Override
    public void deleteWagon(Wagon wagon) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(wagon);
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
