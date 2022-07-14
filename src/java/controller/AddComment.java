/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.CommentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Comment;

/**
 *
 * @author Hp
 */
@WebServlet(name = "AddComment", urlPatterns = {"/addcomment"})
public class AddComment extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String projectid = request.getParameter("projectid");
        CommentDAO c = new CommentDAO();
        try {
            List<Comment> list = c.getCommentbyProjectID(Integer.parseInt(projectid));
            request.setAttribute("comment", list);
//            request.setAttribute("projectid", projectid);
            request.getRequestDispatcher("view/AddComment.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AddComment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String projectid = request.getParameter("projectid");
        String comment = request.getParameter("comment");
        CommentDAO c = new CommentDAO();
        int id;
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter formatedate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = formatedate.format(datetime);
        try {
            if (c.getAll().isEmpty()) {
                id = 1;
            } else {
                id = c.getAll().get(c.getAll().size() - 1).getId() + 1;
            }
            c.InsertProjectID(id, comment, date, Integer.parseInt(projectid));
        } catch (Exception ex) {
            Logger.getLogger(AddComment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}