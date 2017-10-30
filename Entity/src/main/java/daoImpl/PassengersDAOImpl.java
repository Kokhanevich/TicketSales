package daoImpl;

import daoInterfaces.PassengersDAO;
import entities.Passengers;
import factory.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Николай on 04.07.2017.
 */
public class PassengersDAOImpl implements PassengersDAO {

    @Override
    public void addNamePassengers(Passengers namePassengers) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(namePassengers);
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
    public void updateNamePassengers(Passengers namePassengers) throws SQLException {
        Session session=null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(namePassengers);
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
    public Passengers getPassengerByLastName(String lastName) throws SQLException {
        Session session=null;
        Passengers namePassengers=null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            Query query =session.createQuery("FROM Passengers WHERE lastName =:paramName");
            query.setParameter("paramName", lastName);
            namePassengers=(Passengers) query.getSingleResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return namePassengers;
    }

    @Override
    public Passengers getPassengerByFirstName(String firstName) throws SQLException {
        Session session=null;
        Passengers namePassengers=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query =session.createQuery("FROM Passengers WHERE firstName =:paramName");
            query.setParameter("paramName", firstName);
            namePassengers=(Passengers) query.getSingleResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return namePassengers;
    }

    @Override
    public List<Passengers> getAllPassengers() throws SQLException {
        Session session=null;
        List passengersList= new ArrayList<Passengers>();
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            passengersList= session.createCriteria(Passengers.class).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }

        return passengersList;
    }

    @Override
    public void deletePassenger(Passengers namePassengers) throws SQLException {
        Session session=null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(namePassengers);
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
