package com.ben.schronisko.model;

public class Animal {

    private int id;
    private String name;
    private String shortDescription;
    private String longDescription;
    private String image;
    private Category category;

    public Animal() {
    }

    public Animal(int id, String name, String shortDescription, String longDescription, String image, Category category) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.image = image;
        this.category = category;
    }

    public Animal(String name, String shortDescription, String longDescription, String image, Category category) {

        if (image == null || image.equals(""))
            this.image = "https://cdn11.bigcommerce.com/s-gho61/stencil/31cc7cb0-5035-0136-2287-0242ac11001b/e/3dad8ea0-5035-0136-cda0-0242ac110004/images/no-image.svg";
        else
            this.image = image;

        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
//        this.image = image;
        this.category = category;
//        if (image.equals(""))
//            this.image = "https://cdn11.bigcommerce.com/s-gho61/stencil/31cc7cb0-5035-0136-2287-0242ac11001b/e/3dad8ea0-5035-0136-cda0-0242ac110004/images/no-image.svg";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
