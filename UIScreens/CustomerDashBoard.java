package UIScreens;

import javax.swing.*;

import ActorsAndActions.User;
import SystemDataControllers.CategoryFileIO;

import java.awt.*;
import FrameColor.UIColor;
import GroceryStore.Category;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class CustomerDashBoard extends JFrame implements ActionListener{
    
    ArrayList<Category> itemsList;
    String currentPath;
    User user;

    JPanel leftSidePanel;
    JPanel topPanel;
    JPanel centerPanel;

    JLabel storeNameLabel;
    JLabel storeDescLabel;
    JLabel lineUnderNameLabel;
    JLabel stockDetails;


    JButton logOutButton;
    JLabel userNameLabel;
    JLabel firstNameLabel;
    JButton cartButton;

    


    public CustomerDashBoard(User user){
        this.user = user;
        itemsList = new ArrayList<Category>();

        //Reading Categories From File To Display On Customer DashBoard;
        CategoryFileIO cat = new CategoryFileIO();
        itemsList = cat.readCategories();
        currentPath = System.getProperty("user.dir");



        //Frame Setting Code 
        this.setLayout(null);
        this.setSize(800,550);
        this.setResizable(false);
        this.setTitle("Customer DashBoard");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initializing View On Screen.
        storeNameLabel = new JLabel("Grocery Store Management");
        storeDescLabel = new JLabel("Every Thing Under One Roof You Are Welcome Here !");
        lineUnderNameLabel = new JLabel("--------------------------------------------------------------------------------------------------");
        topPanel = new JPanel(null);
        leftSidePanel = new JPanel(null);
        centerPanel = new JPanel(new GridLayout(2,3,50,50));
        logOutButton = new JButton();
        userNameLabel = new JLabel("Welcome "+user.getUserName());
        firstNameLabel = new JLabel(user.getFirstName()+" "+user.getLastName());




        //Setting up Bound In Frame.
        leftSidePanel.setBackground(UIColor.LIGHT_CYAN);
        leftSidePanel.setBounds(0,80,150,470);
        topPanel.setBounds(0,0,800,90);
        topPanel.setBackground(UIColor.LIGHT_CYAN);
        centerPanel.setBounds(155,95,625,415);
        centerPanel.setBackground(UIColor.LIGHT_CYAN);


        storeNameLabel.setBounds(200,0,500,60);
        storeNameLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
        storeNameLabel.setForeground(UIColor.SLATE_RED);

        storeDescLabel.setForeground(UIColor.SLATE_RED);
        storeDescLabel.setFont(new Font("Times New Roman",Font.BOLD,15));
        storeDescLabel.setBounds(202,45,500,30);

        lineUnderNameLabel.setBounds(0,65,800,40);
        lineUnderNameLabel.setForeground(UIColor.SLATE_RED);
        lineUnderNameLabel.setFont(new Font("Times New Roman",Font.BOLD,25));


        userNameLabel.setBounds(0,20,150,20);
        userNameLabel.setForeground(UIColor.SLATE_RED);
        userNameLabel.setFont(new Font("Times New Roman",Font.BOLD,15));

        firstNameLabel.setBounds(0,90,150,20);
        firstNameLabel.setForeground(UIColor.SLATE_RED);
        firstNameLabel.setFont(new Font("Times New Roman",Font.BOLD,25));





        
//Creating Image Icons From Placing In JButtons;
        ImageIcon ic2 = new ImageIcon(currentPath+"/Images/logout.png");
        Image ig2 = ic2.getImage();
        Image im2 = ig2.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH);
        ic2 = new ImageIcon(im2);

        logOutButton.setIcon(ic2);
        logOutButton.setHorizontalAlignment(JButton.CENTER);
        logOutButton.setHorizontalTextPosition(JButton.CENTER);
        logOutButton.addActionListener(this);


        logOutButton.setBounds(10,370,130,40);
        logOutButton.setFont(new Font("Times New Roman",Font.BOLD,22));
        logOutButton.setBackground(UIColor.SLATE_RED);
        logOutButton.setToolTipText("Logout");
        logOutButton.setBorder(null);
        logOutButton.setFocusable(false);


        cartButton = new JButton("Cart");
        cartButton.setFont(new Font("Times New Roman",Font.BOLD,15));
        cartButton.setBackground(UIColor.SLATE_RED);
        cartButton.setForeground(UIColor.LIGHT_CYAN);
        cartButton.addActionListener(this);
        cartButton.setBounds(10,320,130,40);
        cartButton.setFocusable(false);


        ImageIcon image1 = new ImageIcon(currentPath+"/Images/meat.png");
        Image i1 = image1.getImage();
        Image ii1 = i1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        image1 = new ImageIcon(ii1);


            for (Category category : itemsList) {
                JButton categoryButtons = new JButton();
                categoryButtons.setBounds(50,170,200,220);
                categoryButtons.setFont(new Font("Times New Roman",Font.BOLD,22));
                categoryButtons.setText(category.getCategoryName());
                categoryButtons.setForeground(UIColor.SLATE_RED);
                categoryButtons.setBackground(UIColor.WHITE);
                categoryButtons.setToolTipText(category.getCategoryName());
                categoryButtons.setBorder(BorderFactory.createLineBorder(UIColor.SLATE_RED,5));
                categoryButtons.setFocusable(false);
                categoryButtons.addActionListener(this);
                ImageIcon imgIcon1 = new ImageIcon(category.getCategoryImage());
                Image image2 = imgIcon1.getImage();
                Image img1 = image2.getScaledInstance(200,170,java.awt.Image.SCALE_SMOOTH);
                imgIcon1 = new ImageIcon(img1);
                categoryButtons.setIconTextGap(15);
                categoryButtons.setIcon(imgIcon1);
                categoryButtons.setVerticalTextPosition(JButton.BOTTOM);
                categoryButtons.setHorizontalTextPosition(JButton.CENTER);
                centerPanel.add(categoryButtons);
            }
            if(itemsList.size()==0){
                stockDetails = new JLabel("OUT OF STOCK");
                stockDetails.setFont(new Font("Times New Roman",Font.BOLD,40));
                stockDetails.setForeground(UIColor.SLATE_RED);
                centerPanel.add(stockDetails);
            }
        
        topPanel.add(storeNameLabel);
        topPanel.add(storeDescLabel);
        topPanel.add(lineUnderNameLabel);
        leftSidePanel.add(logOutButton);
        leftSidePanel.add(cartButton);
        leftSidePanel.add(userNameLabel);
        leftSidePanel.add(firstNameLabel);
        

        this.add(topPanel);
        this.add(leftSidePanel);
        this.add(centerPanel);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == logOutButton){
            this.dispose();
            new UserLogInFrame();
        }
        else if (e.getActionCommand().equals("Cart")){
            this.dispose();
            new CartDetailScreen(user);
        }
        else{
            this.dispose();
            new CustomerProductsDashBoard(user, e.getActionCommand());
        }
    }
    
}
