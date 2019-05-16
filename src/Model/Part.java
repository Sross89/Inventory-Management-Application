/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author USER
 */
public abstract class Part {
    
    //Class variables
    int partID;
    String name;
    double price;
    int inStock;
    int min;
    int max;
    
    // Class methods
    public void setPartID(int PartID){
        partID = PartID;
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
    public int getPartID(){
        return partID;
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
    
}
