/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.controlador;


import com.sebatec.dao.*;
import com.sebatec.modelo.Solicitud;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mi Laptop
 */
@WebServlet(name = "SolicitudController", urlPatterns = {"/SolicitudController"})
public class SolicitudController extends HttpServlet {

private Solicitud objSo; 
private SolicitudDAOFactory fabricate;
private SolicitudDAO daote;
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
            throws ServletException, IOException, DAOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion=request.getParameter("accion");
        fabricate=new SolicitudDAOFactory();
        System.out.println(".....1");
        daote=fabricate.metodoDAO();
        System.out.println(".....2");
        switch(accion){
            case "clienteSolicitud": 
                clienteSolicitud(request,response);                
                break;
            case "idClienteSolicitud":
                idclienteSolicitud(request,response);
                break;            
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
    try {
        processRequest(request, response);
    } catch (DAOException ex) {
        Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
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
    try {
        processRequest(request, response);
    } catch (DAOException ex) {
        Logger.getLogger(SolicitudController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void clienteSolicitud(HttpServletRequest request, HttpServletResponse response) throws DAOException {
       
        objSo = new Solicitud();

        objSo.getCliente().setNombre(request.getParameter("nombres"));
        objSo.getCliente().setApellido(request.getParameter("apellidos"));
        objSo.getCliente().setDni(request.getParameter("dni"));
        objSo.getCliente().setRazonSocial(request.getParameter("razon-social"));
        objSo.getCliente().setRuc(request.getParameter("ruc"));
        objSo.getCliente().setDireccion(request.getParameter("direccion"));
        objSo.getCliente().setTelefono(request.getParameter("telefono"));
        objSo.getCliente().setEmail(request.getParameter("email"));

        objSo.setDescripcion(request.getParameter("descripcion"));

        daote.crear(objSo);
    
    }

    private void idclienteSolicitud(HttpServletRequest request, HttpServletResponse response) throws IOException {
         response.sendRedirect("http://www.google.com.pe");
    }

}
