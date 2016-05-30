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

public class AboutServlet extends HttpServlet {

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
            		"\n" + 
            		"  <div id=\"about-body\">\n" + 
            		"\n" + 
            		"     <h2 id=\"about-title\">Company</h2>\n" + 
            		"     <div id=\"about-description\">\n" + 
            		"        <p>Thorne & Spindle was conjured up from the abyss of extreme depression resulting post-finals. As the four were wallowing in their despair, drowning in fail-fail cake along with unnamed friends, they thought up of the original idea of selling apparel!\n" + 
            		"        </p>\n" + 
            		"        <p>Thorne & Spindle is based in Irvine, California and was built up from a basement clothing store to a street vendor shop to an online, baller clothing store. Due to its recent conception, circa 2016, the company is looking on for new hires to whip into shape.\n" + 
            		"        </p>\n" + 
            		"        <p>Please apply by contacting us!</p>\n" + 
            		"    </div>\n" + 
            		"\n" + 
            		"    <h2 id=\"about-title\">About Our Products</h2>\n" + 
            		"    <div id=\"about-description\">\n" + 
            		"        <p>We specialize in bringing new and original designs onto the streets for holistic shoppers to view and wear with pride. All organic, freshly hand-picked cotton, the smooth and comfortable feeling of the apparel can be found nowhere else in the world. Our clothing inspires mountains to be moved and ballads to be written.\n" + 
            		"        </p>\n" + 
            		"    </div>\n" + 
            		"    <h2 id=\"about-title\">Tidbits About Each Stellar Member</h2>\n" + 
            		"    <div class=\"about-leftBio\">\n" + 
            		"        <img src=\"img/johnAvatar.jpg\" alt=\"Image of John\" />\n" + 
            		"        <p class=\"about-quote\">\"Hashmaps!\" - John</p>\n" + 
            		"        <ul class=\"about-ul\">\n" + 
            		"           <li>Computer Science major at UCI</li>\n" + 
            		"           <li>One of the rare specimens of bearded Asian men</li>\n" + 
            		"           <li>Enjoys long walks on the beach</li>\n" + 
            		"       </ul>\n" + 
            		"   </div>\n" + 
            		"   <div class=\"about-rightBio\">\n" + 
            		"    <img class=\"about-avatar\" src=\"img/kevinAvatar.png\" alt=\"Image of Kevin\" />\n" + 
            		"    <p class=\"about-quote\">\"Don't tell me what to do!\" - Kevin</p>\n" + 
            		"    <ul class=\"about-ul\">\n" + 
            		"       <li>Computer Science major at UCI</li>\n" + 
            		"       <li>A proud and voluptuous Pink Panda fanclub member</li>\n" + 
            		"       <li>Enjoys betting his life savings away (CS:GO)</li>\n" + 
            		"   </ul>\n" + 
            		"</div>\n" + 
            		"<div class=\"about-leftBio\">\n" + 
            		"    <img class=\"about-avatar\" src=\"img/samAvatar.jpg\" alt=\"Image of Sam\" /9>\n" + 
            		"    <p class=\"about-quote\">\"Not with that attitude.\" - Sam</p>\n" + 
            		"    <ul class=\"about-ul\">\n" + 
            		"       <li>Computer Science major at UCI</li>\n" + 
            		"       <li>Inhales Chipotle burritos like a beast</li>\n" + 
            		"       <li>LoLer</li>\n" + 
            		"   </ul>\n" + 
            		"</div>\n" + 
            		"<div class=\"about-rightBio\">\n" + 
            		"    <img class=\"about-avatar\" src=\"img/sophiaAvatar.jpg\" alt=\"Image of Sophia\" />\n" + 
            		"    <p class=\"about-quote\">\"...\" - Sophia</p>\n" + 
            		"    <ul class=\"about-ul\">\n" + 
            		"       <li>Software Engineer major at UCI</li>\n" + 
            		"       <li>Enjoys messing with her cat</li>\n" + 
            		"       <li>Sleeping is a hobby</li>\n" + 
            		"   </ul>\n" + 
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
