import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Homework {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String MINIONS_TABLE_NAME = "minions_db";
    private static final Scanner scanner = new Scanner(System.in);

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
        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt(2));
        }
    }

    public void exercise3() throws SQLException {
        PreparedStatement statement = connection.prepareStatement
                ("SELECT COUNT(1) FROM villains;");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        int villainsCount = resultSet.getInt(1);
        System.out.println("Enter villain id:");
        int villainId = Integer.parseInt(scanner.nextLine());
        if (villainId < 1 || villainId > villainsCount) {
            System.out.println("No villain with ID " + villainId + " exists in the database.");
        } else {
            PreparedStatement statement1 = connection.prepareStatement
                    ("SELECT name FROM villains WHERE id = ?;");
            statement1.setInt(1, villainId);
            ResultSet resultSet1 = statement1.executeQuery();
            resultSet1.next();
            String villainName = resultSet1.getString(1);
            System.out.println("Villain: " + villainName);

            PreparedStatement statement2 = connection.prepareStatement
                    ("SELECT m.name, m.age FROM minions m " +
                            "JOIN minions_villains mv on m.id = mv.minion_id " +
                            "WHERE mv.villain_id = ?;");
            statement2.setInt(1, villainId);
            ResultSet resultSet2 = statement2.executeQuery();
            while (resultSet2.next()) {
                System.out.printf("%d. %s %d%n",
                        resultSet2.getRow(), resultSet2.getString(1), resultSet2.getInt(2));
            }
        }
    }

    public void exercise4() throws SQLException {
        System.out.println("Enter minion name, age and city (for ex: Chocho 30 Sofia)");
        String[] input = scanner.nextLine().split("\s");
        String name = input[0];
        int age = Integer.parseInt(input[1]);
        String city = input[2];
        String query;
        PreparedStatement statement;
        ResultSet resultSet;
        if (isEntityNotExistsByName("towns", "name", city)) {
            //City Not exists
            query = "INSERT INTO towns (name) VALUE (?);";
            statement = connection.prepareStatement(query);
            statement.setString(1, city);
            statement.executeUpdate();
            System.out.printf("Town %s was added to the database.%n", city);
        }
        query = "SELECT id FROM towns WHERE name = ?;";
        statement = connection.prepareStatement(query);
        statement.setString(1, city);
        resultSet = statement.executeQuery();
        resultSet.next();
        int townId = resultSet.getInt(1);
        query = "INSERT INTO minions (name, age, town_id) VALUE(?, ?, ?);";
        statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setInt(2, age);
        statement.setInt(3, townId);
        statement.executeUpdate();

        System.out.println("Enter villain name:");
        String villainName = scanner.nextLine();

        if (isEntityNotExistsByName("villains", "name", villainName)) {
            //Villain Not exists
            query = "INSERT INTO villains (name, evilness_factor) VALUE (?, 'evil');";
            statement = connection.prepareStatement(query);
            statement.setString(1, villainName);
            statement.executeUpdate();
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        int minionId = getIdByName("minions", name);
        int villainId = getIdByName("villains", villainName);
        query = String.format("INSERT INTO minions_villains " +
                "(minion_id, villain_id) VALUE(%d, %d);", minionId, villainId);
        statement = connection.prepareStatement(query);
        statement.executeUpdate();
        System.out.printf("Successfully added %s to be minion of %s.%n", name, villainName);
    }

    private boolean isEntityNotExistsByName(String tableName, String columnName, String entityName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE %s = '%s';", tableName, columnName, entityName);
        PreparedStatement statement = connection.prepareStatement
                (query);
        ResultSet resultSet = statement.executeQuery();
        return !resultSet.next();
    }

    private int getIdByName(String tableName, String entityName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = '%s';", tableName, entityName);
        PreparedStatement statement = connection.prepareStatement
                (query);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public void exercise5() throws SQLException {
        System.out.println("Enter name of country:");
        String countryName = scanner.nextLine();
        if(isEntityNotExistsByName("towns", "country", countryName)){
            System.out.println("No town names were affected.");
        } else {
        PreparedStatement statement = connection.
                prepareStatement("UPDATE towns SET name = upper(name) WHERE country = ?;");
        statement.setString(1,countryName);
        int affectedRows = statement.executeUpdate();
            System.out.println(affectedRows + " town names were affected.");
            statement = connection.prepareStatement("SELECT name FROM towns WHERE country = ?;");
            statement.setString(1, countryName);
            ResultSet resultSet = statement.executeQuery();
            List<String> results = new ArrayList<>();
            while (resultSet.next()) {
                results.add(resultSet.getString(1));
            }
            System.out.print("[");
            System.out.print(results.stream().map(Object::toString).
                    collect(Collectors.joining(", ")));
            System.out.print("]");
        }
    }

    public void exercise6() throws SQLException {
        System.out.println("Enter villain id:");
        int villainId = Integer.parseInt(scanner.nextLine());
        String query = String.format("SELECT name FROM villains WHERE id = %d",villainId);
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next()) {
            System.out.println("No such villain was found");
        } else {
            query = String.format("DELETE FROM minions_villains WHERE villain_id = %d;", villainId);
            statement = connection.prepareStatement(query);
            int minionsReleased = statement.executeUpdate();
            query = String.format("SELECT name FROM villains WHERE id = %d;", villainId);
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            resultSet.next();
            String villainName = resultSet.getString(1);
            System.out.printf("%s was deleted%n%d minions released", villainName, minionsReleased);
            query = String.format("DELETE FROM villains WHERE id = %d;", villainId);
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
        }
    }

    public void exercise7() throws SQLException {
        String query = "SELECT name FROM minions;";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        ArrayDeque<String> result = new ArrayDeque<>();
        while (resultSet.next()) {
            result.add(resultSet.getString(1));
        }
        while (!result.isEmpty()) {
            System.out.println(result.removeFirst());
            System.out.println(result.removeLast());
        }
    }

    public void exercise8() throws SQLException {
        System.out.println("Enter minion IDs, separated by space:");
        int[] id = Arrays.stream(scanner.nextLine().split("\s")).mapToInt(Integer::parseInt).toArray();
        String idAsString = IntStream.of(id)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));
        String query = String.format("UPDATE minions SET age = age + 1," +
                " name = LOWER(name) WHERE id IN (%s);", idAsString);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
        statement = connection.prepareStatement("SELECT name, age FROM minions;");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("%s - %d%n", resultSet.getString(1), resultSet.getInt(2));
        }
    }

    public void exercise9() throws SQLException {
        System.out.println("Enter minion id:");
        int id = Integer.parseInt(scanner.nextLine());
        String query = String.format("CALL usp_get_older(%d)",id);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
        query = String.format("SELECT name, age FROM minions WHERE id = %d", id);
        statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        System.out.printf("Name - %s%nAge - %d%n", resultSet.getString(1), resultSet.getInt(2));
    }
}
