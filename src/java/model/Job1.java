/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hp
 */
import DAL.SendEmail;
import DAL.TaskDAO;
import DAL.UserDAO;
import controller.todayservlet;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Job1 implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String mes = "";
        System.out.println("Job1 --->>> Time is " + new Date());
        String dueDate = LocalDate.now().toString();
        TaskDAO td = new TaskDAO();
        UserDAO u = new UserDAO();
        try {
            List<User> listu = u.getAll();
            for (User item : listu) {
                mes = "Tasks for day:<br>";
                List<Task> list = td.searchTaskbyDueDate(dueDate, item.getEmail());
                for (Task it : list) {
                    mes = mes + it.getName() + ": " + it.getDescription() + "<br>";
                }
                if (list != null) {
                    SendEmail.send(item.getEmail(), "MilkyWay Remind", mes, "anhkthhe160643@fpt.edu.vn", "Kkkkk1312@");
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(Job1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
