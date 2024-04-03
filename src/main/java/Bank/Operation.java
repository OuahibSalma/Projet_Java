/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;
import java.time.LocalDate ; 
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author Original Shop
 */
public class Operation implements java.io.Serializable{
    public static final String DEPOSIT = "DEPOSIT";
    public static final String WITHDRAW = "WITHDRAW";
    public static final String TRANSFER = "TRANSFER";
    private String type ; 
    private double amount ; 
    private LocalDate date ; 

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double Amount) {
        this.amount = Amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

	@Override
    public String toString() {
        String res = "\n "
        + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+"\t"
        + type;
        res +="\t";
        res += String.format("%.2f", amount);
		return res;
	}
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Operation other = (Operation) obj;
        if (Double.doubleToLongBits(this.amount) != Double.doubleToLongBits(other.amount)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }
    
    public Operation(String type, double Amount, LocalDate date) {
        this.type = type;
        this.amount = Amount;
        this.date = date;
    }
    
}
