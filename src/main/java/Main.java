import java.sql.*;

/**
 * Created by cube on 21.01.2017.
 */
public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        addMySQLToClassPath();
        createDbUserTable();
        //  addUser(0,"Vasia","Pupkin");
        //  addUser(1,"Lena","Golovach");
        // addUser(2,"Dimka","Medvedev");
        // addUser(3, "Dimka", "Bob");
        //addUser(4, "Masha", "Medvedev");
        System.out.println("id");
        System.out.println("---------------------------");
        findUserById(1);
        System.out.println("name");
        System.out.println("---------------------------");
        findUserByName("Dimka");
        System.out.println("last_name");
        System.out.println("---------------------------");
        findUserByLastName("Medvedev");
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }

    private static void addMySQLToClassPath() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void createDbUserTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS dbuser("
                + "USER_ID INT(5) NOT NULL, "
                + "USER_NAME VARCHAR(20) NOT NULL, "
                + "LAST_NAME VARCHAR(20) NOT NULL, "
                + "PRIMARY KEY (USER_ID) "
                + ")";
        try (Connection dbConnection = getConnection();
             Statement statement = dbConnection.createStatement()) {
            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addUser(int id, String name, String lastName) {
        try (Connection dbConnection = getConnection();
             PreparedStatement statement = dbConnection.prepareStatement("INSERT INTO dbuser" +
                     "(USER_ID, USER_NAME,LAST_NAME ) VALUES (?,?,?)");) {
            int i = 1;
            statement.setInt(i++, id);
            statement.setString(i++, name);
            statement.setString(i, lastName);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void findUserById(int id) {
        try (Connection dbConnection = getConnection();
             PreparedStatement statement = dbConnection.prepareStatement("SELECT * FROM dbuser WHERE USER_ID =?")) {
            int i = 1;
            statement.setInt(i, id);
            ResultSet resultSet = statement.executeQuery();
            printDataSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void findUserByName(String name) {
        try (Connection dbConnection = getConnection();
             PreparedStatement statement = dbConnection.prepareStatement("SELECT * FROM dbuser WHERE USER_NAME =?")) {
            int i = 1;
            statement.setString(i, name);
            ResultSet resultSet = statement.executeQuery();
            printDataSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void findUserByLastName(String lastName) {
        try (Connection dbConnection = getConnection();
             PreparedStatement statement = dbConnection.prepareStatement("SELECT * FROM dbuser WHERE LAST_NAME =?")) {
            int i = 1;
            statement.setString(i, lastName);
            ResultSet resultSet = statement.executeQuery();
            printDataSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printDataSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("USER_ID"));
            System.out.println(resultSet.getString("USER_NAME"));
            System.out.println(resultSet.getString("LAST_NAME"));
            System.out.println("//////////////////////////////////////////////////////");
        }
    }

}
