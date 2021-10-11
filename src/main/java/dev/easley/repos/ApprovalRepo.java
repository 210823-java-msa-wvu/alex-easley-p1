package dev.easley.repos;

import dev.easley.models.Approvals;
import dev.easley.models.Requests;
import dev.easley.services.ApprovalService;
import dev.easley.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApprovalRepo {

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public void DHupdate(Approvals approvals) {

        try (Connection conn = cu.getConnection()) {

            String sql = "update approval set dhinforequest  = ?, dhinforequestds =?, dhapproval = ? where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setBoolean(1, approvals.getDhinforequest());
            ps.setBoolean(2, approvals.getDhinforequestds());
            ps.setBoolean(3, approvals.getDhapproval());
            ps.setInt(4, approvals.getRequest_id());

            ps.executeUpdate();


        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void BCupdate(Approvals approvals) {

        try (Connection conn = cu.getConnection()) {

            String sql = "update approval set bcinforequestdh = ?, bcinforequestds =?, bcapproval = ?, bcinforequeste = ? where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setBoolean(1, approvals.getBcinforequestdh());
            ps.setBoolean(2, approvals.getBcinforequestds());
            ps.setBoolean(3, approvals.getBcapproval());
            ps.setBoolean(4, approvals.getBcinforequeste());
            ps.setInt(5, approvals.getRequest_id());

            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Approvals approvals) {

        try (Connection conn = cu.getConnection()) {

            String sql = "update approval set dsapproval = ?, dsinforequest = ?, dsdenialreason= ? where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setBoolean(1, approvals.getDsapproval());
            ps.setBoolean(2, approvals.getDsinforequest());
            ps.setString(3, approvals.getDsdenialreason());
            ps.setInt(4, approvals.getRequest_id());

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Approvals> getAll() {
        List<Approvals> approvalsList = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from approval";

            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println("in approvals get all");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Approvals a = new Approvals();
                a.setDsapproval(rs.getBoolean("dsapproval"));
                a.setDhapproval(rs.getBoolean("dhapproval"));
                a.setBcapproval(rs.getBoolean("bcapproval"));
                a.setDsinforequest(rs.getBoolean("dsinforequest"));
                a.setDhinforequestds(rs.getBoolean("dhinforequestds"));
                a.setDhinforequest(rs.getBoolean("dhinforequest"));
                a.setBcinforequestdh(rs.getBoolean("bcinforequestdh"));
                a.setBcinforequestds(rs.getBoolean("bcinforequestds"));
                a.setBcinforequeste(rs.getBoolean("bcinforequeste"));
                a.setDsdenialreason(rs.getString("dsdenialreason"));
                a.setRequest_id(rs.getInt("id"));

                approvalsList.add(a);

            }

            return approvalsList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Approvals> getAllById(Integer id) {
        List<Approvals> approvalsList = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from approval where approval_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Approvals a = new Approvals();
                a.setDsapproval(rs.getBoolean("dsapproval"));
                a.setDhapproval(rs.getBoolean("dhapproval"));
                a.setBcapproval(rs.getBoolean("bcapproval"));
                a.setDsinforequest(rs.getBoolean("dsinforequest"));
                a.setDhinforequestds(rs.getBoolean("dhinforequestds"));
                a.setDhinforequest(rs.getBoolean("dhinforequest"));
                a.setBcinforequestdh(rs.getBoolean("bcinforequestdh"));
                a.setBcinforequestds(rs.getBoolean("bcinforequestds"));
                a.setBcinforequeste(rs.getBoolean("bcinforequeste"));
                a.setDsdenialreason(rs.getString("dsdenialreason"));
                a.setRequest_id(rs.getInt("id"));

                approvalsList.add(a);


            }

            return approvalsList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
}

