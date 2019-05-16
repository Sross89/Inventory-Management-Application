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
public class InhousePart extends Part {
    // Class variables
    int machineID;
    
    //Class Constructor
    public InhousePart(int partID, String name, double price, int inStock, int min, int max, int machineID){
        setPartID(partID);
        setName(name);
        setPrice(price);
        setInStock(inStock);
        setMin(min);
        setMax(max);
        setMachineID(machineID);
    }
    public InhousePart(){}
    
    //Class methods
    public void setMachineID(int MachineID){
        machineID = MachineID;
    }
    public int getMachineID(){
        return machineID;
    }
}
