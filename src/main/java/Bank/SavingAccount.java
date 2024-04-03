/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;

/**
 *
 * @author Original Shop
 */
public class SavingAccount extends Account implements java.io.Serializable{
    private final double rate ; 

    public SavingAccount(String name,double balance,double rate) {
        super(name, balance);
        this.rate = rate;
    }
    @Override
    public String toString() {
        return super.toString() +"(rate="+rate*100+"%)\n";
    }
    
    @Override
    public void deposit(double amount) {
        super.deposit(amount*(1+rate));
    }
    
}
