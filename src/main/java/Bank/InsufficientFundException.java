/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Bank;

/**
 *
 * @author Original Shop
 */
public class InsufficientFundException extends Exception{
    	Account account;
	Double amount;
	//
	public InsufficientFundException(Account account, Double amount) {
		super();
		this.account = account;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return 	String.format(
				"InsufficientFundException : credit limit exceeded (%s %.2f)", 
				account.getName(),amount);
	}
    /**
     * Creates a new instance of <code>InsufficientFundException</code> without
     * detail message.
     */
    public InsufficientFundException() {
    }

    /**
     * Constructs an instance of <code>InsufficientFundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InsufficientFundException(String msg) {
        super(msg);
    }
}
