package UIScreens;

import FrameColor.UIColor;
import ParentComponents.Address;

import java.awt.event.ActionListener;
import javax.swing.text.MaskFormatter;

import ActorsAndActions.LogIn;
import ActorsAndActions.User;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

public class SignUpScreen extends JFrame implements ActionListener {

    JLabel storeNameLabel;
    JLabel storeDescLabel;
    JLabel lineUnderNameLabel;

    JLabel userNameLabel;
    JLabel userPasswordLabel;
    JLabel userFirstNameLabel;
    JLabel userLastNameLabel;
    JLabel cnciLabel;
    JLabel userContactLabel;
    JLabel userCityLabel;
    JLabel userStreetLabel;
    JLabel userHouseNoLabel;
    JLabel userProvinceLabel;

    JTextField userFirstNameField;
    JTextField userLastNameField;
    JTextField userNameField;
    JTextField userPasswordField;
    JFormattedTextField cnicField;
    JTextField userContactFiled;
    JTextField userCityFiled;
    JTextField userHouseField;
    JTextField userProvinceField;
    JTextField userStreetFiled;

    MaskFormatter mask;
    Container c;

    JButton signUpButton;
    JButton signInButton;

    SignUpScreen() {

        this.setLayout(null);
        this.setSize(800, 550);
        this.setResizable(false);
        this.setTitle("User SignUp");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        storeNameLabel = new JLabel("Grocery Store Management");
        storeDescLabel = new JLabel("Every Thing Under One Roof You Are Welcome Here !");
        lineUnderNameLabel = new JLabel(
                "--------------------------------------------------------------------------------------------------");
        userFirstNameLabel = new JLabel("First Name : ");
        userLastNameLabel = new JLabel("Last Name : ");
        userNameLabel = new JLabel("User Name : ");
        userPasswordLabel = new JLabel("User Password : ");
        cnciLabel = new JLabel("CNIC : ");
        userContactLabel = new JLabel("User Contact : ");
        userCityLabel = new JLabel("City : ");
        userHouseNoLabel = new JLabel("House : ");
        userProvinceLabel = new JLabel("Province : ");
        userStreetLabel = new JLabel("Street : ");

        userFirstNameField = new JTextField("First Name");
        userLastNameField = new JTextField("Last Name");
        userContactFiled = new JTextField("Contact");
        userCityFiled = new JTextField("City");
        userNameField = new JTextField("User Name");
        userPasswordField = new JTextField("User Password");
        userHouseField = new JTextField("House");
        userProvinceField = new JTextField("Province");
        userStreetFiled = new JTextField("Street");

        signUpButton = new JButton("SignUp");
        signInButton = new JButton("SignIn");

        storeNameLabel.setBounds(200, 0, 500, 60);
        storeNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        storeNameLabel.setForeground(UIColor.SLATE_RED);

        storeDescLabel.setForeground(UIColor.SLATE_RED);
        storeDescLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        storeDescLabel.setBounds(202, 45, 500, 30);

        lineUnderNameLabel.setBounds(0, 65, 800, 40);
        lineUnderNameLabel.setForeground(UIColor.SLATE_RED);
        lineUnderNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

        userFirstNameLabel.setBounds(10, 120, 150, 20);
        userFirstNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        userFirstNameLabel.setForeground(UIColor.SLATE_RED);
        userFirstNameField.setBounds(120, 115, 200, 40);
        userFirstNameField.setForeground(UIColor.SLATE_RED);
        userFirstNameField.setFont(new Font("Times New Roman", Font.BOLD, 13));

        userLastNameLabel.setBounds(10, 190, 150, 20);
        userLastNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        userLastNameLabel.setForeground(UIColor.SLATE_RED);
        userLastNameField.setBounds(120, 185, 200, 40);
        userLastNameField.setForeground(UIColor.SLATE_RED);
        userLastNameField.setFont(new Font("Times New Roman", Font.BOLD, 13));

        userNameLabel.setBounds(380, 120, 150, 20);
        userNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        userNameLabel.setForeground(UIColor.SLATE_RED);
        userNameField.setBounds(500, 115, 200, 40);
        userNameField.setForeground(UIColor.SLATE_RED);
        userNameField.setFont(new Font("Times New Roman", Font.BOLD, 13));

        userPasswordLabel.setBounds(380, 190, 150, 20);
        userPasswordLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        userPasswordLabel.setForeground(UIColor.SLATE_RED);
        userPasswordField.setBounds(500, 185, 200, 40);
        userPasswordField.setForeground(UIColor.SLATE_RED);
        userPasswordField.setFont(new Font("Times New Roman", Font.BOLD, 13));

        userContactLabel.setBounds(10, 260, 150, 20);
        userContactLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        userContactLabel.setForeground(UIColor.SLATE_RED);
        userContactFiled.setBounds(120, 255, 200, 40);
        userContactFiled.setForeground(UIColor.SLATE_RED);
        userContactFiled.setFont(new Font("Times New Roman", Font.BOLD, 13));

        cnciLabel.setBounds(380, 260, 150, 20);
        cnciLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        cnciLabel.setForeground(UIColor.SLATE_RED);
        try {
            mask = new MaskFormatter("#####-#######-#");
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Invalid format mask specified");
        }
        mask.setPlaceholderCharacter('_');
        cnicField = new JFormattedTextField(mask);
        cnicField.setBounds(500, 255, 200, 40);
        cnicField.setForeground(UIColor.SLATE_RED);
        cnicField.setFont(new Font("Times New Roman", Font.BOLD, 13));

        userCityLabel.setBounds(10, 330, 70, 20);
        userCityLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        userCityLabel.setForeground(UIColor.SLATE_RED);
        userCityFiled.setBounds(60, 325, 100, 40);
        userCityFiled.setForeground(UIColor.SLATE_RED);
        userCityFiled.setFont(new Font("Times New Roman", Font.BOLD, 13));

        userHouseNoLabel.setBounds(200, 330, 120, 20);
        userHouseNoLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        userHouseNoLabel.setForeground(UIColor.SLATE_RED);
        userHouseField.setBounds(260, 325, 100, 40);
        userHouseField.setForeground(UIColor.SLATE_RED);
        userHouseField.setFont(new Font("Times New Roman", Font.BOLD, 13));

        userProvinceLabel.setBounds(380, 330, 120, 20);
        userProvinceLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        userProvinceLabel.setForeground(UIColor.SLATE_RED);
        userProvinceField.setBounds(455, 325, 100, 40);
        userProvinceField.setForeground(UIColor.SLATE_RED);
        userProvinceField.setFont(new Font("Times New Roman", Font.BOLD, 13));

        userStreetLabel.setBounds(585, 330, 120, 20);
        userStreetLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        userStreetLabel.setForeground(UIColor.SLATE_RED);
        userStreetFiled.setBounds(640, 325, 100, 40);
        userStreetFiled.setForeground(UIColor.SLATE_RED);
        userStreetFiled.setFont(new Font("Times New Roman", Font.BOLD, 13));

        signUpButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        signUpButton.setBackground(UIColor.SLATE_RED);
        signUpButton.setFocusable(false);
        signUpButton.setForeground(UIColor.LIGHT_CYAN);
        signUpButton.setBounds(350, 400, 100, 40);

        signInButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        signInButton.setBackground(UIColor.SLATE_RED);
        signInButton.setFocusable(false);
        signInButton.setForeground(UIColor.LIGHT_CYAN);
        signInButton.setBounds(460, 400, 100, 40);

        c = getContentPane();
        c.setBackground(UIColor.LIGHT_CYAN);

        this.add(storeNameLabel);
        this.add(storeDescLabel);
        this.add(lineUnderNameLabel);
        this.add(userFirstNameLabel);
        this.add(userLastNameLabel);
        this.add(userNameLabel);
        this.add(userPasswordLabel);
        this.add(userContactLabel);
        this.add(cnciLabel);
        this.add(userCityLabel);
        this.add(userProvinceLabel);
        this.add(userHouseNoLabel);
        this.add(userStreetLabel);
        this.add(userFirstNameField);
        this.add(userLastNameField);
        this.add(userPasswordField);
        this.add(userContactFiled);
        this.add(userNameField);
        this.add(userCityFiled);
        this.add(cnicField);
        this.add(userStreetFiled);
        this.add(userHouseField);
        this.add(userProvinceField);
        this.add(signInButton);
        this.add(signUpButton);
        // this.pack();
        this.setVisible(true);

        signUpButton.addActionListener(this);
        signInButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("SignUp")) {
            String firstName = userFirstNameField.getText();
            String lastName = userLastNameField.getText();
            String userName = userNameField.getText();
            String userPassword = userPasswordField.getText();
            String cnic = cnicField.getText();
            String contact = userContactFiled.getText();
            String province = userProvinceField.getText();
            String city = userCityFiled.getText();
            String street = userStreetFiled.getText();
            String house = userHouseField.getText();

            Address userAddress = new Address(province, city, street, house);
            User u = new User(firstName, lastName, cnic, contact, userName, userPassword, userAddress);

            LogIn logInObject = new LogIn();
            logInObject.signUpUser(u);
        } else if (e.getActionCommand().equalsIgnoreCase("SignIn")) {
            this.dispose();
            new UserLogInFrame();
        }
    }

}
