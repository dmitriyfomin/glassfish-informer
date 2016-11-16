package org.glassfish.informer;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Dmitry Fomin
 */
@WebServlet(name = "ClientInfo", urlPatterns = {"/"})
public class ClientInfo extends HttpServlet {

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
        /* Set up server name in HTTP header (default GlassFish) */
        response.setHeader("server", "Informer");
        /* Set up caching */
        response.setHeader("cache-control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
        response.setContentType("text/html;charset=utf-8");
        try (PrintWriter pw = response.getWriter()) {
            pw.println(new StringBuilder("<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<title>ClientInfo</title>"
                    + "</head>"
                    + "<body>"
                    + "<h1>Servlet ClientInfo at " + request.getContextPath() + "</h1><br/>"
                    + "<h5>IP: " + request.getRemoteAddr() + "</h1><br/>"
                    + "<h5>User-Agent: " + request.getHeader("user-agent") + "</h1><br/>"
                    + "</body>"
                    + "</html>"));
        }
    }
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
}
