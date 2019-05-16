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
public class OutsourcedPart extends Part{
    
    // Class variables
    String companyName;
    
    //Class Constructor
    public OutsourcedPart( int partID, String name, double price, int inStock, int min, int max, String companyName){
        setPartID(partID);
        setName(name);
        setPrice(price);
        setInStock(inStock);
        setMin(min);
        setMax(max);
        setCompanyName(companyName);
    }
    public OutsourcedPart(){}
    
    //Class methods
    public void setCompanyName(String CompanyName){
        companyName = CompanyName;
    }
    public String getCompanyName(){
        return companyName;
    }
}
