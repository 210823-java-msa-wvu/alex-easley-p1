package dev.easley.repos;

import dev.easley.models.Approvals;
import dev.easley.models.Employees;
import dev.easley.models.Requests;
import dev.easley.utils.ConnectionUtil;

import javax.xml.transform.Result;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RequestRepo {

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public void updateCost (Requests request) {

            try (Connection conn = cu.getConnection()) {
                System.out.println(request.getRequestId());
                String sql = "update requests set cost = ? where request_id = ?";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setInt(1, request.getCost());
                ps.setInt(2, request.getRequestId());
                ps.executeUpdate();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    public void deleteRequest(Requests request) {

        try (Connection conn = cu.getConnection()) {
            System.out.println(request.getRequestId());
            String sql = "delete from requests where request_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, request.getEmployeeId());
            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateGrade(Requests request) {

        try (Connection conn = cu.getConnection()) {
            System.out.println(request.getRequestId());
            String sql = "update requests set grade = ? where request_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, request.getGrade());
            ps.setInt(2, request.getRequestId());
            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void add(Requests request, Employees emp) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Date Currentdate = (Date) java.util.Calendar.getInstance().getTime();
        try (Connection conn = cu.getConnection()) {
            System.out.println(request);

            String sql = "insert into requests(event_type, grade, justif, cost, req_date, start_date, location, description, employee_id) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, request.getEventType());
            ps.setString(2, request.getGrade());
            ps.setString(3, request.getJustify());
            ps.setInt(4, request.getCost());
            ps.setDate(5, Date.valueOf(dateFormat.format(request.getReqDate())));
            ps.setDate(6, Date.valueOf(dateFormat.format(request.getStartDate())));
            ps.setString(7, request.getLocation());
            ps.setString(8, request.getDescription());
            ps.setInt(9, emp.getId());

            ps.executeUpdate();

            String sql2 = "insert into approval (approval_id) values (?)";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, emp.getId());

            ps2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Requests> getAll() {
        List<Requests> requestList = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            String sql = "select employee_id ,event_type,grade,justif,cost,req_date,start_date,location,description,pass from requests inner join employee on employee.id = requests.employee_id order by employee_id";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Requests r = new Requests();
                r.setEmployeeId(rs.getInt("employee_id"));
                r.setEventType(rs.getString("event_type"));
                r.setGrade(rs.getString("grade"));
                r.setJustify(rs.getString("justif"));
                r.setCost(rs.getInt("cost"));
                r.setReqDate(rs.getDate("req_date"));
                r.setStartDate(rs.getDate("start_date"));
                r.setLocation(rs.getString("location"));
                r.setDescription((rs.getString("description")));
                r.setPassed((rs.getBoolean("pass")));

                requestList.add(r);

            }

            return requestList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Requests> getAllById(Integer id) {
        List<Requests> requestList2 = new ArrayList<>();
        System.out.println("id is " + id);
        try (Connection conn = cu.getConnection()) {

            String sql = "select employee_id ,event_type,grade,justif,cost,req_date,start_date,location,description from requests inner join employee on employee.id = requests.employee_id where employee_id = ? order by employee_id";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Requests r = new Requests();
                System.out.println(r);
                r.setEmployeeId(rs.getInt("employee_id"));
                r.setEventType(rs.getString("event_type"));
                r.setGrade(rs.getString("grade"));
                r.setJustify(rs.getString("justif"));
                r.setCost(rs.getInt("cost"));
                r.setReqDate(rs.getDate("req_date"));
                r.setStartDate(rs.getDate("start_date"));
                r.setLocation(rs.getString("location"));
                r.setDescription((rs.getString("description")));

                requestList2.add(r);



            }
            return requestList2;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Integer getAllByUsername(String username) {


        try (Connection conn = cu.getConnection()) {

            String sql = "select employee_id from requests full join employee on employee.id = Requests.employee_id where username = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString( 1, username);
            ResultSet rs = ps.executeQuery();



            if (rs.next()) {


                Integer id = rs.getInt("employee_id");


                return id;
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Requests getCostAndAvail(Requests requests, Integer id) {


        try (Connection conn = cu.getConnection()) {

            String sql = "select avail_assist, cost from requests full join employee on employee.id = Requests.employee_id where employee_id = ? and request_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1, requests.getEmployeeId());
            ps.setInt(2,id);
            ResultSet rs = ps.executeQuery();



            if (rs.next()) {
                Requests r = new Requests(
                rs.getInt("cost"),
                rs.getInt("avail_assist")
                );
                return r;
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}




