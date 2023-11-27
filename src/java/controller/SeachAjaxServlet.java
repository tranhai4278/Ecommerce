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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Category;
import model.Genres;
import model.Product;

/**
 *
 * @author Nết
 */
@WebServlet(name = "SeachAjaxServlet", urlPatterns = {"/searchajax"})
public class SeachAjaxServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String txt = request.getParameter("txt");
        DAO dao = new DAO();
        List<Product> list = dao.searchByName(txt);
        for (Product o : list) {
            out.println("<div class=\"col-md-4 col-xs-6\">\n"
                    + "                                    <div class=\"product\">\n"
                    + "                                        <div class=\"product-img\">\n"
                    + "                                            <img src=\"./img/product/" + o.getImg() + "\" alt=\" \" height=\"400px\" width=\"auto\">\n"
                    + "                                            <div class=\"product-label\">\n"
                    + "                                            </div>                     \n"
                    + "                                        </div>\n"
                    + "                                        <div class=\"product-body\">\n"
                    + "                                            <p class=\"product-category\">" + o.getTitle() + "</p>\n"
                    + "                                            <h3 class=\"product-name\"><a href=\"detail?pid=" + o.getId() + "\">" + o.getName() + "</a></h3>\n"
                    + "                                            <h4 class=\"product-price\">" + o.getPd().getPrice() + "00đ </h4>\n"
                    + "\n"
                    + "                                            <div class=\"product-btns\">\n"
                    + "                                                <button class=\"quick-view\"><i class=\"fa fa-eye\"></i><span class=\"tooltipp\">quick view</span></button>\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "                                        <div class=\"add-to-cart\">\n"
                    + "                                            <button class=\"add-to-cart-btn\"><i class=\"fa fa-shopping-cart\"></i> add to cart</button>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                </div>");
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