package SystemDataControllers;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GroceryStore.Cart;

public class CartFileIO implements Serializable {
    ArrayList<Cart> cartList;
    File cartFile;
    String currentPath;
    ObjectInputStream fileReader;
    ObjectOutputStream fileWriter;

    public CartFileIO() {
        cartList = new ArrayList<Cart>();
        currentPath = System.getProperty("user.dir");
        fileReader = null;
        fileWriter = null;
    }

    @SuppressWarnings("all")
    public void addUserCart(Cart cart) {
        String currentPath = System.getProperty("user.dir");
        cartFile = new File(currentPath + "/DataBase/Cart.txt");
        if (cartFile.exists() && cartFile.isFile()) {
            try {
                fileReader = new ObjectInputStream(new FileInputStream(cartFile));
                while (true) {
                    cartList = (ArrayList<Cart>) fileReader.readObject();
                }
            } catch (EOFException e) {
                cartList.add(cart);
                try {
                    fileWriter = new ObjectOutputStream(new FileOutputStream(cartFile));
                    fileWriter.writeObject(cartList);
                    fileWriter.flush();
                    JOptionPane.showMessageDialog(new JFrame(),
                            cart.getItemsDetails().getItemName() + " Added to Cart");
                    fileWriter.close();
                } catch (IOException d) {
                    d.printStackTrace();
                    return;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }
        } else {
            try {
                cartFile.createNewFile();
                cartList.add(cart);
                fileWriter = new ObjectOutputStream(new FileOutputStream(cartFile));
                fileWriter.writeObject(cartList);
                fileWriter.flush();
                JOptionPane.showMessageDialog(new JFrame(), cart.getItemsDetails().getItemName() + " Added to Cart");
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    @SuppressWarnings("all")
    public ArrayList<Cart> readCartDetails() {
        cartFile = new File(currentPath+"/DataBase/Cart.txt");
        if (cartFile.exists() && cartFile.isFile()) {
            try {
                fileReader = new ObjectInputStream(new FileInputStream(cartFile));
                while (true) {
                    cartList = (ArrayList<Cart>) fileReader.readObject();
                }
            } catch (EOFException e) {
                try {
                    fileReader.close();

                } catch (IOException d) {
                    d.printStackTrace();
                } finally {
                    return cartList;
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return cartList;
    }
}
