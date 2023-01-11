package UIScreens;
import javax.swing.*;

import ActorsAndActions.LogIn;
import ActorsAndActions.User;
import FrameColor.UIColor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserLogInFrame extends JFrame implements ActionListener {

    JLabel storeNameLabel;
    JLabel storeDescLabel;
    JLabel lineUnderNameLabel;


    JLabel userNameLabel;
    JLabel userPasswordLabel;

    Container c;

    JTextField userNameTextFiled;
    JTextField userPasswordTextFiled;


    JButton signInButton;
    JButton signUpButton;
    JButton adminButton;

    public UserLogInFrame(){

        this.setLayout(null);
        this.setSize(800,550);
        this.setResizable(false);
        this.setTitle("User/Admin LogIn");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);





        storeNameLabel = new JLabel("Grocery Store Management");
        storeDescLabel = new JLabel("Every Thing Under One Roof You Are Welcome Here !");
        lineUnderNameLabel = new JLabel("--------------------------------------------------------------------------------------------------");
        userNameLabel = new JLabel("User Name : ");
        userPasswordLabel = new JLabel("User Password : ");
        userNameTextFiled = new JTextField("Enter Username");
        userPasswordTextFiled = new JTextField("Enter Password");
        signInButton = new JButton("SignIn");
        signUpButton = new JButton("SignUp");
        adminButton = new JButton("Admin");



        storeNameLabel.setBounds(200,0,500,60);
        storeNameLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
        storeNameLabel.setForeground(UIColor.SLATE_RED);

        storeDescLabel.setForeground(UIColor.SLATE_RED);
        storeDescLabel.setFont(new Font("Times New Roman",Font.BOLD,15));
        storeDescLabel.setBounds(202,45,500,30);

        lineUnderNameLabel.setBounds(0,65,800,40);
        lineUnderNameLabel.setForeground(UIColor.SLATE_RED);
        lineUnderNameLabel.setFont(new Font("Times New Roman",Font.BOLD,25));

        userNameLabel.setBounds(200,180,100,20);
        userNameLabel.setFont(new Font("Times New Roman",Font.BOLD,15));
        userNameLabel.setForeground(UIColor.SLATE_RED);


        userPasswordLabel.setForeground(UIColor.SLATE_RED);
        userPasswordLabel.setFont(new Font("Times New Roman",Font.BOLD,15));
        userPasswordLabel.setBounds(200,240,130,20);

        userNameTextFiled.setFont(new Font("Times New Roman",Font.BOLD,12));
        userNameTextFiled.setForeground(UIColor.SLATE_RED);
        userNameTextFiled.setBounds(330,175,200,40);


        userPasswordTextFiled.setBounds(330,235,200,40);
        userPasswordTextFiled.setFont(new Font("Times New Roman",Font.BOLD,12));
        userPasswordTextFiled.setForeground(UIColor.SLATE_RED);


        signUpButton.setFont(new Font("Times New Roman",Font.BOLD,15));
        signUpButton.setBackground(UIColor.SLATE_RED);
        signUpButton.setFocusable(false);
        signUpButton.setForeground(UIColor.LIGHT_CYAN);
        signUpButton.setBounds(300,360,100,40);


        signInButton.setFont(new Font("Times New Roman",Font.BOLD,15));
        signInButton.setBackground(UIColor.SLATE_RED);
        signInButton.setForeground(UIColor.LIGHT_CYAN);
        signInButton.setBounds(410,360,100,40);
        signInButton.setFocusable(false);

        adminButton.setBackground(UIColor.SLATE_RED);
        adminButton.setForeground(UIColor.LIGHT_CYAN);
        adminButton.setFocusable(false);
        adminButton.setFont(new Font("Times New Roman",Font.BOLD,15));
        adminButton.setBounds(300,410,210,40);



        c = getContentPane();
        c.setBackground(UIColor.LIGHT_CYAN);




        this.add(storeNameLabel);
        this.add(storeDescLabel);
        this.add(lineUnderNameLabel);
        this.add(userNameLabel);
        this.add(userPasswordLabel);
        this.add(userNameTextFiled);
        this.add(userPasswordTextFiled);
        this.add(signUpButton);
        this.add(signInButton);
        this.add(adminButton);
        this.setVisible(true);
        signInButton.addActionListener(this);
        signUpButton.addActionListener(this);
        adminButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       // UserActions u = new UserActions();

        if(e.getActionCommand().equals("SignIn")){
            String userName = userNameTextFiled.getText();
            String userPassword = userPasswordTextFiled.getText();
            LogIn loginObject = new LogIn();
            User result = loginObject.signInUser(userName, userPassword);
            if(result != null){
                this.dispose();
                new CustomerDashBoard(result);
                //JOptionPane.showMessageDialog(new JFrame(),"Done");
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(),"No Registered User");
            }
            
            
        }    
        else if(e.getActionCommand().equals("SignUp")){
            this.dispose();
            new SignUpScreen();
        }
        else if(e.getActionCommand().equals("Admin")){
            this.dispose();
            new AdminLogInFrame();
        }

    }
}