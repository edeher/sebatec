package com.sebatec.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

/**
 * Servlet implementation class BaseHTTPServlet
 */
public class BaseHTTPServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public TilesContainer container = null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseHTTPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void setupTiles(HttpServletRequest request, HttpServletResponse response){
    	container = TilesAccess.getContainer(request.getSession().getServletContext());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
