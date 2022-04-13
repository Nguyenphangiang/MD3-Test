package DAO;

import config.SingletonConnection;
import model.Category;
import model.Product;

import java.security.Signature;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO{
    public static final String SQL_SELECT_CATEGORY = "select * from category;";
    public static final String SQL_SELECT_CATEGORY_BY_ID = "select*from category where id = ?";
    private Connection connection = SingletonConnection.getConnection();

    @Override
    public List<Category> showAll() {
        List<Category> categories = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_CATEGORY);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Category category = new Category(id,name);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category findById(int id) {
        Category category = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_CATEGORY_BY_ID)) {
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int categoryId = rs.getInt("id");
                String categoryName = rs.getString("name");
                category = new Category(categoryId,categoryName);
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public boolean update(Category category) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean save(Category category) {
        return false;
    }

    @Override
    public Category findByName(String name) {
        return null;
    }
}
