package DAO;

import model.Category;

import java.util.List;

public class CategoryDAO implements ICategoryDAO{
    @Override
    public List<Category> showAll() {
        return null;
    }

    @Override
    public Category findById(int id) {
        return null;
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
