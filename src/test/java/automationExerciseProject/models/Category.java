package automationExerciseProject.models;

public class Category {
    private Usertype usertype; // متداخل
    private String category;

    public Category() {}

    public Category(Usertype usertype, String category) {
        this.usertype = usertype;
        this.category = category;
    }

    // Getters and Setters
    public Usertype getUsertype() { return usertype; }
    public void setUsertype(Usertype usertype) { this.usertype = usertype; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
