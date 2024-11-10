/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package club.admin;

import club.business.Book;
import club.data.BookIO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ryan
 */
@WebServlet(name = "LJRDDisplayBooksServlet", urlPatterns = {"/LJRDDisplayBooks"})
public class LJRDDisplayBooksServlet extends HttpServlet {

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

            String path = getServletContext().getRealPath("/WEB-INF/books.txt");
            ArrayList<Book> books = BookIO.getBooks(path);
            request.setAttribute("books", books);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/LJRDDisplayBooks.jsp");
    dispatcher.forward(request, response);

            
          /*  out.println("<%@ include page=\"/LJRDBanner.jsp\" %>");
            out.println("<h1>List of Books</h1>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<th>Code</th>");
            out.println("<th>Description</th>");
            out.println("<th>Quantity</th>");
            out.println("</tr>");

            for (Book book : books) {
                out.println("<tr>");
                out.println("<td>" + book.getCode() + "</td>");
                out.println("<td>" + book.getDescription() + "</td>");
                out.println("<td>" + book.getQuantity() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("<jsp:include page=\"LJRDFooter.jsp\" />"); */
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
