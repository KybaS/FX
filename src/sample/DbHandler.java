package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);

        return dbConnection;
    }

    public void registrationUser(String firstName, String lastName, String loginNick, String password, String email) {
        String insert = "INSERT INTO " + Constants.USERS_TABLE + "(" + Constants.USERS_FIRST_NAME + ","
                + Constants.USERS_LAST_NAME + "," + Constants.USERS_EMAIL + "," + Constants.USERS_LOGIN_NICK + ","
                + Constants.USERS_PASSWORD + ")" + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, loginNick);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, email);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
