package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.concurrent.atomic.AtomicLong;


public class MySQLUsersDao implements Users {

    private final Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    public User findById(long id) {
        String query = "SELECT * FROM users WHERE id = ? LIMIT 1";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, String.valueOf(id));
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Unable to locate user by id", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    @Override
    public void update(User user) {
        String query = "UPDATE users SET username= ?, email = ?, password = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setLong(4, user.getId());
             stmt.executeUpdate() ;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating a user", e);
        }
    }

    @Override
    public AtomicLong findUserId(long id) {
        return null;
    }

//    @Override
//    public void delete(Long myId) {
//        String query = "DELETE FROM users WHERE id = ?";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(query);
//            stmt.setLong(1, myId);
//            stmt.executeUpdate() ;
//        } catch (SQLException e) {
//            throw new RuntimeException("Error deleting a user", e);
//        }
//    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
        );
    }
    public User findOneUserById(long id){
        PreparedStatement stmt=null;

        try {
            stmt = connection.prepareStatement("SELECT * FROM Users where id=?");
            stmt.setLong(1,id);
            ResultSet rs= stmt.executeQuery();
            if(rs.next()){
                return extractUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return null;
    }

}
