package GroceryStore;

import java.io.Serializable;

public class Category implements Serializable {
    private String categoryName;
    private String categoryImage;

    public Category(String categoryName, String cateImages) {
        this.categoryName = categoryName;
        this.categoryImage = cateImages;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String toString() {
        return "Category [ categoryName "
                + categoryName + " , CategoryImages  ," +
                categoryImage + "]";
    }

}
