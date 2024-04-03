/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;
/**
 *
 * @author Original Shop
 */
public class CurrentAccount extends Account implements java.io.Serializable {
    private double creditLimit ; 

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double CreditLimit) {
        this.creditLimit = CreditLimit;
    }

    public CurrentAccount(String name,double CreditLimit,double balance) {
        super(name, balance);
        this.creditLimit = CreditLimit;
    }

    @Override
    public String toString() {
        return super.toString() +"("+creditLimit+" authorized)\n";
    }
    
   
    
}
