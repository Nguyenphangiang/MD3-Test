package controller;

import DAO.CategoryDAO;
import DAO.ICategoryDAO;
import DAO.IProductDAO;
import DAO.ProductDAO;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private IProductDAO productDAO;
    private ICategoryDAO categoryDAO;
    public void init(){
        productDAO = new ProductDAO();
        categoryDAO = new CategoryDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "add":
                showFormAddProduct(request,response);
                break;
            case "edit":
                showFormEditProduct(request,response);
                break;
            case "delete":
                showFormDeleteProduct(request,request);
                break;
            default:
                showAllListProduct(request,response);
                break;
        }
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "add":
                addNewProduct(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:

        }
    }




    private void showFormEditProduct(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showFormAddProduct(HttpServletRequest request, HttpServletResponse response) {
    }
    private void showAllListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/listProduct.jsp");
        List<Product> products = productDAO.showAll();
        request.setAttribute("products",products);
        dispatcher.forward(request,response);
    }

    private void showFormDeleteProduct(HttpServletRequest request, HttpServletRequest request1) {
    }

    private void addNewProduct(HttpServletRequest request, HttpServletResponse response) {
    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
    }

}
