package GroceryStore;

import java.io.Serializable;
import java.util.ArrayList;


public class Cart implements Serializable {
    
    String userName;
    Items itemsDetails;

    public Cart(String userName, Items itemsDetails) {
        this.userName = userName;
        this.itemsDetails = itemsDetails;
    }


    public String getUserID() {
        return userName;
    }
    public void setUserID(String userID) {
        this.userName = userID;
    }
    public Items getItemsDetails() {
        return itemsDetails;
    }
    public void setItemsDetails(Items itemsDetails) {
        this.itemsDetails = itemsDetails;
    }

    public int totalBill(ArrayList<Items> itemsDetails) {
        int total = 0;
        for (Items item : itemsDetails) {
            total += item.getPrice();
        }
        return total;
    }


    


}
