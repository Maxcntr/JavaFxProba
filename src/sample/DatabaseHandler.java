package sample;

import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnections;

    public Connection getDbConnections()
            throws ClassNotFoundException, SQLException {
        // подключение к базе данных
        String connectionsString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnections = DriverManager.getConnection(connectionsString,
                dbUser, dbPass);

        return dbConnections;
    }
    //добавления пользователя через константы и закоментирована через строку
    //"INTRO" гавно два дня немог урать.
    public void singUpUser(User user){
        String insert = "INSERT " + Const.USERS_TABLE + "(" +
                Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME +","+
                Const.USERS_USERNAME+","+Const.USERS_PASSWORD+","+
                Const.USERS_LOCATION+","+Const.USERS_GENDER+")"+
                "VALUES(?,?,?,?,?,?)";
       // String insert = "INSERT  users ( firstname, lastname, username, password, location, gander) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnections().prepareStatement(insert);
            prSt.setString(1, user.getFirsName());
            prSt.setString(2, user.getLastName());
            prSt.setString(3, user.getUserName());
            prSt.setString(4, user.getPassword());
            prSt.setString(5, user.getLocation());
            prSt.setString(6, user.getGander());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }// для возврата пользователя "авторизация"
    public ResultSet getUser(User user) {
        ResultSet resSet = null;


        //строка SQL запроса через константы и закоментирована через строку
//        String select = "SELECT * FROM users WHERE username =? AND password =?";
        String select = "SELECT * FROM " + Const.USERS_TABLE + " WHERE " +
                Const.USERS_USERNAME + " = ? AND " + Const.USERS_PASSWORD + " =? ";

        try {
            PreparedStatement prSt = getDbConnections().prepareStatement(select);
            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return resSet;
    }
}
