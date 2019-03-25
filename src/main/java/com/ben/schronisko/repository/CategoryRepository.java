package com.ben.schronisko.repository;

import com.ben.schronisko.model.Animal;
import com.ben.schronisko.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {

    private List<Category> categories = new ArrayList<>();

    public CategoryRepository() {
        //categories.add(new Category("Wszystkie"));
        categories.add(new Category("Pies"));
        categories.add(new Category("Kot"));
        categories.add(new Category("Inne"));
    }

    public List<Category> findAll() {
        return categories;
    }

    public boolean checkIfExists(String category) {
        for (int i = 0; i < categories.size() ; i++) {
            if(categories.get(i).getName().equals(category))
                return true;
        }
        return false;
    }



}
