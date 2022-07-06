/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.SendEmail;
import DAL.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Hp
 */
@WebServlet(name = "ForgerPass", urlPatterns = {"/forgetpass"})
public class ForgerPass extends HttpServlet {

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
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("authuser");
        SendEmail sm = new SendEmail();

        //get the 6-digit code
        String code = sm.getRandom();

        //craete new user using all information
        User user = new User(null, u.getEmail(), u.getPassword(), code);

        SendEmail.send(u.getEmail(), "Verify your account", "Your code to verify account: " + code, "anhkthhe160643@fpt.edu.vn", "Kkkkk1312@");
        session.setAttribute("authuser", user);
        request.setAttribute("mes", "Check your Mail!");
        response.sendRedirect("verifyaccount");
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
        request.getRequestDispatcher("view/forgetpass.jsp").forward(request, response);

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
        String email = request.getParameter("email");

        UserDAO u = new UserDAO();
        User user;

        try {
            user = u.getUserbyEmail(email);
            if (user == null) {
                request.setAttribute("error", "Email doesn't exist!");
                request.getRequestDispatcher("view/forgetpass.jsp").forward(request, response);

            } else {
                SendEmail sm = new SendEmail();
                String npass = sm.getRamdomString();
                SendEmail.send(email, "New password", "Your new password: " + npass, "anhkthhe160643@fpt.edu.vn", "Kkkkk1312@");
                u.Update(user.getName(), email, npass);
                request.setAttribute("mes", "Check your Mail!");
                request.getRequestDispatcher("view/login.jsp").forward(request, response);

            }
        } catch (Exception ex) {
            Logger.getLogger(SendCodeAgain.class.getName()).log(Level.SEVERE, null, ex);
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
