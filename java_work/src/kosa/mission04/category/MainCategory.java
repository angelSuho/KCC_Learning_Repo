package kosa.mission04.category;

import java.util.ArrayList;
import java.util.List;

public class MainCategory extends Category {
    private List<SubCategory> subCategories;

    public MainCategory() {}
    public MainCategory(String name) {
        super(name);
        this.subCategories  = new ArrayList<>();
    }

    public List<SubCategory> getSubCategories() {
        return this.subCategories;
    }

    public void addSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    public void printAll() {
        for (SubCategory subCategory : subCategories) {
            System.out.println(subCategory.getName());
            System.out.println("--------------");
        }
    }
}
