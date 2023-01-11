package ActorsAndActions;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ParentComponents.Verification;

public class LogIn implements Serializable {

    File userFile;
    File adminFile;
    ObjectOutputStream fileWriter;
    ObjectInputStream fileReader;

    ArrayList<User> userList;
    ArrayList<Admin> adminList;

    String currentPath;

    public LogIn() {
        currentPath = System.getProperty("user.dir");
        userFile = new File(currentPath + "/DataBase/UserData.txt");
        adminFile = new File(currentPath + "/DataBase/AdminData.txt");
        fileWriter = null;
        fileReader = null;
        userList = new ArrayList<User>();
        adminList = new ArrayList<Admin>();
    }

    @SuppressWarnings("unchecked")
    public void signUpUser(User user) {
        Verification verify = new Verification();
        boolean control = true;
        if (userFile.exists()) {
            try {
                fileReader = new ObjectInputStream(new FileInputStream(userFile));
                while (true) {
                    userList = (ArrayList<User>) fileReader.readObject();
                }
            } catch (EOFException d) {
                if (verify.validName(user.getUserName()) || verify.validPassword(user.getUserPassword())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid Credentials ");
                    control = false;
                } else {
                    for (User u : userList) {
                        if (user.getUserName().equals(u.getUserName())) {
                            JOptionPane.showMessageDialog(new JFrame(), "User Already Exits");
                            control = false;
                        }
                    }
                }
                if (control) {
                    userList.add(user);
                    JOptionPane.showMessageDialog(new JFrame(), "User Registered Successfully");
                    try {
                        fileWriter = new ObjectOutputStream(new FileOutputStream(userFile));
                        fileWriter.writeObject(userList);
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }

                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }
        } else {
            try {
                userFile.createNewFile();
                fileWriter = new ObjectOutputStream(new FileOutputStream(userFile));
                if (verify.validName(user.getUserName()) || verify.validPassword(user.getUserPassword())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid User Credentials");
                    return;
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "User Registered Successfully");
                    userList.add(user);
                    fileWriter.writeObject(userList);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public User signInUser(String userName, String userPassword) {
        // System.out.println(userFile.getPath());
        if (userFile.exists() && userFile.isFile()) {
            // System.out.println("File Available");
            try {
                fileReader = new ObjectInputStream(new FileInputStream(userFile));
                while (true) {
                    userList = (ArrayList<User>) fileReader.readObject();
                }
            } catch (EOFException e) {
                for (User u : userList) {
                    if (u.getUserName().equals(userName) && u.getUserPassword().equals(userPassword)) {
                        // System.out.println(u.toString());
                        return u;
                    }
                }
            } catch (IOException | ClassNotFoundException x) {
                x.printStackTrace();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public Admin signInAdmin(String inputName, String inputPassword) {
        if (adminFile.exists() && adminFile.isFile()) {
            try {
                fileReader = new ObjectInputStream(new FileInputStream(adminFile));
                while (true) {
                    adminList = (ArrayList<Admin>) fileReader.readObject();
                }
            } catch (EOFException e) {
                for (Admin admin : adminList) {
                    if (admin.getAdminName().equalsIgnoreCase(inputName)
                            && admin.getAdminPassword().equalsIgnoreCase(inputPassword)) {
                        return admin;
                    }
                }
            } catch (IOException | ClassNotFoundException r) {
                r.printStackTrace();
            }

        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public void signUpAdmin(Admin a) {
        Verification verify = new Verification();
        boolean control = true;
        if (adminFile.exists()) {
            try {
                fileReader = new ObjectInputStream(new FileInputStream(adminFile));
                while (true) {
                    adminList = (ArrayList<Admin>) fileReader.readObject();
                }
            } catch (EOFException d) {
                if (verify.validName(a.getAdminName()) || verify.validPassword(a.getAdminPassword())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid Credentials ");
                    control = false;
                } else {
                    for (Admin admin : adminList) {
                        if (admin.getAdminName().equals(a.getAdminName())) {
                            JOptionPane.showMessageDialog(new JFrame(), "User Already Exits");
                            control = false;
                        }
                    }
                }
                if (control) {
                    adminList.add(a);
                    JOptionPane.showMessageDialog(new JFrame(), "User Registered Successfully");
                    try {
                        fileWriter = new ObjectOutputStream(new FileOutputStream(adminFile));
                        fileWriter.writeObject(adminList);
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }

                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }
        } else {
            try {
                adminFile.createNewFile();
                fileWriter = new ObjectOutputStream(new FileOutputStream(adminFile));
                if (verify.validName(a.getAdminName()) || verify.validPassword(a.getAdminPassword())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid User Credentials");
                    return;
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Admin Registered Successfully");
                    adminList.add(a);
                    fileWriter.writeObject(adminList);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
