import java.sql.*;
import java.util.Properties;

public class Homework {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String MINIONS_TABLE_NAME = "minions_db";
    Connection connection;

    public void setConnection(String user, String password) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);


        connection = DriverManager.getConnection(CONNECTION_STRING + MINIONS_TABLE_NAME, properties);


    }

    public void exercise2() throws SQLException {
        String query = "SELECT v.name, count(DISTINCT mv.minion_id) AS count from villains AS v " +
                "JOIN minions_villains mv on v.id = mv.villain_id " +
                "group by v.id " +
                "having count > 15;";
        PreparedStatement statement = connection.prepareStatement
                (query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt(2));
        }
    }

}