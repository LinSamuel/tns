/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tns.*;
/**
 *
 * @author Kevin
 */

public class ContactServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Template.printHeader(out);
            Template.printBody(out, "</div>\n" + 
            		"\n" + 
            		"<div class=\"row\">\n" + 
            		"  <div id=\"contact-body\">\n" + 
            		"   <table id=\"contact-table\">\n" + 
            		"    <tr>\n" + 
            		"     <td>\n" + 
            		"      <h2>Headquarters</h2>\n" + 
            		"      <p>5347 Aldrich Drive,</p>\n" + 
            		"      <p>Irvine, CA, 92617</p>\n" + 
            		"      <p>United States</p>\n" + 
            		"\n" + 
            		"      <h2>Phone</h2>\n" + 
            		"      <p>(949) 555-0187</p>\n" + 
            		"\n" + 
            		"      <h2>Email</h2>\n" + 
            		"      <p>contactUs@tns.com</p>\n" + 
            		"    </td>\n" + 
            		"    <td>\n" + 
            		"      <table id=\"contact-store-hours-table\">\n" + 
            		"       <tr>\n" + 
            		"        <div id=\"contact-store-hours-table-title\">\n" + 
            		"         <h2>Store Hours</h2>\n" + 
            		"       </div>\n" + 
            		"       <td>\n" + 
            		"         <div class=\"contact-days\">\n" + 
            		"          <p>Sunday</p>\n" + 
            		"          <p>Monday</p>\n" + 
            		"          <p>Tuesday</p>\n" + 
            		"          <p>Wednesday</p>\n" + 
            		"          <p>Thursday</p>\n" + 
            		"          <p>Friday</p>\n" + 
            		"          <p>Saturday</p>\n" + 
            		"        </div>\n" + 
            		"      </td>\n" + 
            		"      <td>\n" + 
            		"       <div class=\"contact-time\">\n" + 
            		"        <p>10:00AM - 8:00PM</p>\n" + 
            		"        <p>10:00AM - 9:00PM</p>\n" + 
            		"        <p>10:00AM - 9:00PM</p>\n" + 
            		"        <p>10:00AM - 9:00PM</p>\n" + 
            		"        <p>10:00AM - 9:00PM</p>\n" + 
            		"        <p>10:00AM - 9:00PM</p>\n" + 
            		"        <p>9:00AM - 9:00PM</p>\n" + 
            		"      </div>\n" + 
            		"    </td>\n" + 
            		"  </tr>\n" + 
            		"</table>\n" + 
            		"</td>\n" + 
            		"</tr>\n" + 
            		"</table>\n" + 
            		"<div id=\"contact-cs-hours\">\n" + 
            		"  <h2>Customer Support Hours</h2>\n" + 
            		"  <p>24/7</p>\n" + 
            		"</div>\n" + 
            		"</div>\n" + 
            		"</div>");
            Template.printFooter(out);
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
