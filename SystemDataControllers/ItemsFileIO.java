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

import GroceryStore.Items;

public class ItemsFileIO implements Serializable {
    ArrayList<Items> itemsList;
    String currentPath;
    File itemsFile;
    ObjectInputStream fileReader;
    ObjectOutputStream fileWriter;



    public ItemsFileIO(){
        currentPath = System.getProperty("user.dir");
        itemsFile = new File(currentPath+"/DataBase/Items.txt");
        itemsList = new ArrayList<Items>();
        fileReader = null;
        fileWriter = null;
    }
    

    @SuppressWarnings("unchecked")
    public void writeItemsToFile(Items items){
        boolean control = true;


        if(itemsFile.exists() && itemsFile.isFile()){
            try{
                fileReader = new ObjectInputStream(new FileInputStream(itemsFile));
                while(true){
                    itemsList = (ArrayList<Items>) fileReader.readObject();
                }
            }
            catch(EOFException e){
                for (Items items2 : itemsList) {
                    if(items.getItemID() == items2.getItemID()){
                        JOptionPane.showMessageDialog(new JFrame(), "Items Already Exists");
                        control = false;
                    }
                }
                if(items.getItemID() ==0 || items.getItemName() == "Name" || items.getItemImage() == null){
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid Items Description ");
                    control = false;
                }
                if(control){
                    itemsList.add(items);
                    JOptionPane.showMessageDialog(new JFrame(), "Item Added Successfully");
                    try{
                        fileWriter = new ObjectOutputStream(new FileOutputStream(itemsFile));
                        fileWriter.writeObject(itemsList);
                        fileWriter.flush();
                        fileWriter.close();
                    }catch(IOException f){
                        f.printStackTrace();
                    }
                }
            }
            catch(IOException | ClassNotFoundException d){
                d.printStackTrace();
            }
        }
        else{
            try{
                itemsFile.createNewFile();
                if(items.getItemID() ==0 || items.getItemName() == "Name" || items.getItemImage() == null){
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid Items Description ");
                    return;
                }
                else{
                    itemsList.add(items);
                    fileWriter = new ObjectOutputStream(new FileOutputStream(itemsFile));
                    fileWriter.writeObject(itemsList);
                    JOptionPane.showMessageDialog(new JFrame(),"Items Added Successfully");
                    fileWriter.flush();
                    fileWriter.close();
                    
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }


    @SuppressWarnings("unchecked")
    public ArrayList<Items> readItemsFromFile(){
        if(itemsFile.exists() && itemsFile.isFile()){
            try{
                fileReader = new ObjectInputStream(new FileInputStream(itemsFile));
                while(true){
                    itemsList = (ArrayList<Items>) fileReader.readObject();
                }
            }catch(EOFException e){
                return itemsList;
            }
            catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return itemsList;
    }

    @SuppressWarnings("all")
    public void deleteItems(int itemsID){
        Items toBeDeleted = null;
        boolean result = false;
        if(itemsFile.exists() && itemsFile.isFile()){
            try{
                fileReader = new ObjectInputStream(new FileInputStream(itemsFile));
                while(true){
                    itemsList = (ArrayList<Items>) fileReader.readObject();
                }
            }catch(EOFException e){
                for (Items items : itemsList) {
                    if(items.getItemID() == itemsID){
                        toBeDeleted = items;
                        itemsList.remove(toBeDeleted);
                        result = true;
                        break;
                    }
                }
                if(!result){
                    JOptionPane.showMessageDialog(new JFrame(), "Item not found");
                }
                else{
                    try{
                        fileWriter = new ObjectOutputStream(new FileOutputStream(itemsFile));
                        fileWriter.writeObject(itemsList);
                        fileWriter.flush();
                        JOptionPane.showMessageDialog(new JFrame(), "Item Deleted Successfully");
                        fileWriter.close();
                    }catch(IOException d){
                        d.printStackTrace();
                        return;
                    }
                }
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
                return;
            }
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(),"Item not found");
            return;
        }
    }
}
