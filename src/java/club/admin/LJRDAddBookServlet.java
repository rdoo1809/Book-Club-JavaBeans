/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package club.admin;

import club.business.Book;
import club.data.BookIO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LJRDAddBookServlet", urlPatterns = {"/LJRDAddBook"})
public class LJRDAddBookServlet extends HttpServlet {

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
            String errorMessage = "";

            //fetch params
            String code = request.getParameter("code");
            String desc = request.getParameter("description");
            String strQuantity = request.getParameter("quantity");
            int quantity;
            
            try {
                quantity = Integer.parseInt(strQuantity);
            }
            catch (NumberFormatException e) {
                quantity = -1;
            }

            //check validations
            if (code.length() < 1) {
                errorMessage += "Book CODE is REQUIRED\n";
            }
            if (desc.length() < 3) {
                errorMessage += "Book DESCRIPTION must have at least 3 characters\n";
            }
            if (quantity <= 0) {
                errorMessage += "Quantity must be a POSITIVE NUMBER";
            }

            //if invalid inputs - back to add page remembering inputs
            if (errorMessage.length() != 0) {

                //display errors
                request.setAttribute("errorMessage", errorMessage);

                //set attributes to forward back to page
                //request.setAttribute("code", code);
                //request.setAttribute("desc", desc);
                //request.setAttribute("quantity", strQuantity);
                
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/LJRDAddBook.jsp");
                dispatcher.forward(request, response);
                
            } else {
                //add book using BookIO.insert method
                if (strQuantity == null) {
                    strQuantity = "0";
                    quantity = Integer.parseInt(strQuantity);
                }

                Book newBook = new Book(code, desc, quantity);

                BookIO.insert(newBook, path);

                //directs back to display books servlet - new book will now appear as well in list
                RequestDispatcher dispatcher = request.getRequestDispatcher("/LJRDDisplayBooks.jsp");
                dispatcher.forward(request, response);
            }
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
