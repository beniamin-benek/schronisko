package com.ben.schronisko.repository;

import com.ben.schronisko.model.Animal;
import com.ben.schronisko.model.Category;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class AnimalRepository {

    private List<Animal> animals = new LinkedList<>();

    public AnimalRepository() {
        animals.add(new Animal(1,"Azor", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut luctus at dolor vel posuere. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut luctus at dolor vel posuere.", "Azor. Integer magna nisl, mollis non pellentesque sit amet, elementum nec est. Sed et enim ac ante accumsan convallis aliquam nec urna. Nam pharetra cursus orci sed hendrerit. In vitae fermentum nisl. Quisque vel orci faucibus, ultricies sapien at, placerat metus. Nunc et ex finibus, fermentum quam nec, sollicitudin arcu. Nullam id lectus est. Nam sed leo ac nunc dignissim convallis.","http://images2.imagebam.com/f8/94/13/3da93a1174129814.jpg",new Category("Pies")));
        animals.add(new Animal(2,"Rudy", "Suspendisse quis tempor dui. Aliquam erat volutpat.", "Rudy. Integer magna nisl, mollis non pellentesque sit amet, elementum nec est. Sed et enim ac ante accumsan convallis aliquam nec urna. Nam pharetra cursus orci sed hendrerit. In vitae fermentum nisl. Quisque vel orci faucibus, ultricies sapien at, placerat metus. Nunc et ex finibus, fermentum quam nec, sollicitudin arcu. Nullam id lectus est. Nam sed leo ac nunc dignissim convallis.","http://thumbs2.imagebam.com/82/ab/6b/fd048d1174129824.jpg",new Category("Kot")));
    }

    public Animal findById(int id) {
        for (Animal animal : animals) {
            if (id == animal.getId())
                return animal;
        }
        return null;
    }

    public Animal findByName(String name) {
        for (Animal animal : animals){
            if (name.equals(animal.getName()))
                return animal;
        }
        return null;
    }

    public List<String> findAnimalImage() {
        List<String> animalsImages = new LinkedList<>();
        for(int i = 0; i < animals.size(); i++)
            animalsImages.add(i, animals.get(i).getImage());
        return animalsImages;
    }

    public List<Animal> findAll() {
        return animals;
    }

    public Animal editAnimal(Animal animal, String shortDescription, String longDescription, String image) {
        if(animal.getShortDescription() == null || !animal.getShortDescription().equals(shortDescription))
            animal.setShortDescription(shortDescription);
        if (animal.getLongDescription() == null || !animal.getLongDescription().equals(longDescription))
            animal.setLongDescription(longDescription);
        if (animal.getImage() == null || !animal.getImage().equals(image))
            animal.setImage(image);
        //animal.setCategory(category);
        return animal;
    }

    public List<String> findAnimalsNames() {
        List<String> animalNames = new LinkedList<>();
        for(int i = 0; i < animals.size(); i++)
            animalNames.add(i, animals.get(i).getName());
        return animalNames;

    }

    public void add(Animal animal) {
        animal.setId(animals.size() + 1);
//        if (animal.getImage() == null || animal.getImage().equals(""))
//            animal.setImage("https://cdn11.bigcommerce.com/s-gho61/stencil/31cc7cb0-5035-0136-2287-0242ac11001b/e/3dad8ea0-5035-0136-cda0-0242ac110004/images/no-image.svg");
        animals.add(animal);
    }

    public List<Animal> giveAnimalsFromCategory(Category category) {
        List<Animal> animalsFromCategory = new LinkedList<>();
        for (Animal animal : animals) {
            if (animal.getCategory().getName().equals(category.getName()))
                animalsFromCategory.add(animal);
        }
        return animalsFromCategory;
    }

}
