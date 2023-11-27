/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAO;
import dao.OrderLineDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Category;
import model.Genres;
import model.OrderLine;
import model.Product;

/**
 *
 * @author Nết
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

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
        DAO dao = new DAO();
        List<Category> listC = dao.getCategory();
        List<OrderLine> cart = deserializeCart(request);
        int sum = 0;
        for (OrderLine o : cart) {
            sum += o.getDetailtotal();
        }
        request.setAttribute("sizeOfCart", cart.size());
        request.setAttribute("total", sum);
        request.setAttribute("listC", listC);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
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
        String id = request.getParameter("pid");
        String quantityParam = request.getParameter("quantity");
        String action = request.getParameter("action");
        int quantity = quantityParam == null ? 0 : Integer.parseInt(quantityParam);
        Cookie cart = Arrays.stream(request.getCookies())
                .filter(c -> c.getName().equals("cart"))
                .findFirst().orElse(new Cookie("cart", ""));
        if (action != null && action.equals("add")) {
            addToCart(cart, id, quantity);
            cart.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cart);
            response.sendRedirect("store");
        } else {
            removeFromCart(cart, id);
            cart.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cart);
            response.sendRedirect("cart");
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

    private void addToCart(Cookie cart, String id, int quantity) {
        removeFromCart(cart, id);
        String cartValue = cart.getValue();
        cartValue += (cartValue.isEmpty()
                ? "{"
                : "_{")
                + id + "_" + quantity + "}";
        cart.setValue(cartValue);
    }

    private void removeFromCart(Cookie cart, String id) {
        String cartValue = cart.getValue();
        String regex = "\\{" + id + "_\\d+\\}_*";
        cartValue = cartValue.replaceAll(regex, "");
        cart.setValue(cartValue);
    }

    private List<OrderLine> deserializeCart(HttpServletRequest request) {
        Map<Integer, Integer> raw = new HashMap<>();
        Cookie cartCookie = Arrays.stream(request.getCookies())
                .filter(c -> c.getName().equals("cart"))
                .findFirst().orElse(new Cookie("cart", ""));
        String cartValue = cartCookie.getValue();
        while (cartValue.contains("{")) {
            int id = Integer.parseInt(
                    cartValue.substring(
                            cartValue.indexOf("{") + 1,
                             cartValue.indexOf("_")));
            int quantity = Integer.parseInt(
                    cartValue.substring(
                            cartValue.indexOf("_") + 1,
                             cartValue.indexOf("}")));
            raw.put(id, quantity);
            String regex = "\\{" + id + "_\\d+\\}_*";
            cartValue = cartValue.replaceAll(regex, "");
        }
        OrderLineDAO orderDetailDAO = new OrderLineDAO();
        List<OrderLine> result = orderDetailDAO.getByProductModelIds(raw.keySet());
        System.out.println(result);
        for (OrderLine orderDetail : result) {
            orderDetail.setAmount(raw.get(orderDetail.getPid()));
        }
        for (OrderLine orderDetail : result) {
            orderDetail.setDetailtotal(orderDetail.getPrice() * orderDetail.getAmount());
        }
        return result;

    }

}
