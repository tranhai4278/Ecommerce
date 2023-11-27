/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.DAO;
import java.io.IOException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Category;
import model.Genres;
import model.Language;
import model.Product;
import model.Sale;

/**
 *
 * @author Nết
 */
@WebServlet(name="AddProductServlet", urlPatterns={"/add"})
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class AddProductServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao=new DAO();
         List<Genres> listG=dao.getAllGenres();
         List<Category> listC = dao.getCategory();
         List<Language> listL= dao.getAllLang();
         List<Sale> listS=dao.getSale();
         request.setAttribute("listG", listG);
         request.setAttribute("listC", listC);
         request.setAttribute("listL", listL);
         request.setAttribute("listS", listS);
         request.getRequestDispatcher("add-product.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         String name =request.getParameter("name");
         String description= request.getParameter("description");
         Part imgfile = request.getPart("file");
         String img= imgfile.getSubmittedFileName();
         for(Part part : request.getParts()){
             part.write("E:\\FPTU\\HK4\\PRJ301\\ProjectPRJ\\web\\img\\product\\"+img );
         }
         String price  = request.getParameter("price");
         String amount = request.getParameter("amount");
         String title =request.getParameter("title");
         String langid = request.getParameter("languageid");
         String catid =request.getParameter("categoryid");
         String saleid =request.getParameter("saleid");
         String sellDate =request.getParameter("sellDate");
         String[] genres =request.getParameterValues("genres");
         HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int cid = Integer.parseInt(catid);
        int lid = Integer.parseInt(langid);
        int sid = a.getId();
        if (cid==3){
            lid=0;
        }
        DAO dao=new DAO();
   
        List<Genres> list = new ArrayList<>();
        try {
            if (genres != null) {
                for (String i : genres) {
                    list.add(new Genres(Integer.parseInt(i), ""));
                }
            }
         Product p =new Product(name, img, title, description, cid, sid, list);
         dao.addProduct(p,lid, saleid, sellDate, amount, price);
        } catch ( NumberFormatException e) {
            System.out.println(e);
        }
        response.sendRedirect("product");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
