package com.ben.schronisko.controller;

import com.ben.schronisko.model.Animal;
import com.ben.schronisko.model.Category;
import com.ben.schronisko.repository.AnimalRepository;
import com.ben.schronisko.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AnimalController {

    private AnimalRepository animalRepository;
    private CategoryRepository categoryRepository;

    public AnimalController(AnimalRepository animalRepository, CategoryRepository categoryRepository) {
        this.animalRepository = animalRepository;
        this.categoryRepository = categoryRepository;
    }

//    @GetMapping("/")
//    public String home(Model model) {
//        List<String> animals = animalRepository.findAnimalsNames();
//        model.addAttribute("animals", animals);
//        return "home";
//    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String category) {
        List<Animal> animals = animalRepository.findAll();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("animals", animals);
        model.addAttribute("categories", categories);
        return "home";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "addForm";
    }

    @PostMapping("/post")
    public String addAnimal(@RequestParam String name, String shortDescription, String longDescription, String image, String category){
        Animal animal = new Animal(name,shortDescription,longDescription,image,new Category(category));
        animalRepository.add(animal);
        return "success";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, @RequestParam String name, String shortDescription, String longDescription, String image) {
        List<Category> categories = categoryRepository.findAll();
        Animal editedAnimal = animalRepository.findByName(name);
        //int i = editedAnimal.getId();
        Animal edit = new Animal();
        edit = animalRepository.editAnimal(editedAnimal, shortDescription,longDescription,image);
        //animalRepository.add(editedAnimal);

        model.addAttribute("animal", edit);
        model.addAttribute("editedAnimal", editedAnimal);
        model.addAttribute("categories", categories);
        return "editForm";
    }

    @GetMapping("/complete")
    public String showCompletedEdition() {
        return "success";
    }

    @GetMapping("/category")
    public String showAnimalsFromCategory(Model model, @RequestParam String name) {
        List<Animal> animalsFromCategory = animalRepository.giveAnimalsFromCategory(new Category(name));
        List<Category> categories = categoryRepository.findAll();
        if (animalsFromCategory.size() == 0)
            model.addAttribute("empty", "Brak");
        else
            model.addAttribute("empty",null);
        model.addAttribute("categories", categories);
        model.addAttribute("category", name);
        model.addAttribute("animalsFromCategory", animalsFromCategory);
        return "animalsFromCategory";
    }






//    @GetMapping("/home")
//    public String showCategories(Model model) {
//        List<Category> categories = categoryRepository.findAll();
//        model.addAttribute("categories", categories);
//        return "home";
//    }

//    @GetMapping("/")
//    public String showImage(Model model) {
//        List<String> animals = animalRepository.findAll();
//        model.addAttribute("animals", animals);
//        return "home";
//    }




    @GetMapping("/details")
    public String detailsController(@RequestParam String name, Model model) {
        Animal animal = animalRepository.findByName(name);
        model.addAttribute("animal", animal);
        return "animalDetails";
    }

//    @GetMapping("/return")
//    public String goBackController() {
//        return "home";
//    }

}
