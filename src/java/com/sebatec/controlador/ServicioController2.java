/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.controlador;

import com.sebatec.dao.DAOException;
import com.sebatec.dao.ServicioDAO;
import com.sebatec.dao.ServicioDAOFactory;
import com.sebatec.modelo.Servicio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mi Laptop
 */
@WebServlet(name = "ServicioController2", urlPatterns = {"/ServicioController2"})
public class ServicioController2 extends HttpServlet {
private ServicioDAOFactory fabricate;
private ServicioDAO daote;
private Servicio objSer;
private RequestDispatcher rd=null;
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
        fabricate=new ServicioDAOFactory();
        daote=fabricate.metodoDAO();
        
        switch(accion)
        {
            case "crearServicio":
                crearServicio(request, response);
                break;
            case "obtenerTodasServicios":
                obtenerTodasServicios(request, response);
                break;
            case "obtenerServiciosPorTecnico":
                obtenerServiciosPorTecnico(request, response);
                break;
            case "obtenerServicio":
                obtenerServicio(request, response);
                break;
            case "modificarServicio":
                modificarServicio(request, response);
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
        Logger.getLogger(ServicioController2.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(ServicioController2.class.getName()).log(Level.SEVERE, null, ex);
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

    private void crearServicio(HttpServletRequest request, HttpServletResponse response) throws DAOException, ServletException, IOException {
        objSer =new Servicio();
        objSer.getSolicitud().setIdSolicitud(Integer.parseInt(request.getParameter("solicitud")));
        objSer.getTecnico().setIdTecnico(Integer.parseInt(request.getParameter("tecnico")));
        objSer.setDescripcion(request.getParameter("descripcion"));
        
        Servicio Serv=daote.crearLeer(objSer);
        request.setAttribute("Serv", Serv);

        rd = getServletContext().getRequestDispatcher("/Prototipos/ServicioCrearRespuesta.jsp");
        rd.forward(request, response);
    }

    private void obtenerTodasServicios(HttpServletRequest request, HttpServletResponse response) throws DAOException, ServletException, IOException {
       Servicio[] Serv=daote.leertodo();
          request.setAttribute("Serv", Serv);

        rd = getServletContext().getRequestDispatcher("/Prototipos/serviciobuscarRespuesta.jsp");
        rd.forward(request, response);
    }

    private void obtenerServiciosPorTecnico(HttpServletRequest request, HttpServletResponse response) throws DAOException, ServletException, IOException {
       int idTecnico=Integer.parseInt(request.getParameter("idTecnico"));
          
          Servicio[] Serv= daote.leerTodoTecnico(idTecnico);
              
          request.setAttribute("Serv",Serv);

        rd = getServletContext().getRequestDispatcher("/Prototipos/serviciobuscarRespuesta.jsp");
        rd.forward(request, response); 
    }

    private void obtenerServicio(HttpServletRequest request, HttpServletResponse response) throws DAOException, ServletException, IOException {
        int idServicio=Integer.parseInt(request.getParameter("idServicio"));
          
         Servicio[] Serv= daote.leerxxid(idServicio);
              
          request.setAttribute("Serv",Serv);

        rd = getServletContext().getRequestDispatcher("/Prototipos/serviciobuscarRespuesta.jsp");
        rd.forward(request, response);
    }

    private void modificarServicio(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
