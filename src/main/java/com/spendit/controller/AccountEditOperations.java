package com.spendit.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.spendit.utility.BCrypt;

public class AccountEditOperations {

    public void editAccount(Connection connection, String firstName, String lastName, String username, String email, String image, int userID) {
        String sql = "UPDATE users SET firstname = ? , lastname = ?, username = ?, email = ?, image = ? WHERE users.userID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, username);
            ps.setString(4, email);
            ps.setString(5, image);
            ps.setInt(6, userID);
            ps.executeUpdate();

        }catch(SQLException sqle) {
            System.err.println(sqle.getMessage());
        }catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void updatePassword(Connection connection, String username, String newPassword, String oldPassword) {
        String sql = "UPDATE users SET password = ? WHERE users.username = ?";
        if(authenticate(connection, username, oldPassword)) {
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, BCrypt.hashpw(newPassword, BCrypt.gensalt()));
                ps.setString(2, username);
                ps.executeUpdate();

            }catch(SQLException sqle) {
                System.err.println(sqle.getMessage());
            }catch(Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

    /*Step 1: Retrieve user row from DB based on username */
    /*Step 2: Using the value of parameter password, we'll check hash matches using BCrypt.checkpw(String plaintextentry, String hashedpasswordindb)*/
    /*Step 3: Return true if checkpw is successful*/
    public boolean authenticate(Connection connection, String username, String password) {
        String sql = "SELECT username, password FROM users WHERE username = ?";
        ResultSet rs = null;
        try {
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1, username.toLowerCase());
            rs = prep.executeQuery();
            while(rs.next()) {
                if(BCrypt.checkpw(password, rs.getString("password"))) {
                    return true;
                }
            }
        }catch(SQLException sqle) {
            System.err.println(sqle.getMessage());
        }catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}