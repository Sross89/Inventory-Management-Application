/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.sql.JDBCType.NULL;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Product {
    
    //Class variables
    ArrayList<Part> associatedParts= new ArrayList<>();
    int productID;
    String name;
    double price;
    int inStock;
    int min;
    int max;
    
    //Constructors
    public Product(){}
    public Product(int productID, String name, double price, int inStock, int min, int max){
        setProductID(productID);
        setName(name);
        setPrice(price);
        setInStock(inStock);
        setMin(min);
        setMax(max);
    }
    
    //Class methods
    public void setProductID(int ProductID){
        productID = ProductID;
    }
    public void setName(String Name){
        name = Name;
    }
    public void setPrice(double Price){
        price = Price;
    }
    public void setInStock(int InStock){
        inStock = InStock;
    }
    public void setMin(int Min){
        min = Min;
    }
    public void setMax(int Max){
        max = Max;
    }
    public int getProductID(){
        return productID;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getInStock(){
        return inStock;
    }
    public int getMin(){
        return min;
    }
    public int getMax(){
        return max;
    }
    
    // Other methods
    public void addAssociatedPart(Part input){
        associatedParts.add(input);
    }
    public boolean removeAssociatedPart(int input){
        boolean productRemoved = false;
        if (input < associatedParts.size()){
            associatedParts.remove(input);
            productRemoved = true;
        }
        return productRemoved;
    }
    public Part lookupAssociatedPart(int input){
        // Exception handling will be done later.
        return associatedParts.get(input);
    }
    

    
}
