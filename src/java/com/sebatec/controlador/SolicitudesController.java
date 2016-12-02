/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sebatec.controlador;

import com.sebatec.config.BaseHTTPServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fn
 */
@WebServlet(name = "SolicitudesController", urlPatterns = {"/Solicitudes"})
public class SolicitudesController extends BaseHTTPServlet {

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
        setupTiles(request, response);
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        if(action!=null){
            switch(action){
                case "nuevo":
                    create(request,response);
                    break;
                case "crear":
                    update(request,response);
                    break;
            }        
        }else{
            container.render("solicitudes/lista", request, response);
            container.endContext(request, response); 
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

    private void create(HttpServletRequest request, HttpServletResponse response) {
        container.render("solicitudes/nuevo", request, response);
        container.endContext(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        container.render("solicitudes/nuevo", request, response);
        container.endContext(request, response);
    }

}
