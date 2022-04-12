package DAO;

import config.SingletonConnection;
import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{
    public static final String SQL_SELECT_PRODUCT = "select p.id,p.name,p.price,p.quantity,p.color,p.description,p.category_id,c.name from products p join category c on p.category_id = c.id;";
    public static final String SQL_SELECT_PRODUCT_BY_ID = "select p.name,p.price,p.quantity,p.color,p.description,p.category_id,c.name from products p join category c on p.category_id = c.id where p.id = ?;";
    public static final String SQL_UPDATE_PRODUCT = "update products p join category c on p.category_id = c.id set p.name = ? ,p.price =?,p.quantity = ? ,p.color = ? ,p.descriptiopn = ? ,p.category_id = ? ;";
    public static final String SQL_DELETE_PRODUCT = "delete from products where id = ?;";
    public static final String SQL_INSERT_INTO_PRODUCT = "insert into products (name, price, quantity, color, description, category_id) values (?,?,?,?,?,?);";
    public static final String SQL_SELECT_PRODUCT_BY_NAME = "select p.id,p.name,p.price,p.quantity,p.color,p.description,c.id,c.name from products p join category c on p.category_id = c.id where p.name = ?;";
    private Connection connection = SingletonConnection.getConnection();
    @Override
    public List<Product> showAll() {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PRODUCT);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("p.name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int categoryId = rs.getInt("category_id");
                String categoryName = rs.getString("c.name");
                Category category = new Category(categoryId,categoryName);
                Product product = new Product(id,name,price,quantity,color,description,category);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("p.name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int categoryId = rs.getInt("category_id");
                String categoryName = rs.getString("c.name");
                Category category = new Category(categoryId,categoryName);
                product = new Product(id,name,price,quantity,color,description,category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean update(Product product) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(5,product.getCategory().getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_PRODUCT)) {
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean save(Product product) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_INTO_PRODUCT)) {
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getCategory().getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product findByName(String name) {
        Product product = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PRODUCT_BY_NAME)) {
            preparedStatement.setString(1,name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("p.id");
                String nameProduct = rs.getString("p.name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int categoryId = rs.getInt("c.id");
                String categoryName = rs.getString("c.name");
                Category category = new Category(categoryId,categoryName);
                product = new Product(id,nameProduct,price,quantity,color,description,category);
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
