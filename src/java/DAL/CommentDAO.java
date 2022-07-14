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
import model.Comment;
import model.Comment;

/**
 *
 * @author Hp
 */
public class CommentDAO {
    Connection con;
    String status;

    public CommentDAO() {
        try {
            con = new DBContext().getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public List<Comment> getAll() throws Exception {
        ArrayList<Comment> ar = new ArrayList<>();
        String sql = "select * from Comments";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ar.add(new Comment(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }
        } catch (SQLException e) {
            status = "Error at read account" + e.getMessage();
        }
        return ar;
    }
    
    public List<Comment> getCommentbyProjectID(int idPro) throws Exception {
        String sql = "select id, comment, [DateTime] from Comments, ProjectComment where id = CommentID and ProjectID=?";
        ArrayList<Comment> ar = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ar.add(new Comment(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }
        } catch (SQLException e) {
            status = "Error at read account" + e.getMessage();
        }
        return ar;
    }
    
    public List<Comment> getCommentbyTaskID(int idTask) throws Exception {
        String sql = "select id, comment, [DateTime] from Comments, TaskComment where id = CommentID and TaskID=?";
        ArrayList<Comment> ar = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTask);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ar.add(new Comment(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            status = "Error at read account" + e.getMessage();
        }
        return ar;
    }
            
    
    public Comment getComment(int id) throws Exception {
        String sql = "select * from Comments where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Comment t = new Comment(rs.getInt(1), rs.getString(2), rs.getString(3));
                return t;
            }
        } catch (SQLException e) {
            status = "Error at read account" + e.getMessage();
        }
        return null;
    }

    public void InsertProjectID(int id, String comment, String date, int proid) {
        String sql = "insert into Comments values(?,?,?) insert into ProjectComment values(?,?)"; //insert database                
        try {            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, comment);
            ps.setString(3, date);
            ps.setInt(4, proid);
            ps.setInt(5, id);            
            ps.execute();
        } catch (Exception e) {
            status = "Error at Insert Student" + e.getMessage();
        }
    }

    public void Update(int id, String comment) {
        String sql = "update Comments set comment=? where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(2, id);
            ps.setString(1, comment);            
            ps.execute();
        } catch (SQLException e) {
            status = "Error at Update Comments" + e.getMessage();
        }
        System.out.println("updated");
    }

    public void Delete(int id) {
        String sql = "delete from Comments where id=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            status = "Error at delete Comments" + e.getMessage();
        }
    }

    public static void main(String[] args) throws Exception {
        CommentDAO c = new CommentDAO();
        List<Comment> list = c.getCommentbyProjectID(1);
        for (Comment item : list) {
            System.out.println(item.getComment());
        }
    }

}
