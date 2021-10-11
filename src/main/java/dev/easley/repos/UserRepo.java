package dev.easley.repos;

import dev.easley.models.Employees;
import dev.easley.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepo {

    public Employees getByUsername(String username) {
        ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from employee where username = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employees e = new Employees(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("employee_type"),
                        rs.getInt("avail_assist")
                );
                System.out.println(e);
                return e;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}