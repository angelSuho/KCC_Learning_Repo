package kosa.mission04;

import java.util.ArrayList;
import java.util.List;

public class MainCategory {

    private String name;
    private List<SubCategory> subCategories;

    public MainCategory() {}
    public MainCategory(String name) {
        this.name = name;
        this.subCategories  = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<SubCategory> getSubCategories() {
        return this.subCategories;
    }

    public void addSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    public void printAll() {
        for (SubCategory subCategory : subCategories) {
            subCategory.printAll();
        }
    }

    public void printSubCategory() {
        for (SubCategory subCategory : subCategories) {
            System.out.println(subCategory.getName());
            System.out.println("--------------");
        }
    }
}
