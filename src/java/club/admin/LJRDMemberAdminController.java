/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package club.admin;

import club.business.Member;
import club.data.MemberDB;
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
@WebServlet(name = "LJRDMemberAdminController", urlPatterns = {"/LJRDMemberAdmin"})
public class LJRDMemberAdminController extends HttpServlet {

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
        String action = request.getParameter("action");

        if ("displayMembers".equals(action)) {
            //get users from db
            ArrayList<Member> users = new ArrayList<Member>();

            users = MemberDB.selectMembers();

            request.setAttribute("users", users);
            //forward to jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("/LJRDDisplayMembers.jsp");
            dispatcher.forward(request, response);
            //
        } 
        if ("removeMember".equals(action)) {
            String email = request.getParameter("email");
            
            Member member = new Member();
            member = MemberDB.selectMember(email);
            
            request.setAttribute("member", member);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/LJRDRemove.jsp");
            dispatcher.forward(request, response);
        }
        if ("addMember".equals(action)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/LJRDRegister.jsp");
            dispatcher.forward(request, response);
        }
        if ("deleteMember".equals(action)) {
            String email = request.getParameter("email");
            Member user = new Member();
            user = MemberDB.selectMember(email);
            MemberDB.delete(user);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/LJRDMemberAdmin?action=displayMembers");
            dispatcher.forward(request, response);
        }
        if ("editMember".equals(action)) {
            String email = request.getParameter("email");
            
            Member member = new Member();
            member = MemberDB.selectMember(email);
            
            request.setAttribute("member", member);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/LJRDEditMember.jsp");
            dispatcher.forward(request, response);
        }
        if ("postEdit".equals(action)) {
            String email = request.getParameter("email");
            Member person = new Member();
            person = MemberDB.selectMember(email);
            MemberDB.update(person);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/LJRDMemberAdmin?action=displayMembers");
            dispatcher.forward(request, response);
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

        String url = saveMember(request, response);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    private String saveMember(HttpServletRequest request, HttpServletResponse response) {
        String url = "";
        //get input params
        String email = request.getParameter("email");
        String name = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String program = request.getParameter("itprogram");
        int year = Integer.parseInt(request.getParameter("yearlevel"));
        
        Member member = new Member();
        member.setFullName(name);
        member.setEmailAddress(email);
        member.setPhoneNumber(phone);
        member.setProgramName(program);
        member.setYearLevel(year);
        
        if(member.isValid()){
               //check if email exists
              if(!MemberDB.emailExists(email)){
                  //save to db
                  MemberDB.insert(member);
                  url = "/LJRDMemberAdmin?action=displayMembers";
              } else {
                  //update
                  MemberDB.update(member);
                  //email present
                  url = "/LJRDAdmin.jsp";   
              }        
         }else {
           //show errors 
            //member not valid
            url = "/LJRDError.jsp";
        }


        return url;
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
