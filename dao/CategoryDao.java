/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.Category;

public class CategoryDao {

    // Temporary in-memory list (acts like database)
    private static ArrayList<Category> categoryList = new ArrayList<>();
    private static int idCounter = 1;

    // SAVE
    public static void save(Category category) {
        category.setId(idCounter++);
        categoryList.add(category);
        System.out.println("Category Saved: " + category.getName());
    }

    // GET ALL
    public static ArrayList<Category> getAllRecords() {
        return categoryList;
    }

    // DELETE
    public static void delete(String id) {
        int cid = Integer.parseInt(id);
        categoryList.removeIf(c -> c.getId() == cid);
        System.out.println("Category Deleted: " + id);
    }
}
