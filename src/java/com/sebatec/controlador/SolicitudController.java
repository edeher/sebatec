
package com.sebatec.controlador;


import com.sebatec.dao.DAOException;
import com.sebatec.dao.SolicitudDAO;
import com.sebatec.dao.SolicitudDAOFactory;
import com.sebatec.modelo.Solicitud;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
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
@WebServlet(name = "SolicitudController", urlPatterns = {"/SolicitudController"})
public class SolicitudController extends HttpServlet {

private Solicitud objSo; 
private SolicitudDAOFactory fabricate;
private SolicitudDAO daote;    
 private RequestDispatcher rd=null;
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, DAOException {
    response.setContentType("text/html;charset=UTF-8");
  
    String accion=request.getParameter("accion");
    fabricate=new SolicitudDAOFactory();
    daote=fabricate.metodoDAO();
    switch (accion) {
        case "crearSolicitudConCliente":
            crearSolicitudConCliente(request, response);
            break;
        case "crearSolicitudSinCliente":
            crearSolicitudSinCliente(request, response);
            break;
        case "obtenerTodasSolicitudes":
            obtenerTodasSolicitudes(request, response);
            break;
        case "obtenerTodasSolicitudesJson":
            obtenerTodasSolicitudesJson(request, response);
            break;
        case "obtenerSolicitud":
            obtenerSolicitud(request, response);
            break;
        case "modificarSolicitud":
            modificarSolicitud(request, response);
            break;
        case "rechazarSolicitud":
            rechazarSolicitud(request, response);
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

    private void crearSolicitudConCliente(HttpServletRequest request, HttpServletResponse response) throws DAOException, IOException, ServletException {
        objSo = new Solicitud();
        objSo.getCliente().setNombre(request.getParameter("nombres"));
        objSo.getCliente().setApellido(request.getParameter("apellidos"));
        objSo.getCliente().setDni(request.getParameter("dni"));
        objSo.getCliente().setRazonSocial(request.getParameter("razonsocial"));
        objSo.getCliente().setRuc(request.getParameter("ruc"));
        objSo.getCliente().setDireccion(request.getParameter("direccion"));
        objSo.getCliente().setTelefono(request.getParameter("telefono"));
        objSo.getCliente().setEmail(request.getParameter("email"));
        objSo.setDescripcion(request.getParameter("descripcion"));

        Solicitud Soli = daote.crearLeer(objSo);
        System.out.println("solicitud:" + Soli.toString());
        request.setAttribute("Soli", Soli);

        rd = getServletContext().getRequestDispatcher("/Prototipos/CRearYLeerREspuesta.jsp");
        rd.forward(request, response);
        
    }

    private void crearSolicitudSinCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, DAOException, ServletException {
        objSo= new Solicitud();  
        int idCliente=Integer.parseInt(request.getParameter("idcliente"));
        objSo.setDescripcion(request.getParameter("descripcion"));
                
            Solicitud Soli=daote.crearLeer(objSo,idCliente);
            System.out.println("solicitud:" + Soli.toString());
        request.setAttribute("Soli", Soli);

        rd = getServletContext().getRequestDispatcher("/Prototipos/CRearYLeerREspuesta.jsp");
        rd.forward(request, response);
    }

    private void obtenerTodasSolicitudes(HttpServletRequest request, HttpServletResponse response) throws DAOException, ServletException, IOException {
        Solicitud[] solv=daote.leertodo();
        request.setAttribute("solv", solv);
        rd = getServletContext().getRequestDispatcher("/Prototipos/BuscarRespuesta.jsp");
        rd.forward(request, response);
    }
    
    private void obtenerTodasSolicitudesJson(HttpServletRequest request, HttpServletResponse response) throws DAOException, ServletException, IOException {
        Solicitud[] solv = daote.leertodo();         
        JsonObjectBuilder objbuilder = Json.createObjectBuilder();  
        JsonArrayBuilder  arraySolicitudes = Json.createArrayBuilder();        
        JsonArrayBuilder  arrayDatosSolicitudes;        
        for (Solicitud solicitud : solv) {
            //System.out.println(solicitud.toString());            
            arrayDatosSolicitudes = Json.createArrayBuilder();
            arrayDatosSolicitudes.add(solicitud.getIdSolicitud());
            arrayDatosSolicitudes.add(solicitud.getCliente().getNombre());
            arrayDatosSolicitudes.add(solicitud.getCliente().getDni());
            arrayDatosSolicitudes.add(solicitud.getDescripcion());
            arrayDatosSolicitudes.add(solicitud.getCliente().getTelefono());                        
            arraySolicitudes.add(arrayDatosSolicitudes);
        }
        objbuilder.add("data", arraySolicitudes);
        JsonObject obj = objbuilder.build();
        response.setContentType("application/json");
       
        try (PrintWriter pw = new PrintWriter(response.getOutputStream())) {
            pw.println(obj.toString()); 
        }
    }

    private void obtenerSolicitud(HttpServletRequest request, HttpServletResponse response) throws DAOException, ServletException, IOException {
          int idSolicitud=Integer.parseInt(request.getParameter("idSolicitud"));
          
          Solicitud [] solv= daote.leerxxid(idSolicitud);
              
          request.setAttribute("solv",solv);

        rd = getServletContext().getRequestDispatcher("/Prototipos/BuscarRespuesta.jsp");
        rd.forward(request, response);
    }

    private void modificarSolicitud(HttpServletRequest request, HttpServletResponse response) throws DAOException, ServletException, IOException {
        System.out.println("entrando al servlet");
        
        objSo = new Solicitud();
        
        objSo.setIdSolicitud(Integer.parseInt(request.getParameter("idSolicitud")));
       
        objSo.setDescripcion(request.getParameter("descripcion"));
        objSo.setObservacion(request.getParameter("observacion"));
        
        
        
        System.out.println("codigo 1 " + objSo.getIdSolicitud());
        System.out.println("objeto " + objSo.getCliente().getIdCliente());

        
        
        Solicitud Soli = daote.modificarLeer(objSo);
        System.out.println("codigo 2 " + objSo.getIdSolicitud());
        System.out.println("objeto " + Soli.toString());
        
    }

    private void rechazarSolicitud(HttpServletRequest request, HttpServletResponse response) throws DAOException {
        
               int idSolicitud=Integer.parseInt(request.getParameter("idSolicitud"));
		Solicitud per= daote.modificarLeer(idSolicitud);
    }

}
