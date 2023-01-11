package SystemDataControllers;

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

import GroceryStore.Category;

public class CategoryFileIO implements Serializable {

    File categoryFile;
    ObjectInputStream reader;
    ObjectOutputStream writer;
    ArrayList<Category> categoryList;
    String currentPath;

    public CategoryFileIO() {
        currentPath = System.getProperty("user.dir");
        writer = null;
        reader = null;
        categoryList = new ArrayList<Category>();
        categoryFile = null;
    }

    @SuppressWarnings("unchecked")

    public void writeCategory(Category obj) {
        categoryFile = new File(currentPath + "/DataBase/Category.txt");
        boolean control = true;
        if (categoryFile.exists() && categoryFile.isFile()) {
            try {
                reader = new ObjectInputStream(new FileInputStream(categoryFile));
                while (true) {
                    categoryList = (ArrayList<Category>) reader.readObject();
                }
            } catch (EOFException e) {
                for (Category category : categoryList) {
                    if (obj.getCategoryName().equals(category.getCategoryName())) {
                        JOptionPane.showMessageDialog(new JFrame(), "Category Already Exists");
                        control = false;
                    }

                }
                if (obj.getCategoryName().equals("Name") || obj.getCategoryImage().equals(null)) {
                    JOptionPane.showMessageDialog(new JFrame(), "Please Enter Category Name or Image ");
                    control = false;
                }
                if (control) {
                    categoryList.add(obj);
                    try{
                        writer = new ObjectOutputStream(new FileOutputStream(categoryFile));
                        writer.writeObject(categoryList);
                        writer.flush();
                        writer.close();
                    }
                    catch(IOException d){
                        d.printStackTrace();
                    }
                }
            }
            catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        else{
            try{
                categoryFile.createNewFile();
                writer = new ObjectOutputStream(new FileOutputStream(categoryFile));
                categoryList.add(obj);
                writer.writeObject(categoryList);
                writer.flush();
                writer.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }



    @SuppressWarnings("unchecked")
    public ArrayList<Category> readCategories(){
        categoryFile = new File(currentPath+"/DataBase/Category.txt");

        if(categoryFile.exists() && categoryFile.isFile()){
            try{
                reader = new ObjectInputStream(new FileInputStream(categoryFile));
                while(true){
                    categoryList = (ArrayList<Category>) reader.readObject();
                }
            }catch(EOFException e){
                return categoryList;
            }
            catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return categoryList;
    }


    @SuppressWarnings("unchecked")
    public void removeCategory(Category removeCat){
        categoryFile = new File(currentPath+"/DataBase/Category.txt");
        if(categoryFile.exists() && categoryFile.isFile()){
            try{
                reader = new ObjectInputStream(new FileInputStream(categoryFile));
                while(true){
                    categoryList = (ArrayList<Category>) reader.readObject();
                }
            }catch(EOFException e){
                for (Category category : categoryList) {
                    if(category.getCategoryName().equals(removeCat.getCategoryName())){
                        categoryList.remove(category);
                        JOptionPane.showMessageDialog(new JFrame(), "Category Removed Successfully");
                        try{
                            writer = new ObjectOutputStream(new FileOutputStream(categoryFile));
                            writer.writeObject(categoryList);
                            writer.flush();
                            writer.close();
                        }
                        catch(IOException d){
                            d.printStackTrace();
                        }
                        break;
                    }
                }
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
                return;
            }
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(), "No Category To Remove ");
            return;
        }

    }

}
