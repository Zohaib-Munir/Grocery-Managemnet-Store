package UIScreens;

import javax.swing.JFrame;

import ActorsAndActions.User;
import FrameColor.UIColor;
import GroceryStore.Cart;
import SystemDataControllers.CartFileIO;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CartDetailScreen extends JFrame implements ActionListener {

    User user;
    ArrayList<Cart> cartList;
    ArrayList<Cart> newList;
    String[][] tableDataArray;

    JLabel storeNameLabel;
    JLabel storeDescLabel;
    JLabel lineUnderNameLabel;

    JLabel userNameLabel;
    JLabel firstAndLastNameLabel;
    JLabel shippingAddressLabel;
    JLabel provinceLabel;
    JLabel cityLabel;
    JLabel streetLabel;
    JLabel houseLabel;
    JLabel totalItemsInCart;

    Container c;

    JButton backButton;
    JTable dataTable;

    public CartDetailScreen(User user) {

        this.user = user;
        cartList = new ArrayList<Cart>();
        CartFileIO cartFileIO = new CartFileIO();
        cartList = cartFileIO.readCartDetails();
        newList = new ArrayList<Cart>();

        this.setLayout(null);
        this.setSize(800, 550);
        this.setResizable(false);
        this.setTitle("Cart Details");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        storeNameLabel = new JLabel("Grocery Store Management");
        storeDescLabel = new JLabel("Every Thing Under One Roof You Are Welcome Here !");
        lineUnderNameLabel = new JLabel(
                "--------------------------------------------------------------------------------------------------");
        userNameLabel = new JLabel("Welcome " + user.getUserName());
        firstAndLastNameLabel = new JLabel(user.getFirstName() + "" + user.getLastName());
        shippingAddressLabel = new JLabel("Address Details");
        provinceLabel = new JLabel("Province : " + user.getUserAddress().getProvince());
        cityLabel = new JLabel("City : " + user.getUserAddress().getCity());
        streetLabel = new JLabel("Street : " + user.getUserAddress().getStreet());
        houseLabel = new JLabel("House : " + user.getUserAddress().getHouse());

        totalItemsInCart = new JLabel();
        backButton = new JButton("Back");

        storeNameLabel.setBounds(200, 0, 500, 60);
        storeNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        storeNameLabel.setForeground(UIColor.SLATE_RED);

        storeDescLabel.setForeground(UIColor.SLATE_RED);
        storeDescLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        storeDescLabel.setBounds(202, 45, 500, 30);

        lineUnderNameLabel.setBounds(0, 65, 800, 40);
        lineUnderNameLabel.setForeground(UIColor.SLATE_RED);
        lineUnderNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

        c = getContentPane();
        c.setBackground(UIColor.LIGHT_CYAN);

        userNameLabel.setForeground(UIColor.SLATE_RED);
        userNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        userNameLabel.setBounds(20, 130, 150, 30);

        firstAndLastNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        firstAndLastNameLabel.setForeground(UIColor.SLATE_RED);
        firstAndLastNameLabel.setBounds(20, 170, 250, 20);

        shippingAddressLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        shippingAddressLabel.setForeground(UIColor.SLATE_RED);
        shippingAddressLabel.setBounds(20, 210, 250, 20);

        provinceLabel.setBounds(20, 260, 250, 20);
        provinceLabel.setForeground(UIColor.SLATE_RED);
        provinceLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

        cityLabel.setBounds(20, 290, 250, 20);
        cityLabel.setForeground(UIColor.SLATE_RED);
        cityLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

        streetLabel.setBounds(20, 320, 250, 20);
        streetLabel.setForeground(UIColor.SLATE_RED);
        streetLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

        houseLabel.setBounds(20, 350, 250, 20);
        houseLabel.setForeground(UIColor.SLATE_RED);
        houseLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

        totalItemsInCart.setFont(new Font("Times New Roman", Font.BOLD, 20));
        totalItemsInCart.setForeground(UIColor.SLATE_RED);
        totalItemsInCart.setBounds(20, 380, 250, 15);

        backButton.setBackground(UIColor.SLATE_RED);
        backButton.setForeground(UIColor.LIGHT_CYAN);
        backButton.setFocusable(false);
        backButton.setBounds(20, 430, 150, 40);
        backButton.addActionListener(this);

        for (Cart cart : cartList) {
            if (cart.getUserID().equals(user.getUserName())) {
                newList.add(cart);
            }
        }
        totalItemsInCart.setText("Cart Items : " + Integer.toString(newList.size()));
        if (newList.size() == 0) {
            JLabel label = new JLabel("Empty Cart Place Some Orders");
            label.setForeground(UIColor.SLATE_RED);
            label.setFont(new Font("Times New Roman", Font.BOLD, 15));
            label.setBounds(300, 200, 250, 40);
            this.add(label);
        } else {
            tableDataArray = new String[newList.size() + 1][5];
            int sr = 1;
            for (Cart i : newList) {
                String temp[] = { sr + "", i.getItemsDetails().getItemName(), i.getItemsDetails().getItemID() + "",
                        i.getItemsDetails().getQuantity() + "",
                        i.getItemsDetails().getPrice() + "" };
                sr++;
                tableDataArray[sr - 1] = temp;
            }
            String[] tableHeaderArray = { "S.No", "ID", "Price", "Quantity", "Total" };
            dataTable = new JTable(tableDataArray, tableHeaderArray);
            dataTable.setEnabled(false);
            dataTable.setForeground(UIColor.SLATE_RED);
            dataTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            dataTable.setBounds(320, 150, 300, 200);
            this.add(dataTable);
        }

        this.add(storeNameLabel);
        this.add(storeDescLabel);
        this.add(lineUnderNameLabel);
        this.add(userNameLabel);
        this.add(firstAndLastNameLabel);
        this.add(shippingAddressLabel);
        this.add(provinceLabel);
        this.add(cityLabel);
        this.add(streetLabel);
        this.add(houseLabel);
        this.add(totalItemsInCart);
        this.add(backButton);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            this.dispose();
            new CustomerDashBoard(user);
        }

    }

}
