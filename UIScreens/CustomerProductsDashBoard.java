package UIScreens;

import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ActorsAndActions.User;
import FrameColor.UIColor;
import GroceryStore.Items;
import SystemDataControllers.ItemsFileIO;

public class CustomerProductsDashBoard extends JFrame implements ActionListener {
    File itemsFile;
    ArrayList<Items> itemsList;
    User user;
    String categoryName;
    String currentPath;

    // GUI Components;
    JLabel storeNameLabel;
    JLabel storeDescLabel;
    JLabel lineUnderNameLabel;
    JLabel itemsDetails;

    Container c;

    JPanel centerPanel;
    JButton backButton;
    JButton cartButton;

    public CustomerProductsDashBoard(User user, String categoryName) {
        System.out.println(categoryName);

        currentPath = System.getProperty("user.dir");
        itemsFile = new File(currentPath + "/DataBase/Items.txt");
        itemsList = new ArrayList<Items>();
        this.user = user;
        this.categoryName = categoryName;

        ItemsFileIO fIO = new ItemsFileIO();
        itemsList = fIO.readItemsFromFile();
        //System.out.println("Size is :::::::  " + itemsList.size());

        this.setLayout(null);
        this.setSize(800, 550);
        this.setResizable(false);
        this.setTitle("Products Screen");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        storeNameLabel = new JLabel("Grocery Store Management");
        storeDescLabel = new JLabel("Every Thing Under One Roof You Are Welcome Here !");
        lineUnderNameLabel = new JLabel(
                "--------------------------------------------------------------------------------------------------");
        backButton = new JButton("Back");
        backButton.setBounds(635, 440, 120, 40);
        backButton.setForeground(UIColor.LIGHT_CYAN);
        backButton.setBackground(UIColor.SLATE_RED);
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        cartButton = new JButton("Cart");
        cartButton.setBounds(635, 390, 120, 40);
        cartButton.setForeground(UIColor.LIGHT_CYAN);
        cartButton.setBackground(UIColor.SLATE_RED);
        cartButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        cartButton.setFocusable(false);
        cartButton.addActionListener(this);

        centerPanel = new JPanel();
        centerPanel.setBounds(0, 95, 625, 415);
        centerPanel.setBackground(UIColor.WHITE);

        storeNameLabel.setBounds(200, 0, 500, 60);
        storeNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        storeNameLabel.setForeground(UIColor.SLATE_RED);

        storeDescLabel.setForeground(UIColor.SLATE_RED);
        storeDescLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        storeDescLabel.setBounds(202, 45, 500, 30);

        lineUnderNameLabel.setBounds(0, 65, 800, 40);
        lineUnderNameLabel.setForeground(UIColor.SLATE_RED);
        lineUnderNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

        centerPanel.setLayout(new GridLayout(3, 3, 50, 50));
        for (Items items : itemsList) {
            System.out.println(items.getCategory().getCategoryName());
            if (items.getCategory().getCategoryName().equals(categoryName)) {
                System.out.println("Draw");
                JButton category1 = new JButton();
                category1.setBounds(50, 170, 200, 220);
                category1.setFont(new Font("Times New Roman", Font.BOLD, 22));
                category1.setToolTipText("Rs. " + items.getPrice());
                category1.setText(items.getItemName() + "");
                category1.setForeground(UIColor.SLATE_RED);
                category1.setBackground(UIColor.WHITE);
                category1.setBorder(BorderFactory.createLineBorder(UIColor.SLATE_RED, 5));
                category1.setFocusable(false);
                category1.addActionListener(this);
                ImageIcon imgIcon1 = new ImageIcon(items.getItemImage());
                Image image1 = imgIcon1.getImage();
                Image img1 = image1.getScaledInstance(200, 170, java.awt.Image.SCALE_SMOOTH);
                imgIcon1 = new ImageIcon(img1);
                category1.setIconTextGap(15);
                category1.setIcon(imgIcon1);
                category1.setVerticalTextPosition(JButton.BOTTOM);
                category1.setHorizontalTextPosition(JButton.CENTER);
                centerPanel.add(category1);
            }
        }
        if (itemsList.size() == 0) {
            itemsDetails = new JLabel("ITEMS OUT OF STOCK");
            itemsDetails.setFont(new Font("Times New Roman", Font.BOLD, 30));
            itemsDetails.setForeground(UIColor.SLATE_RED);
            centerPanel.add(itemsDetails);
        }

        c = getContentPane();
        c.setBackground(UIColor.LIGHT_CYAN);

        this.add(storeNameLabel);
        this.add(storeDescLabel);
        this.add(lineUnderNameLabel);
        this.add(centerPanel);
        this.add(backButton);
        this.add(cartButton);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Back")) {
            this.dispose();
            new CustomerDashBoard(user);
        } else if (e.getActionCommand().equals("Cart")) {
            System.out.println("CART");
        }

    }

}
