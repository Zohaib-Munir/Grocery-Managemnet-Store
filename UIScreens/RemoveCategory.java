package UIScreens;

import javax.swing.JFrame;

import ActorsAndActions.Admin;
import FrameColor.UIColor;
import GroceryStore.Category;
import SystemDataControllers.CategoryFileIO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class RemoveCategory extends JFrame implements ActionListener {

    ArrayList<Category> categoryList;
    Admin admin;

    JLabel storeNameLabel;
    JLabel storeDescLabel;
    JLabel lineUnderNameLabel;
    JLabel categoryNameLabel;

    JTextField categoryNameTextFiled;
    JButton backButton;
    JButton removeCategoryButton;
    JButton logoutButton;

    Category toBeDeleted;

    Container c;

    public RemoveCategory(Admin a) {
        admin = a;
        categoryList = new ArrayList<Category>();
        CategoryFileIO categoryFileIO = new CategoryFileIO();
        categoryList = categoryFileIO.readCategories();

        this.setTitle("Remove Category");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(550, 550);
        setLocationRelativeTo(null);

        storeNameLabel = new JLabel("Grocery Store Management");
        storeDescLabel = new JLabel("Every Thing Under One Roof You Are Welcome Here !");
        lineUnderNameLabel = new JLabel("-------------------------------------------------------------------");
        categoryNameLabel = new JLabel("Category Name : ");
        backButton = new JButton("Back");
        removeCategoryButton = new JButton("Remove");
        logoutButton = new JButton("Logout");
        categoryNameTextFiled = new JTextField("Category Name");

        storeNameLabel.setBounds(90, 0, 500, 60);
        storeNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        storeNameLabel.setForeground(UIColor.SLATE_RED);

        storeDescLabel.setForeground(UIColor.SLATE_RED);
        storeDescLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        storeDescLabel.setBounds(90, 45, 500, 30);

        lineUnderNameLabel.setBounds(0, 65, 800, 40);
        lineUnderNameLabel.setForeground(UIColor.SLATE_RED);
        lineUnderNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

        categoryNameLabel.setForeground(UIColor.SLATE_RED);
        categoryNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        categoryNameLabel.setBounds(0, 130, 500, 60);

        backButton.setForeground(UIColor.LIGHT_CYAN);
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        backButton.setBounds(0, 400, 150, 40);
        backButton.setBackground(UIColor.SLATE_RED);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        removeCategoryButton.setForeground(UIColor.LIGHT_CYAN);
        removeCategoryButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        removeCategoryButton.setBounds(220, 220, 100, 40);
        removeCategoryButton.setBackground(UIColor.SLATE_RED);
        removeCategoryButton.setFocusable(false);
        removeCategoryButton.addActionListener(this);

        logoutButton.setForeground(UIColor.LIGHT_CYAN);
        logoutButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        logoutButton.setBounds(380, 400, 150, 40);
        logoutButton.setBackground(UIColor.SLATE_RED);
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(this);

        categoryNameTextFiled.setForeground(UIColor.SLATE_RED);
        categoryNameTextFiled.setBounds(130, 140, 200, 40);
        categoryNameTextFiled.setFont(new Font("Times New Roman", Font.BOLD, 15));

        c = getContentPane();
        c.setBackground(UIColor.LIGHT_CYAN);

        this.add(storeNameLabel);
        this.add(storeDescLabel);
        this.add(lineUnderNameLabel);
        this.add(categoryNameLabel);
        this.add(backButton);
        this.add(removeCategoryButton);
        this.add(categoryNameTextFiled);
        this.add(logoutButton);

        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Remove")) {
            Boolean result = false;
            String categoryName = categoryNameTextFiled.getText().trim();
            if (categoryName.equals("Category Name")) {
                JOptionPane.showMessageDialog(new JFrame(), "Category Name cannot be default!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                for (Category category : categoryList) {
                    System.out.println("\n\n\n"+category.toString());
                    if (category.getCategoryName().equals(categoryName)) {
                        toBeDeleted = category;
                        result = true;
                    }
                }
                if (result) {
                    CategoryFileIO categoryFileIO = new CategoryFileIO();
                    categoryFileIO.removeCategory(toBeDeleted);
                }
                else{

                    JOptionPane.showMessageDialog(new JFrame(), "Category Name not found!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        }
        else if(e.getActionCommand().equals("Logout")){
            this.dispose();
            new AdminLogInFrame();
        }
        else if(e.getActionCommand().equals("Back")){

            this.dispose();
            new AdminMenuScreen(admin);
        }

    }

}
