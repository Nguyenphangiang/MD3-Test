package controller;

import DAO.CategoryDAO;
import DAO.ICategoryDAO;
import DAO.IProductDAO;
import DAO.ProductDAO;
import model.Category;
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
                showFormDeleteProduct(request,response);
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




    private void showFormEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id")) ;
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/editProduct.jsp");
        List<Category> categories = categoryDAO.showAll();
        Product product = productDAO.findById(id);
        request.setAttribute("categories",categories);
        request.setAttribute("product",product);
        dispatcher.forward(request,response);
    }

    private void showFormAddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/addProduct.jsp");
        List<Category> categories = categoryDAO.showAll();
        request.setAttribute("categories",categories);
        dispatcher.forward(request,response);
    }
    private void showAllListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/listProduct.jsp");
        List<Product> products = productDAO.showAll();
        request.setAttribute("products",products);
        dispatcher.forward(request,response);
    }

    private void showFormDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/deleteProduct.jsp");
        Product product = productDAO.findById(id);
        request.setAttribute("product",product);
        dispatcher.forward(request,response);
    }

    private void addNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameProduct");
        int price =Integer.parseInt(request.getParameter("priceProduct"));
        int quantity = Integer.parseInt(request.getParameter("quantityProduct"));
        String color = request.getParameter("colorProduct");
        String description = request.getParameter("descriptionProduct");
        int categoryId =Integer.parseInt(request.getParameter("categoryProduct"));
        Category category = categoryDAO.findById(categoryId);
        Product newProduct = new Product(name,price,quantity,color,description,category);
        productDAO.save(newProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/listProduct.jsp");
        List<Product> products = productDAO.showAll();
        request.setAttribute("products",products);
        dispatcher.forward(request,response);
    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id")) ;
        String name = request.getParameter("nameProduct");
        int price = Integer.parseInt(request.getParameter("priceProduct"));
        int quantity = Integer.parseInt(request.getParameter("quantityProduct"));
        String color = request.getParameter("colorProduct");
        String description = request.getParameter("descriptionProduct");
        int categoryId = Integer.parseInt(request.getParameter("categoryProduct"));
        Category category = categoryDAO.findById(categoryId);
        Product product = new Product(id,name,price,quantity,color,description,category);
        productDAO.update(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/listProduct.jsp");
        List<Product> products = productDAO.showAll();
        request.setAttribute("products",products);
        dispatcher.forward(request,response);
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        productDAO.delete(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/listProduct.jsp");
        List<Product> products = productDAO.showAll();
        request.setAttribute("products",products);
        dispatcher.forward(request,response);
    }

}
