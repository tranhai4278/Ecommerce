/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Cart;
import model.Category;
import model.Genres;
import model.Item;
import model.Product;

/**
 *
 * @author Nết
 */
@WebServlet(name = "StoreServlet", urlPatterns = {"/store"})
public class StoreServlet extends HttpServlet {

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
        DAO dao = new DAO();
        List<Category> listC = dao.getCategory();
        List<Genres> listG = dao.getAllGenres();
        List<Product> listP = dao.getTop6();
        
        request.setAttribute("listP", listP);
        request.setAttribute("listC", listC);
        request.setAttribute("listG", listG);
        request.getRequestDispatcher("store.jsp").forward(request, response);
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
        String sort = request.getParameter("sort");
        DAO dao = new DAO();
        List<Category> listC = dao.getCategory();
        List<Genres> listG = dao.getAllGenres();
        request.setAttribute("listC", listC);
        request.setAttribute("listG", listG);
        request.setAttribute("sort", sort);
        switch (sort) {
            case "1": {
                List<Product> listP = dao.getProA();
                request.setAttribute("listP", listP);
                request.getRequestDispatcher("store.jsp").forward(request, response);
                break;
            }
            case "2": {
                List<Product> listP = dao.getProD();
                request.setAttribute("listP", listP);
                request.getRequestDispatcher("store.jsp").forward(request, response);
                break;
            }
            case "0": {
                response.sendRedirect("store");
            }
        }

        // Chỉnh lại đích của forward
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
