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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dept;
import model.Emp;

/**
 *
 * @author Ngo Tung Son
 */
public class EmpDBContext extends DBContext<Emp> {

    public ArrayList<Emp> filter(Integer id, String name, Boolean gender, Date from, Date to, Integer did) {
        String sql = "SELECT e.eid,e.ename,e.gender,e.dob ,e.did\n"
                + "FROM Emp e\n";
        Integer count = 0;
        HashMap<Integer,Object> params = new HashMap<>();
        if(id !=null)
        {
            count++;
            sql+= "AND e.eid = ?\n";
            params.put(count, id);
        }
        if(name != null)
        {
            count++;
            sql += "AND e.ename like '%' + ? + '%'\n";
            params.put(count, name);
        }
        if(gender !=null)
        {
            count++;
            sql+= "AND e.gender =?\n";
            params.put(count, gender);
        }
        if(from !=null)
        {
            count++;
            sql+= "AND e.dob >= ?\n";
            params.put(count, from);
        }
        if(to !=null)
        {
            count++;
            sql+= "AND e.dob <= ?\n";
            params.put(count, to);
        }
        if(did !=null)
        {
            count++;
            sql += "AND e.did = ?\n";
            params.put(count, did);
        }
        ArrayList<Emp> emps = new ArrayList<>();
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            for (Map.Entry<Integer, Object> entry : params.entrySet()) {
                Integer key = entry.getKey();
                Object val = entry.getValue();
                stm.setObject(key, val);
            }
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Emp e = new Emp();
                e.setId(rs.getInt("eid"));
                e.setName(rs.getString("ename"));
                e.setDob(rs.getDate("dob"));
                e.setGender(rs.getBoolean("gender"));
                Dept d = new Dept();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                e.setDept(d);
                emps.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emps;
        
        
    }

    public ArrayList<Emp> search(int did) {
        ArrayList<Emp> emps = new ArrayList<>();
        try {
            String sql = "SELECT e.eid,e.ename,e.gender,e.dob\n"
                    + ",d.did,d.dname\n"
                    + "FROM Emp e INNER JOIN Dept d\n"
                    + "ON e.did = d.did\n"
                    + "WHERE d.did = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, did);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Emp e = new Emp();
                e.setId(rs.getInt("eid"));
                e.setName(rs.getString("ename"));
                e.setDob(rs.getDate("dob"));
                e.setGender(rs.getBoolean("gender"));
                Dept d = new Dept();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                e.setDept(d);
                emps.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emps;
    }

    @Override
    public ArrayList<Emp> list() {
        String sql = "SELECT e.eid,e.ename,e.gender,e.dob ,e.did\n"
                + "FROM [PRJ301_Slot1_246].[dbo].[Emp] e\n";
        ArrayList<Emp> emps = new ArrayList<>();
        try {
            PreparedStatement stm = connection.prepareStatement(sql);            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Emp e = new Emp();
                e.setId(rs.getInt("eid"));
                e.setName(rs.getString("ename"));
                e.setDob(rs.getDate("dob"));
                e.setGender(rs.getBoolean("gender"));
                Dept d = new Dept();
                d.setId(rs.getInt("did"));
                e.setDept(d);
                emps.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emps;
    }

    @Override
    public Emp get(Emp entity) {
        try {
            String sql = "SELECT e.eid,e.ename,e.gender,e.dob\n"
                    + ",d.did,d.dname\n"
                    + "FROM Emp e INNER JOIN Dept d\n"
                    + "ON e.did = d.did\n"
                    + "WHERE e.eid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, entity.getId());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Emp e = new Emp();
                e.setId(rs.getInt("eid"));
                e.setName(rs.getString("ename"));
                e.setDob(rs.getDate("dob"));
                e.setGender(rs.getBoolean("gender"));
                Dept d = new Dept();
                d.setId(rs.getInt("did"));
                d.setName(rs.getString("dname"));
                e.setDept(d);
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Emp entity) {
        try {
            String sql = "INSERT INTO [Emp]\n"
                    + "           ([ename]\n"
                    + "           ,[gender]\n"
                    + "           ,[dob]\n"
                    + "           ,[did])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, entity.getName());
            stm.setBoolean(2, entity.isGender());
            stm.setDate(3, entity.getDob());
            stm.setInt(4, entity.getDept().getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Emp entity) {
        try {
            String sql = "UPDATE [Emp]\n"
                    + "   SET [ename] = ?\n"
                    + "      ,[gender] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[did] = ?\n"
                    + " WHERE [eid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, entity.getName());
            stm.setBoolean(2, entity.isGender());
            stm.setDate(3, entity.getDob());
            stm.setInt(4, entity.getDept().getId());
            stm.setInt(5, entity.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Emp entity) {
        try {
            String sql = "DELETE Emp"
                    + " WHERE [eid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, entity.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
