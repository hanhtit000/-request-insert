/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import dal.DBContext;
import dal.EmpDBContext;
import dal.RequestDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import model.AnualRequest;
import model.Emp;

/**
 *
 * @author ASUS
 */
public class InsertController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DBContext<Emp> e = new EmpDBContext();
        ArrayList<Emp> list= e.list();
        request.setAttribute("listEmp", list);
        request.getRequestDispatcher("/request/insert.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String reason= (String) request.getParameter("reason");
        Date from= Date.valueOf(request.getParameter("from"));
        Date to= Date.valueOf(request.getParameter("to"));
        int crt = Integer.parseInt(request.getParameter("create"));
        int rvw = Integer.parseInt(request.getParameter("review"));
        AnualRequest a = new AnualRequest();
        a.setReason(reason);
        a.setFrom_date(from);
        a.setTo_date(to);
        a.setCreated_by(crt);
        a.setReviewed_by(rvw);
        a.setStatus("Pending");
        RequestDBContext e = new RequestDBContext();
        e.insert(a);
        request.setAttribute("added", a);
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
