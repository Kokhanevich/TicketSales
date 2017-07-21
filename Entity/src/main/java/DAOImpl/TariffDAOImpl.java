package DAOImpl;

import DAOInterfaces.TariffDAO;
import Entities.Stations;
import Entities.Tariff;
import Entities.TypeWagons;
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
public class TariffDAOImpl implements TariffDAO {
    @Override
    public void addTariff(Tariff tariff) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(tariff);
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
    public void updateTariff(Tariff tariff) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(tariff);
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
    public List<Tariff> getTariffsByStation(List<Stations> fromStation, List<Stations> toStation) throws SQLException {
        Session session=null;
        List tariffs= new ArrayList<Tariff>();
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            tariffs=session.createCriteria(Tariff.class).add(Restrictions.eq("from",fromStation)).add(Restrictions.eq("to",toStation)).list();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"joihh io", JOptionPane.OK_OPTION);
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return tariffs;

    }

    @Override
    public Tariff getTariff(Stations fromStation, Stations toStation, TypeWagons type) throws SQLException {
        Session session=null;
        Tariff tariff=null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            Query query =session.createQuery("FROM Tariff WHERE fromStation =:paramFrom AND toStation=:paramTo and typeWagon=:paramType");
            query.setParameter("paramFrom", fromStation);
            query.setParameter("paramTo", toStation);
            query.setParameter("paramType", type);
            tariff=(Tariff) query.getSingleResult();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"joihh io", JOptionPane.OK_OPTION);
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return tariff;

    }

    @Override
    public void deleteTariff(Tariff tariff) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(tariff);
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
