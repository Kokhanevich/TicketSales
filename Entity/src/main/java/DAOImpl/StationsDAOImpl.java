package DAOImpl;

import DAOInterfaces.StationsDAO;
import Entities.Stations;
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
public class StationsDAOImpl implements StationsDAO {
    @Override
    public void addStation(Stations station) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(station);
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
    public void updateStation(Stations station) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(station);
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
    public Stations getStationByID(int code) throws SQLException {
        Session session=null;
        Stations station=null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            station=(Stations) session.get(Stations.class, code);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"joihh io", JOptionPane.OK_OPTION);
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return station;
    }

    @Override
    public List<Stations> getStationByName(String nameStation) throws SQLException {
        List station= new ArrayList<Stations>();
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            station=session.createCriteria(Stations.class).add(Restrictions.eq("nameStation", nameStation)).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return station;


    }

    @Override
    public List<Stations> getAllStations() throws SQLException {
        Session session=null;
        List stations= new ArrayList<Stations>();
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            stations= session.createCriteria(Stations.class).list();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"joihh io", JOptionPane.OK_OPTION);
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }

        return stations;
    }

    @Override
    public void deleteStation(Stations station) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(station);
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
