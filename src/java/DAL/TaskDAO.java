/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import model.Task;

/**
 *
 * @author Hp
 */
public class TaskDAO {

    Connection con;
    String status;

    public TaskDAO() {
        try {
            con = new DBContext().getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public List<Task> getAll() throws Exception {
        ArrayList<Task> ar = new ArrayList<>();
        String sql = "select * from Tasks";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ar.add(new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (SQLException e) {
            status = "Error at read account" + e.getMessage();
        }
        return ar;
    }

    public List<Task> getTaskbySectionID(int idSection) throws Exception {
        String sql = "select * from Tasks where SectionID=?";
        ArrayList<Task> ar = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSection);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ar.add(new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (SQLException e) {
            status = "Error at read account" + e.getMessage();
        }
        return ar;
    }

    public List<Task> getTaskbyPriority(int priority) throws Exception {
        String sql = "select * from Tasks where priority=? order by DueDate";
        ArrayList<Task> ar = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, priority);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ar.add(new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (SQLException e) {
            status = "Error at read account" + e.getMessage();
        }
        return ar;
    }

    public List<Task> getTaskbyProjectID(int idPro) throws Exception {
        String sql = "select * from Tasks where ProjectID=?";
        ArrayList<Task> ar = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ar.add(new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (SQLException e) {
            status = "Error at read account" + e.getMessage();
        }
        return ar;
    }

    public Task getTask(int id) throws Exception {
        String sql = "select * from Tasks where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Task t = new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                return t;
            }
        } catch (SQLException e) {
            status = "Error at read account" + e.getMessage();
        }
        return null;
    }

    public void Insert(int id, String name, String startDate, String dueDate, String description, int priority, int sectionID, int projectID) {
        String sql = "insert into Tasks values(?,?,?,?,?,?,?,?)"; //insert database
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, startDate);
            ps.setString(4, dueDate);
            ps.setString(5, description);
            ps.setInt(6, priority);
            ps.setInt(7, sectionID);
            ps.setInt(8, projectID);
            ps.execute();
        } catch (SQLException e) {
            status = "Error at Insert Student" + e.getMessage();
        }
    }

    public void Update(int id, String name, String dueDate, String description, int priority) {
        String sql = "update Tasks set [name]=?, dueDate=?, description=?, priority=? where id=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(5, id);
            ps.setString(1, name);
            ps.setString(2, dueDate);
            ps.setString(3, description);
            ps.setInt(4, priority);
            ps.execute();
        } catch (SQLException e) {
            status = "Error at Update Projects" + e.getMessage();
        }
        System.out.println("updated");
    }

    public void Delete(int id) {
        String sql = "delete from Tasks where id=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            status = "Error at delete Projects" + e.getMessage();
        }
    }

    public static void main(String[] args) throws Exception {
        TaskDAO t = new TaskDAO();
        t.Insert(1, "hhh", null, null, "test", 2, 1, 1);
        t.Insert(2, "hhh2", null, null, "test", 2, 1, 1);
        t.Insert(3, "hhh3", null, null, "test", 3, 1, 1);
        t.Insert(4, "hhh4", null, null, "test", 4, 1, 1);
        List<Task> pri1 = t.getTaskbyPriority(1);
        List<Task> pri2 = t.getTaskbyPriority(2);
        List<Task> pri3 = t.getTaskbyPriority(3);
        List<Task> pri4 = t.getTaskbyPriority(4);
//        System.out.println(pri1.get(0).getName());
//        System.out.println(pri2.get(0).getName());
//        System.out.println(pri3.get(0).getName());
//        System.out.println(pri4.get(0).getName());
        List<Task> task = t.getAll();
        for (Task item : task) {
            System.out.println(item.getName());
        }
    }
}
