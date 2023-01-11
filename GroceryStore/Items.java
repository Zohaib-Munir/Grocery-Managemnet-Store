package GroceryStore;

import java.io.Serializable;

public class Items implements Serializable {
    private String itemName;
    private int itemID;
    private Category category;
    private String itemImage;
    private double price;
    private int quantity;

    public Items(String itemName, Category category, double price, int quantity, int itemID, String itemImage) {
        this.itemName = itemName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.itemID = itemID;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Item [category=" + category.toString() + ", itemName=" + itemName + ", price=" + price + ", quantity=" + quantity
                + "]";
    }
    public boolean equals(Object obj) {
        if (obj instanceof Items) {
            Items item = (Items) obj;
            return this.itemID == item.getItemID();
        }
        return false;
    }
}
