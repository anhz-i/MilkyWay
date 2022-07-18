/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.ProjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Project;
import model.User;

/**
 *
 * @author Hp
 */
@WebServlet(name = "ProjectCheck", urlPatterns = {"/projectcheck"})
public class ProjectCheck extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ProjectDAO p = new ProjectDAO();
        int check = 0;
        try {
            Project project = p.getProject(Integer.parseInt(id));
            if (project.getEmail() == null) {
                response.sendRedirect("project");
            }
            List<String> listemail = p.getEmailPermission(Integer.parseInt(id));
            for (String item : listemail) {
                if ( item.trim().equals(user.getEmail().trim())) {
                    check = 1;
                }
            }
            if (project.getEmail().trim().equals(user.getEmail().trim()) || check == 1) {
//                if (project.getView().trim().equals("list")) {
//                response.sendRedirect("projectlist?id=" + id);
                    request.getRequestDispatcher("projectlist?id=" + id).forward(request, response);
//                } else {
//                    request.getRequestDispatcher("view/board.jsp").forward(request, response);
//                }
            }
//            request.getRequestDispatcher("project").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ProjectCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
