package DAOInterfaces;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Николай on 13.07.2017.
 */
public interface TypeWagons {
    public void addType(TypeWagons typeWagons) throws SQLException;
    public void updateType(TypeWagons typeWagons) throws SQLException;
    public TypeWagons getTypeByID(Long id) throws SQLException;
    public List<TypeWagons> getAllTypes() throws SQLException;
    public void deleteTypes(TypeWagons typeWagons) throws SQLException;
}
