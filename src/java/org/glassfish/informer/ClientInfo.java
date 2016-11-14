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
        response.setContentType("text/html;charset=utf-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(new StringBuilder("<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<title>ClientInfo</title>"
                    + "</head>"
                    + "<body>"
                    + "<h1>Servlet ClientInfo at " + request.getContextPath() + "</h1>"
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
