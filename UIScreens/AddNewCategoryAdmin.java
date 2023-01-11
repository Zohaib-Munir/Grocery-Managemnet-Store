package UIScreens;
import FrameColor.*;
import GroceryStore.Category;

import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import ActorsAndActions.Admin;
import SystemDataControllers.CategoryFileIO;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.*;

public class AddNewCategoryAdmin extends JFrame implements ActionListener {
    Admin admin;

    JLabel storeNameLabel;
    JLabel storeDescLabel;
    JLabel lineUnderNameLabel;


    JButton selectImageButton;
    JButton addImageButton;
    JButton backButton;

    JTextField categoryNameFiled;
    JLabel categoryNameLabel;

    JLabel adminNameLabel;
    JLabel firstNameLabel;
    JLabel adminCNIC;

    Container c;

    File file;


    public AddNewCategoryAdmin(Admin a){
        admin = a;

        this.setLayout(null);
        this.setSize(550,550);
        this.setResizable(false);
        this.setTitle("New Category");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        storeNameLabel = new JLabel("Grocery Store Management");
        storeDescLabel = new JLabel("Every Thing Under One Roof You Are Welcome Here !");
        lineUnderNameLabel = new JLabel("--------------------------------------------------------------------");
        categoryNameLabel = new JLabel("Category Name : ");
        categoryNameFiled = new JTextField("Name");
        addImageButton = new JButton("Add Category");
        selectImageButton = new JButton("Select Image");
        backButton = new JButton("Back");


        storeNameLabel.setBounds(90,0,500,60);
        storeNameLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
        storeNameLabel.setForeground(UIColor.SLATE_RED);

        storeDescLabel.setForeground(UIColor.SLATE_RED);
        storeDescLabel.setFont(new Font("Times New Roman",Font.BOLD,15));
        storeDescLabel.setBounds(90,45,500,30);

        lineUnderNameLabel.setBounds(0,65,800,40);
        lineUnderNameLabel.setForeground(UIColor.SLATE_RED);
        lineUnderNameLabel.setFont(new Font("Times New Roman",Font.BOLD,25));


        categoryNameLabel.setBounds(20,120,150,20);
        categoryNameLabel.setForeground(UIColor.SLATE_RED);
        categoryNameLabel.setFont(new Font("Times New Roman",Font.BOLD,15));


        categoryNameFiled.setBounds(160,115,200,40);
        categoryNameFiled.setFont(new Font("Times New Roman",Font.BOLD,15));
        categoryNameFiled.setForeground(UIColor.SLATE_RED);

        selectImageButton.setBounds(180,180,150,40);
        selectImageButton.setBackground(UIColor.SLATE_RED);
        selectImageButton.setForeground(UIColor.LIGHT_CYAN);
        selectImageButton.setFont(new Font("Times New Roman",Font.BOLD,15));
        selectImageButton.setFocusable(false);
        selectImageButton.addActionListener(this);

        addImageButton.setBounds(155,245,200,40);
        addImageButton.setBackground(UIColor.SLATE_RED);
        addImageButton.setForeground(UIColor.LIGHT_CYAN);
        addImageButton.setFont(new Font("Times New Roman",Font.BOLD,15));
        addImageButton.setFocusable(false);
        addImageButton.addActionListener(this);

        backButton.setForeground(UIColor.LIGHT_CYAN);
        backButton.setFont(new Font("Times New Roman",Font.BOLD,15));
        backButton.setFocusable(false);
        backButton.setBounds(155,290,200,40);
        backButton.setBackground(UIColor.SLATE_RED);
        backButton.addActionListener(this);


        firstNameLabel = new JLabel("First Name :: "+admin.getFirstName());
        firstNameLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        firstNameLabel.setForeground(UIColor.SLATE_RED);
        firstNameLabel.setBounds(30,350,250,25);
        
        adminNameLabel = new JLabel("Admin :: "+admin.getAdminName());
        adminNameLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        adminNameLabel.setForeground(UIColor.SLATE_RED);
        adminNameLabel.setBounds(30,380,250,25);

        adminCNIC = new JLabel("CNIC :: "+admin.getCnic());
        adminCNIC.setFont(new Font("Times New Roman",Font.BOLD,20));
        adminCNIC.setForeground(UIColor.SLATE_RED);
        adminCNIC.setBounds(30,410,250,25);


        c = getContentPane();
        c.setBackground(UIColor.LIGHT_CYAN);

        this.add(storeNameLabel);
        this.add(storeDescLabel);
        this.add(lineUnderNameLabel);
        this.add(categoryNameLabel);
        this.add(categoryNameFiled);
        this.add(selectImageButton);
        this.add(adminNameLabel);
        this.add(firstNameLabel);
        this.add(adminCNIC);
        this.add(backButton);
        this.add(addImageButton);
        this.setVisible(true);




    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String currentPath = System.getProperty("user.dir");
        if(e.getActionCommand().equals("Select Image")){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setCurrentDirectory(new File(currentPath+"/Images"));
            int response = fileChooser.showOpenDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            }
        }
        else if(e.getActionCommand().equalsIgnoreCase("Add Category")){
            String catName = categoryNameFiled.getText();
            if(catName.equals("Name") || catName.length() == 0){
                JOptionPane.showMessageDialog(null,"Category name is inValid","Category invalid",JOptionPane.ERROR_MESSAGE);
            }
            else if(file == null){
                JOptionPane.showMessageDialog(null,"Image File is invalid","Image invalid",JOptionPane.ERROR_MESSAGE);
            }
            else{
                System.out.println(catName);
                System.out.println(file);
                CategoryFileIO iOCat = new CategoryFileIO();
                iOCat.writeCategory(new Category(catName, file.toString()));       
            }
        }
        else if(e.getActionCommand().equals("Back")){
            this.dispose();
            new AdminMenuScreen(admin);
        }
        
    }
}
