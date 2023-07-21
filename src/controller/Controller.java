package controller;

import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Todo;
import model.SingletonUser;

public class Controller {

    DatabaseHandler conn = new DatabaseHandler();

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM user";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhoto(rs.getString("photo"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }
    public User getUser(String email, String pass) {
        User user = new User();
        conn.connect();
        String query = "SELECT * FROM user WHERE email = '" + email + "' &&password = '" +  pass + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                SingletonUser.getInstance().setIdUser(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhoto(rs.getString("photo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);
    }
    
    public ArrayList<Todo> getAllTodoUser(int userId){
        ArrayList<Todo> todos = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM todo WHERE userId = '" + userId + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Todo todo = new Todo();
                todo.setTitle(rs.getString("title"));
                todo.setNote(rs.getString("note"));
                
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (todos);
    }
    
    public boolean insertUser(User user) {
        try {
            conn.connect();
            String query = "INSERT INTO user(name, email, password, gender, birthday, photo) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getGender());
            stmt.setDate(5, user.getBirthday());
            stmt.setString(6, user.getPhoto());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }
    }
}
