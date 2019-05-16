/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author USER
 */
public class Inventory {
    
    //Class variables
    public static ArrayList<Product> products = new ArrayList<>();
    public static ArrayList<Part> allParts= new ArrayList<>();
    
    //Class methods
    public void addProduct(Product input){
        products.add(input);
    }
    public boolean removeProduct(int input){
        boolean productRemoved = false;
        if (input < products.size()){
            products.remove(input);
            productRemoved = true;
        }
        return productRemoved;
    }
    public Product lookupProduct(int input){
        //exception handling will be done later
        Product temp = new Product();
        temp = products.get(input);
        return temp;
    }
    public void updateProduct(int input){
        //to do
    }
    public void addPart(Part input){
        allParts.add(input);
    }
    public boolean deletePart(Part input){
        boolean partRemoved = false;
        if (allParts.contains(input)){
            allParts.remove(input);
            partRemoved = true;
        }
        return partRemoved;
    }
    public Part lookupPart(int input){
        //exception handling will be done later
        return (allParts.get(input));
    }
    public void updatePart(int input){
        //to do
    }
}

