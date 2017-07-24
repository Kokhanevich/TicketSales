package DAOInterfaces;

import Entities.Passengers;
import Entities.Ticket;
import Entities.Plane;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Николай on 13.07.2017.
 */
public interface TicketDAO {
    public void addTicket(Ticket ticket) throws SQLException;
    public void update(Ticket ticket) throws SQLException;
    public Ticket getTicketById(Long id) throws SQLException;
    public List<Ticket> getTicketsByPassenger(Passengers passenger) throws SQLException;
    public List<Ticket> getTicketsByPlane(Plane plane) throws SQLException;
    public List<Ticket> getAllTickets() throws SQLException;
    public void deleteTicket(Ticket ticket) throws SQLException;

}
