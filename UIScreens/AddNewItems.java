package UIScreens;

import FrameColor.UIColor;
import GroceryStore.Category;
import GroceryStore.Items;
import SystemDataControllers.CategoryFileIO;
import SystemDataControllers.ItemsFileIO;

import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import ActorsAndActions.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class AddNewItems extends JFrame implements ActionListener {

    JLabel storeNameLabel;
    JLabel storeDescLabel;
    JLabel lineUnderNameLabel;

    JLabel itemIDLabel;
    JLabel itemPriceLabel;
    JLabel categoryLabel;
    JLabel itemQuantityLabel;
    JLabel itemNameLabel;

    JTextField itemIdFiled;
    JTextField itemsPriceField;
    JTextField categoryField;
    JTextField itemQuantityField;
    JTextField itemsNameField;

    JButton backButton;
    JButton selectImageButton;
    JButton addItemButton;

    Admin admin;

    Container c;

    ArrayList<Category> categoryList;
    File itemsFile;
    String currentPath;

    public AddNewItems(Admin a) {
        this.admin = a;
        currentPath = System.getProperty("user.dir");
        itemsFile = new File(currentPath + "/DataBase/Items.txt");
        categoryList = new ArrayList<Category>();

        CategoryFileIO reader = new CategoryFileIO();
        categoryList = reader.readCategories();

        this.setLayout(null);
        this.setSize(800, 550);
        this.setResizable(false);
        this.setTitle("Add New Items");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        storeNameLabel = new JLabel("Grocery Store Management");
        storeDescLabel = new JLabel("Every Thing Under One Roof You Are Welcome Here !");
        lineUnderNameLabel = new JLabel(
                "--------------------------------------------------------------------------------------------------");
        itemIDLabel = new JLabel("Item ID : ");
        itemNameLabel = new JLabel("Item Name : ");
        itemPriceLabel = new JLabel("Item Price : ");
        itemQuantityLabel = new JLabel("Item Quantity : ");
        categoryLabel = new JLabel("Item Category : ");
        itemIdFiled = new JTextField();
        itemsPriceField = new JTextField();
        categoryField = new JTextField();
        itemQuantityField = new JTextField();
        itemsNameField = new JTextField();
        backButton = new JButton("Back");
        selectImageButton = new JButton("Select Image");
        addItemButton = new JButton("Add Item");

        storeNameLabel.setBounds(200, 0, 500, 60);
        storeNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        storeNameLabel.setForeground(UIColor.SLATE_RED);

        storeDescLabel.setForeground(UIColor.SLATE_RED);
        storeDescLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        storeDescLabel.setBounds(202, 45, 500, 30);

        lineUnderNameLabel.setBounds(0, 65, 800, 40);
        lineUnderNameLabel.setForeground(UIColor.SLATE_RED);
        lineUnderNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

        itemIDLabel.setForeground(UIColor.SLATE_RED);
        itemIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        itemIDLabel.setBounds(20, 120, 100, 30);

        itemNameLabel.setForeground(UIColor.SLATE_RED);
        itemNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        itemNameLabel.setBounds(20, 170, 100, 30);

        itemPriceLabel.setForeground(UIColor.SLATE_RED);
        itemPriceLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        itemPriceLabel.setBounds(400, 120, 100, 30);

        itemQuantityLabel.setForeground(UIColor.SLATE_RED);
        itemQuantityLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        itemQuantityLabel.setBounds(400, 170, 115, 30);

        categoryLabel.setForeground(UIColor.SLATE_RED);
        categoryLabel.setBounds(20, 220, 120, 30);
        categoryLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

        itemIdFiled.setBounds(140, 120, 200, 30);
        itemIdFiled.setForeground(UIColor.SLATE_RED);
        itemIdFiled.setFont(new Font("Times New Roman", Font.BOLD, 15));

        itemsNameField.setBounds(140, 170, 200, 30);
        itemsNameField.setForeground(UIColor.SLATE_RED);
        itemsNameField.setFont(new Font("Times New Roman", Font.BOLD, 15));

        itemsPriceField.setBounds(540, 120, 200, 30);
        itemsPriceField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        itemsPriceField.setForeground(UIColor.SLATE_RED);

        itemQuantityField.setBounds(540, 170, 200, 30);
        itemQuantityField.setForeground(UIColor.SLATE_RED);
        itemQuantityField.setFont(new Font("Times New Roman", Font.BOLD, 15));

        categoryField.setForeground(UIColor.SLATE_RED);
        categoryField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        categoryField.setBounds(140, 220, 200, 30);

        backButton.setBounds(20, 300, 100, 40);
        backButton.setBackground(UIColor.SLATE_RED);
        backButton.setForeground(UIColor.LIGHT_CYAN);
        backButton.setFocusable(false);
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        backButton.addActionListener(this);

        selectImageButton.setBounds(300, 300, 170, 40);
        selectImageButton.setBackground(UIColor.SLATE_RED);
        selectImageButton.setForeground(UIColor.LIGHT_CYAN);
        selectImageButton.setFocusable(false);
        selectImageButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        selectImageButton.addActionListener(this);

        addItemButton.setBackground(UIColor.SLATE_RED);
        addItemButton.setForeground(UIColor.LIGHT_CYAN);
        addItemButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        addItemButton.setFocusable(false);
        addItemButton.setBounds(590, 300, 170, 40);
        addItemButton.addActionListener(this);

        c = getContentPane();
        c.setBackground(UIColor.LIGHT_CYAN);

        this.add(storeDescLabel);
        this.add(storeNameLabel);
        this.add(lineUnderNameLabel);
        this.add(itemIDLabel);
        this.add(itemNameLabel);
        this.add(itemPriceLabel);
        this.add(itemQuantityLabel);
        this.add(categoryLabel);
        this.add(itemIdFiled);
        this.add(itemsNameField);
        this.add(itemPriceLabel);
        this.add(itemsPriceField);
        this.add(itemQuantityField);
        this.add(categoryField);
        this.add(backButton);
        this.add(selectImageButton);
        this.add(addItemButton);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            this.dispose();
            new AdminMenuScreen(admin);
        } else if (e.getActionCommand().equals("Select Image")) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setCurrentDirectory(new File(currentPath + "/Images"));
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                itemsFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(itemsFile);
            }
        } else if (e.getActionCommand().equals("Add Item")) {
            System.out.println("Clicked");
            Category newCat = null;
            Boolean control = false;
            String itemCat = categoryField.getText();

            for (Category category : categoryList) {
                System.out.println(category.toString());
                if (category.getCategoryName().equals(itemCat)) {
                    control = true;
                    newCat = category;
                    break;
                }
            }
            if (!control) {
                JOptionPane.showMessageDialog(new JFrame(), "Category Doesn't Exists");
                return;
            } else if (control) {
                ItemsFileIO fileIO = new ItemsFileIO();
                int itemsID = Integer.parseInt(itemIdFiled.getText());
                String itemName = itemsNameField.getText();
                int itemQuantity = Integer.parseInt(itemQuantityField.getText());
                double itemsPrice = Double.parseDouble(itemsPriceField.getText());
                String image = itemsFile.toString();
                fileIO.writeItemsToFile(new Items(itemName, newCat, itemsPrice, itemQuantity, itemsID, image));
                JOptionPane.showMessageDialog(new JFrame(), "Item Added Successfully in  " + newCat.getCategoryName());
            }

        }

    }

}
