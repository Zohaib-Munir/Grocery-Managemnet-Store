package UIScreens;

import java.awt.*;
import FrameColor.UIColor;
import javax.swing.*;
import ActorsAndActions.Admin;
import ActorsAndActions.LogIn;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogInFrame extends JFrame implements ActionListener {
    JLabel storeNameLabel;
    JLabel storeDescLabel;
    JLabel lineUnderNameLabel;

    Container c;

    JLabel userNameLabel;
    JLabel userPasswordLabel;

    JTextField userNameTextFiled;
    JTextField userPasswordTextFiled;

    JButton signInButton;
    JButton signUpButton;
    JButton backButton;

    AdminLogInFrame() {

        this.setLayout(null);
        this.setSize(800, 550);
        this.setResizable(false);
        this.setTitle("Admin LogIn Frame");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        storeNameLabel = new JLabel("Grocery Store Management");
        storeDescLabel = new JLabel("Every Thing Under One Roof You Are Welcome Here !");
        lineUnderNameLabel = new JLabel(
                "--------------------------------------------------------------------------------------------------");
        userNameLabel = new JLabel("User Name : ");
        userPasswordLabel = new JLabel("User Password : ");
        userNameTextFiled = new JTextField("Enter Username");
        userPasswordTextFiled = new JTextField("Enter Password");
        signInButton = new JButton("SignIn");
        signUpButton = new JButton("SignUp");
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

        userNameLabel.setBounds(200, 180, 100, 20);
        userNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        userNameLabel.setForeground(UIColor.SLATE_RED);

        userPasswordLabel.setForeground(UIColor.SLATE_RED);
        userPasswordLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        userPasswordLabel.setBounds(200, 240, 130, 20);

        userNameTextFiled.setFont(new Font("Times New Roman", Font.BOLD, 12));
        userNameTextFiled.setForeground(UIColor.SLATE_RED);
        userNameTextFiled.setBounds(330, 175, 200, 40);

        userPasswordTextFiled.setBounds(330, 235, 200, 40);
        userPasswordTextFiled.setFont(new Font("Times New Roman", Font.BOLD, 12));
        userPasswordTextFiled.setForeground(UIColor.SLATE_RED);

        signUpButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        signUpButton.setBackground(UIColor.SLATE_RED);
        signUpButton.setFocusable(false);
        signUpButton.setForeground(UIColor.LIGHT_CYAN);
        signUpButton.setBounds(300, 360, 100, 40);

        signInButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        signInButton.setBackground(UIColor.SLATE_RED);
        signInButton.setForeground(UIColor.LIGHT_CYAN);
        signInButton.setBounds(410, 360, 100, 40);
        signInButton.setFocusable(false);

        backButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        backButton.setBackground(UIColor.SLATE_RED);
        backButton.setForeground(UIColor.LIGHT_CYAN);
        backButton.setBounds(300, 420, 210, 40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        c = getContentPane();
        c.setBackground(UIColor.LIGHT_CYAN);

        this.add(storeNameLabel);
        this.add(storeDescLabel);
        this.add(lineUnderNameLabel);
        this.add(userNameLabel);
        this.add(userPasswordLabel);
        this.add(userNameTextFiled);
        this.add(userPasswordTextFiled);
        this.add(backButton);
        this.add(signInButton);
        this.add(signUpButton);
        this.setVisible(true);

        signInButton.addActionListener(this);
        signUpButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("SignIn")) {
            LogIn logInObject = new LogIn();
            String name = userNameTextFiled.getText();
            String password = userPasswordTextFiled.getText();
            Admin a = logInObject.signInAdmin(name, password);
            if (a != null) {
                this.dispose();
                new AdminMenuScreen(a);
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "No Registered Admin Found");
            }
        } else if (e.getActionCommand().equals("SignUp")) {
            this.dispose();
            new AdminSignUpFrame();
        } else if (e.getActionCommand().equals("Back")) {
            this.dispose();
            new UserLogInFrame();
        }

    }
}
