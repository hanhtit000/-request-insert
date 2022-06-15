/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AnualRequest;

/**
 *
 * @author Ngo Tung Son
 */
public class RequestDBContext extends DBContext<AnualRequest> {

    public ArrayList<AnualRequest> filter(int create, int review) {
        ArrayList<AnualRequest> request = new ArrayList<>();
        try {
            String sql = "SELECT distinct a.rid, a.reason, a.[from date], a.[to date], a.created_by, a.reviewed_by, a.status\n"
                    + "FROM Emp e INNER JOIN AnualRequest a ON e.eid = a.created_by or e.eid = a.reviewed_by \n";
            if (create != 0) {
                sql += "WHERE a.created_by=? ";
            }
            if (review != 0) {
                sql += "and a.reviewed_by=?";
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            if (create != 0) {
                stm.setInt(1, create);
            }
            if (review != 0) {
                stm.setInt(2, review);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                AnualRequest a = new AnualRequest();
                a.setRid(rs.getInt("rid"));
                a.setReason(rs.getString("reason"));
                a.setFrom_date(rs.getDate("from date"));
                a.setTo_date(rs.getDate("to date"));
                a.setCreated_by(rs.getInt("created_by"));
                a.setReviewed_by(rs.getInt("reviewed_by"));
                a.setStatus(rs.getString("status"));
                request.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return request;

    }

    @Override
    public ArrayList<AnualRequest> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AnualRequest get(AnualRequest entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(AnualRequest entity) {
        String sql = "INSERT INTO [PRJ301_Slot1_246].[dbo].[AnualRequest]\n"
                + "([reason],[from],[to],[created_by],[reviewed_by],[status])\n"
                + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, entity.getReason());
            stm.setDate(2, entity.getFrom_date());
            stm.setDate(3, entity.getTo_date());
            stm.setInt(4, entity.getCreated_by());
            stm.setInt(5, entity.getReviewed_by());
            stm.setString(6, entity.getStatus());
            stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(RequestDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(AnualRequest entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(AnualRequest entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
