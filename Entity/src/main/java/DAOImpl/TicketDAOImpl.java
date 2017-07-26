package DAOImpl;

import DAOInterfaces.TicketDAO;
import Entities.Passengers;
import Entities.Ticket;
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
public class TicketDAOImpl implements TicketDAO {
    @Override
    public void addTicket(Ticket ticket) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(ticket);
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
    public void update(Ticket ticket) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(ticket);
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
    public Ticket getTicketById(Long id) throws SQLException {
        Session session=null;
        Ticket ticket=null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            ticket=(Ticket)session.load(Ticket.class, id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return ticket;
    }

    @Override
    public List<Ticket> getTicketsByPassenger(Passengers passenger) throws SQLException {
        Session session=null;
        List tickets=new ArrayList<Ticket>();
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            tickets=session.createCriteria(Ticket.class).add(Restrictions.eq("passanger",passenger)).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session!=null && session.isOpen()){
                session.close();
            }
        }
        return tickets ;
    }

    @Override
    public List<Ticket> getTicketsByPlane(Plane plane) throws SQLException {
        Session session=null;
        List tickets=new ArrayList<Ticket>();
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            tickets=session.createCriteria(Ticket.class).add(Restrictions.eq("plane",plane)).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session!=null && session.isOpen()){
                session.close();
            }
        }
        return tickets;
    }

    @Override
    public List<Ticket> getAllTickets() throws SQLException {
        Session session=null;
        List ticketsList= new ArrayList<Ticket>();
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            ticketsList= session.createCriteria(Ticket.class).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return ticketsList;
    }

    @Override
    public void deleteTicket(Ticket ticket) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(ticket);
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
