package kosa.mission04.category;

public abstract class Category {
    private String name;

    public Category() {}
    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void printAll();
}
