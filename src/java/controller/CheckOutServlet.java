/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAO;
import dao.OrderDAO;
import dao.OrderLineDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Account;
import model.AccountDetail;
import model.Order;
import model.OrderLine;
import model.Product;

/**
 *
 * @author Nết
 */
@WebServlet(name = "CheckOutServlet", urlPatterns = {"/checkout"})
public class CheckOutServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckOutServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOutServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        List<OrderLine> cart = deserializeCart(request);
        int sum = 0;
        for (OrderLine o : cart) {
            sum += o.getDetailtotal();
        }
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int id = a.getId();
        AccountDetail profile = dao.getAccDetail(id);
        System.out.println(profile);
        request.setAttribute("profile", profile);
        request.setAttribute("sizeOfCart", cart.size());
        request.setAttribute("total", sum);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
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
          OrderDAO odb = new OrderDAO();
        OrderLineDAO oddb = new OrderLineDAO();
        DAO dao = new DAO();
        HttpSession session=request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int userId = a.getId();
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String total_raw = request.getParameter("total");
        
        String note = request.getParameter("note");
        int total = Integer.parseInt(total_raw);
        if (name ==null || name.equals("") ||
        phone ==null || phone.equals("") ||address ==null || address.equals("")){
            request.setAttribute("err", "Chưa nhập đủ thông tin");
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
         } 
        Order o = new Order(0, userId, null, total, address, phone, note, name);
        odb.insertOrderByAid(o);
        int orderID = odb.getLastOrderId();
        String[] pid = request.getParameterValues("pid");
        String[] amount = request.getParameterValues("amount");
        String[] detailTotal = request.getParameterValues("detailtotal");
        for (int i = 0; i < pid.length; i++) {
            oddb.insertOrderDetail(orderID, pid[i], amount[i], detailTotal[i]);
            Product pm = dao.getProductbyId(pid[i]);
            int soldQuantity = Integer.parseInt(amount[i]);
            dao.updateQuantity(pid[i], pm.getPd().getAmount()-soldQuantity);
        }
        Cookie cart = Arrays.stream(request.getCookies())
                .filter(c -> c.getName().equals("cart"))
                .findFirst().orElse(new Cookie("cart", ""));
        cart.setMaxAge(0);
        response.addCookie(cart);
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
