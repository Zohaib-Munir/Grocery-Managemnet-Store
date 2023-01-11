package GroceryStore;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {

    public ArrayList<Items> itemsList;

    public Cart() {
        itemsList = new ArrayList<Items>();
    }

    public void addItems(Items item) {
        itemsList.add(item);
    }

    public void removeItems(Items item) {
        itemsList.remove(item);
    }

    public int getTotalItems() {
        return itemsList.size();
    }

    public int getTotalPrice() {
        int total = 0;
        for (Items item : itemsList) {
            total += item.getPrice();
        }
        return total;
    }

    public void clearCart() {
        this.itemsList.clear();
    }
}
