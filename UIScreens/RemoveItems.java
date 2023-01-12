package UIScreens;

import javax.swing.JFrame;

import ActorsAndActions.Admin;
import FrameColor.UIColor;
import GroceryStore.Items;
import SystemDataControllers.ItemsFileIO;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.*;

public class RemoveItems extends JFrame implements ActionListener {

    Admin admin;
    ArrayList<Items> itemsList;


    JComboBox<String> itemsDropDownMenu;

    JLabel storeNameLabel;
    JLabel storeDescLabel;
    JLabel lineUnderNameLabel;
    String[] itemsNameAndID;


    JLabel adminNameLabel;
    JLabel itemIdLabel;
    JTextField itemIDTextFiled;


    JButton backButton;
    JButton removeItemButton;
    Container c;

    public RemoveItems(Admin a){
        admin = a;
        itemsList= new ArrayList<Items>();

        backButton = new JButton("Back");
        backButton.addActionListener(this);




        ItemsFileIO readItems = new ItemsFileIO();
        itemsList = readItems.readItemsFromFile();

        this.setLayout(null);
        this.setSize(550,550);
        this.setResizable(false);
        this.setTitle("Remove Items");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        storeNameLabel = new JLabel("Grocery Store Management");
        storeDescLabel = new JLabel("Every Thing Under One Roof You Are Welcome Here !");
        lineUnderNameLabel = new JLabel("--------------------------------------------------------------------");
        adminNameLabel = new JLabel("Admin Name : "+admin.getAdminName());
        itemIdLabel = new JLabel("Item ID : ");
        itemIDTextFiled = new JTextField();
        removeItemButton = new JButton("Remove Item");

        storeNameLabel.setBounds(90,0,500,60);
        storeNameLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
        storeNameLabel.setForeground(UIColor.SLATE_RED);

        storeDescLabel.setForeground(UIColor.SLATE_RED);
        storeDescLabel.setFont(new Font("Times New Roman",Font.BOLD,15));
        storeDescLabel.setBounds(90,45,500,30);

        lineUnderNameLabel.setBounds(0,65,800,40);
        lineUnderNameLabel.setForeground(UIColor.SLATE_RED);
        lineUnderNameLabel.setFont(new Font("Times New Roman",Font.BOLD,25));


        adminNameLabel.setForeground(UIColor.SLATE_RED);
        adminNameLabel.setFont(new Font("Times new Roman",Font.BOLD,15));
        adminNameLabel.setHorizontalAlignment(JLabel.CENTER);
        adminNameLabel.setBounds(200,90,120,30);

        itemIdLabel.setForeground(UIColor.SLATE_RED);
        itemIdLabel.setFont(new Font("Times New Roman",Font.BOLD,15));
        itemIdLabel.setHorizontalAlignment(JLabel.CENTER);
        itemIdLabel.setHorizontalTextPosition(JLabel.CENTER);
        itemIdLabel.setBounds(20,140,120,30);

        itemIDTextFiled.setForeground(UIColor.SLATE_RED);
        itemIDTextFiled.setFont(new Font("Times New Roman",Font.BOLD,15));
        itemIDTextFiled.setHorizontalAlignment(JLabel.CENTER);
        itemIDTextFiled.setBounds(120,140,150,35);

        backButton.setForeground(UIColor.LIGHT_CYAN);
        backButton.setFont(new Font("Times New Roman",Font.BOLD,20));
        backButton.setBounds(20,440,120,40);
        backButton.setBackground(UIColor.SLATE_RED);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        removeItemButton.setForeground(UIColor.LIGHT_CYAN);
        removeItemButton.setFont(new Font("Times New Roman",Font.BOLD,20));
        removeItemButton.setBounds(200,440,170,40);
        removeItemButton.setBackground(UIColor.SLATE_RED);
        removeItemButton.setFocusable(false);
        removeItemButton.addActionListener(this);
        
        
        itemsNameAndID = new String[itemsList.size()];
        int count = 0;
        for (Items items : itemsList) {
            String res = "Name : "+items.getItemName()+"      ID : "+items.getItemID();
            itemsNameAndID[count] = res;
            count++;
        }
        itemsDropDownMenu = new JComboBox<String>(itemsNameAndID);
        itemsDropDownMenu.setForeground(UIColor.SLATE_RED);
        itemsDropDownMenu.setEditable(false);
        itemsDropDownMenu.setBounds(20,200,500,50);

        c = getContentPane();
        c.setBackground(UIColor.LIGHT_CYAN);

        this.add(storeNameLabel);
        this.add(storeDescLabel);
        this.add(lineUnderNameLabel);
        this.add(adminNameLabel);
        this.add(itemIdLabel);
        this.add(itemIDTextFiled);
        this.add(backButton);
        this.add(itemIdLabel);
        this.add(itemsDropDownMenu);
        this.add(removeItemButton);
        this.setVisible(true);
    }

    


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Remove Item")){
            ItemsFileIO itemsFileIO = new ItemsFileIO();
            int id = Integer.parseInt(itemIDTextFiled.getText());
            itemsFileIO.deleteItems(id);
        }
        else{
            this.dispose();
            new AdminMenuScreen(admin);
        }
        
    }


    
}
