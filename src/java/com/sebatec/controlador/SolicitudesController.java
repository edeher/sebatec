/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sebatec.controlador;

import com.sebatec.config.BaseHTTPServlet;
import com.sebatec.config.Message;
import com.sebatec.dao.factory.DAOException;
import com.sebatec.dao.factory.SolicitudDAOFactory;
import com.sebatec.dao.interfaces.SolicitudDAO;
import com.sebatec.enums.EstadoSolicitud;
import com.sebatec.modelo.Solicitud;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
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
            throws ServletException, IOException, DAOException {
        setupTiles(request, response);
        HttpSession sesion = request.getSession(true);
        String accion = request.getParameter("accion");
        if(accion!=null){
            if (accion.equals("lista")) {
                listar(request, response);
            } 
            if (accion.equals("nuevo")) {
                nuevo(request, response);
            } 
            if (accion.equals("editar")) {
                editar(request, response);
            } 
            if (accion.equals("crear")) {
                actualizar(request, response);
            }  
            if (accion.equals("modificar")) {
                actualizar(request, response);
            }  
            if (accion.equals("listaJson")) {
                listaJson(request, response);
            } 
            if (accion.equals("info")) {
                verInfo(request, response);
            } 
        }else{
            listar(request, response);
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
            Logger.getLogger(SolicitudesController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SolicitudesController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void nuevo(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("titulo", "Nuevo Registro");
    	request.setAttribute("accion", "crear");
        container.render("solicitudes/form", request, response);
        container.endContext(request, response);
    }
    private void editar(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("titulo", "Editar Registro");
    	request.setAttribute("accion", "modificar");
        container.render("solicitudes/form", request, response);
        container.endContext(request, response);
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws DAOException, ServletException, IOException {
        String idsol = request.getParameter("param_idsol");
        //String idcli = request.getParameter("param_idcli");
        //String idper = request.getParameter("param_idper");
        String descripcion = request.getParameter("param_descripcion");
        //date solicitud
        //String observacion = request.getParameter("param_observacion");
        //String estadosol = request.getParameter("param_estadosol");        
        String razonsocial = request.getParameter("param_razonsocial");
        String ruc = request.getParameter("param_ruc");   
        //estado cliente
        String nombre = request.getParameter("param_nombre");
        String apellido = request.getParameter("param_apellido");  
        String dni = request.getParameter("param_dni");
        String direccion = request.getParameter("param_direccion");
        String telefono = request.getParameter("param_telefono");
        String email = request.getParameter("param_email");       
        if (idsol == null || idsol.equals("")) { // crear    			
            SolicitudDAOFactory sdf = new SolicitudDAOFactory();
            SolicitudDAO sold = sdf.metodoDAO();            
            Solicitud sol = new Solicitud();            
            sol.setDescripcion(descripcion);
            //sol.setObservacion(observacion);
            sol.setEstadoSolicitud(EstadoSolicitud.ES);
            if(ruc.equals("")){                
                sol.getSolicitante().setDireccion(direccion);  
            }else{
                sol.getSolicitante().getEmpresa().setRuc(ruc);
                sol.getSolicitante().getEmpresa().setRazon(razonsocial);
                sol.getSolicitante().getEmpresa().setDireccion(direccion);
            }  
            sol.getSolicitante().setNombre(nombre);
            sol.getSolicitante().setApellido(apellido);
            sol.getSolicitante().setDni(dni);                          			
            sol.getSolicitante().setTelefono(telefono);                			
            sol.getSolicitante().setEmail(email);             
            sol = sold.crear(sol);            
            // mensaje
            Message message = new Message("success", "Exito al registrar la solicitud");
            request.setAttribute("message", message);     
            // redirect             
            getServletContext().getRequestDispatcher( "/Solicitudes?accion=lista" ).forward(request, response);            
        }/* else { 
            // update            
            Book book = bookService.findById(Integer.parseInt(id));
            book.setTitle(title);
            book.setAuthor(author);
            book.setIsbn(isbn);
            book.setDescription(description);
            book.setYear(year);
            book.setPages(pages);
            book.setPrice(price);
            book.setPicture(picture);
            book.setFormat(format);    			
            Category category = categoryService.findById(categoryId);
            book.setCategory(category);    			
            bookService.save(book);    			
            // mensaje
            Message message = new Message("success", "Exito al actualizar el libro");
            request.setAttribute("message", message);     
            // redirect
            getServletContext().getRequestDispatcher( "/book?action=edit&id=" + id ).forward(request, response);            
        } 
        */
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {
        container.render("solicitudes/lista", request, response);
        container.endContext(request, response); 
    }

    private void listaJson(HttpServletRequest request, HttpServletResponse response) throws DAOException, IOException {
        SolicitudDAOFactory sdf = new SolicitudDAOFactory();
        SolicitudDAO sold = sdf.metodoDAO();
        Solicitud[] solv = sold.leertodo();         
        JsonObjectBuilder objbuilder = Json.createObjectBuilder();  
        JsonArrayBuilder  arraySolicitudes = Json.createArrayBuilder();        
        JsonArrayBuilder  arrayDatosSolicitudes;        
        for (Solicitud solicitud : solv) {
            arrayDatosSolicitudes = Json.createArrayBuilder();
            arrayDatosSolicitudes.add(solicitud.getIdSolicitud());
            arrayDatosSolicitudes.add(solicitud.getSolicitante().getNombre()+" "+solicitud.getSolicitante().getApellido());            
            if(solicitud.getSolicitante().getEmpresa().getRazon()==null){
                arrayDatosSolicitudes.add("");              
            }  
            else{
                arrayDatosSolicitudes.add(solicitud.getSolicitante().getEmpresa().getRazon());
            }
            arrayDatosSolicitudes.add(DateToString(solicitud.getFecha()));  
            arrayDatosSolicitudes.add(solicitud.getEstadoSolicitud().getNom());  
            arraySolicitudes.add(arrayDatosSolicitudes);
        }
        objbuilder.add("data", arraySolicitudes);
        JsonObject obj = objbuilder.build();
        response.setContentType("application/json");
       
        try (PrintWriter pw = new PrintWriter(response.getOutputStream())) {
            pw.println(obj.toString()); 
        }
    }
    
    private void verInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher( "/WEB-INF/views/solicitudes/info.jsp" ).forward(request, response);
    }
    
    private String DateToString(Date fecha) {
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }
}
