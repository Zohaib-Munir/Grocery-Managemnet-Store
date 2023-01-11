package UIScreens;
import FrameColor.*;
import javax.swing.JFrame;

import ActorsAndActions.Admin;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

    


public class AdminMenuScreen extends JFrame implements ActionListener{
     Admin admin;

    JLabel storeNameLabel;
    JLabel storeDescLabel;
    JLabel lineUnderNameLabel;

    JLabel adminNameLabel;


    JButton addCategoryButton;
    JButton removeCategoryButton;
    JButton addItemsButtons;
    JButton removeItemsButton;
    JButton addUserButton;
    JButton removeUserButton;

    JButton logOutButton;

    Container c;

    
    public AdminMenuScreen(Admin a){
     
     this.admin = a;

        this.setLayout(null);
        this.setSize(550,550);
        this.setResizable(false);
        this.setTitle("Admin Main Menu");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        storeNameLabel = new JLabel("Grocery Store Management");
        storeDescLabel = new JLabel("Every Thing Under One Roof You Are Welcome Here !");
        lineUnderNameLabel = new JLabel("--------------------------------------------------------------------");

        storeNameLabel.setBounds(90,0,500,60);
        storeNameLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
        storeNameLabel.setForeground(UIColor.SLATE_RED);

        storeDescLabel.setForeground(UIColor.SLATE_RED);
        storeDescLabel.setFont(new Font("Times New Roman",Font.BOLD,15));
        storeDescLabel.setBounds(90,45,500,30);

        lineUnderNameLabel.setBounds(0,65,800,40);
        lineUnderNameLabel.setForeground(UIColor.SLATE_RED);
        lineUnderNameLabel.setFont(new Font("Times New Roman",Font.BOLD,25));


        addCategoryButton = new JButton("Add New Category");
        removeCategoryButton = new JButton("Remove Category");
        addItemsButtons = new JButton("Add Items");
        removeItemsButton = new JButton("Remove Items");
        addUserButton = new JButton("Add User");
        removeUserButton = new JButton("Remove User");
        logOutButton = new JButton("Logout");



        addCategoryButton.setBounds(190,120,150,40);
        addCategoryButton.setBackground(UIColor.SLATE_RED);
        addCategoryButton.setFocusable(false);
        addCategoryButton.setForeground(UIColor.LIGHT_CYAN);
        addCategoryButton.addActionListener(this);



        removeCategoryButton.setBounds(190,180,150,40);
        removeCategoryButton.setBackground(UIColor.SLATE_RED);
        removeCategoryButton.setFocusable(false);
        removeCategoryButton.setForeground(UIColor.LIGHT_CYAN);
        removeCategoryButton.addActionListener(this);


        addItemsButtons.setBounds(190,240,150,40);
        addItemsButtons.setBackground(UIColor.SLATE_RED);
        addItemsButtons.setFocusable(false);
        addItemsButtons.setForeground(UIColor.LIGHT_CYAN);
        addItemsButtons.addActionListener(this);

        removeItemsButton.setBounds(190,300,150,40);
        removeItemsButton.setBackground(UIColor.SLATE_RED);
        removeItemsButton.setFocusable(false);
        removeItemsButton.setForeground(UIColor.LIGHT_CYAN);
        removeItemsButton.addActionListener(this);

        addUserButton.setBounds(190,360,150,40);
        addUserButton.setBackground(UIColor.SLATE_RED);
        addUserButton.setFocusable(false);
        addUserButton.setForeground(UIColor.LIGHT_CYAN);
        addUserButton.addActionListener(this);

        removeUserButton.setBounds(190,420,150,40);
        removeUserButton.setBackground(UIColor.SLATE_RED);
        removeUserButton.setFocusable(false);
        removeUserButton.setForeground(UIColor.LIGHT_CYAN);
        removeUserButton.addActionListener(this);

        logOutButton.setBounds(20,460,150,40);
        logOutButton.setBackground(UIColor.SLATE_RED);
        logOutButton.setForeground(UIColor.LIGHT_CYAN);
        logOutButton.setFocusable(false);
        logOutButton.setFont(new Font("Times New Roman",Font.BOLD,20));
        logOutButton.addActionListener(this);


        adminNameLabel = new JLabel("Welcome :: "+admin.getAdminName());
        adminNameLabel.setForeground(UIColor.SLATE_RED);
        adminNameLabel.setBounds(0,120,200,20);
        adminNameLabel.setFont(new Font("Times New Roman",Font.BOLD,20));

        c = getContentPane();
        c.setBackground(UIColor.LIGHT_CYAN);

        this.add(storeNameLabel);
        this.add(storeDescLabel);
        this.add(lineUnderNameLabel);
        this.add(addCategoryButton);
        this.add(removeCategoryButton);
        this.add(addItemsButtons);
        this.add(removeItemsButton);
        this.add(addUserButton);
        this.add(removeUserButton);
        this.add(logOutButton);
        this.add(adminNameLabel);
        this.setVisible(true);

        
    }




    public void actionPerformed(ActionEvent e){
       if(e.getActionCommand().equals("Add New Category")){
            this.dispose();
            new AddNewCategoryAdmin(admin);
       }
       else if(e.getActionCommand().equals("Remove Category")){
            this.dispose();
            new RemoveCategory(admin);
       }
       else if(e.getActionCommand().equals("Logout")){
            this.dispose();
            new AdminLogInFrame();
       }
       else if(e.getActionCommand().equals("Add Items")){
          this.dispose();
          new AddNewItems(admin);
       }
    }
}
