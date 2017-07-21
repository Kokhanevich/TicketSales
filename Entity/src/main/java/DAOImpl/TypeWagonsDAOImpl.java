package DAOImpl;

import DAOInterfaces.TypeWagons;
import Factory.HibernateUtil;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Николай on 16.07.2017.
 */
public class TypeWagonsDAOImpl implements TypeWagons {
    @Override
    public void addType(TypeWagons typeWagons) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(typeWagons);
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
    public void updateType(TypeWagons typeWagons) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(typeWagons);
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
    public TypeWagons getTypeByID(Long id) throws SQLException {
        Session session=null;
        TypeWagons typeWagon=null;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            typeWagon=(TypeWagons) session.load(TypeWagons.class, id);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"joihh io", JOptionPane.OK_OPTION);
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return typeWagon;
    }

    @Override
    public List<TypeWagons> getAllTypes() throws SQLException {
        Session session=null;
        List typesList= new ArrayList<TypeWagons>();
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            typesList= session.createCriteria(TypeWagons.class).list();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"joihh io", JOptionPane.OK_OPTION);
        }
        finally {
            if (session !=null && session.isOpen()){
                session.close();
            }
        }
        return typesList;
    }

    @Override
    public void deleteTypes(TypeWagons typeWagons) throws SQLException {
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(typeWagons);
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
