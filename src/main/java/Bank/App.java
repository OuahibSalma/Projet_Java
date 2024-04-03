/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Original Shop
 */
public class App {
        private final Authorization myAuthorization;
        
        public App (Authorization authorization) {
            this.myAuthorization = authorization;
    }
    public boolean grantAccess() { 
        Scanner input = new Scanner(System.in);
        System.out.print("Entrer votre username : ");
        String username = input.nextLine(); 
        System.out.print("Entrer votre mot de passe : ");
        String password = input.nextLine(); 
        input.close();
        if (myAuthorization.authorize(username, password)) {
            System.out.println("Authentication successful. Access granted.\n");
            // Proceed to account operations
            return true;
	} else {
            System.out.println("Authentication failed. Access denied.");
            // Exit or prompt user to try again
            return false;
		}
    } 
    public void proceed() {
	List<Account> accounts =List.of(
            new CurrentAccount( "Karim" ,100000,  500 ),
            new SavingAccount("Salma",5 ,100000 )
            );
	Random random = new Random();
        
	for (int i = 0; i < 5; i++) {
            //get an account from accounts
            int i1 = random.nextInt(accounts.size());//0,1
            //
            var account1 = accounts.get(i1);  //0,1
            var account2 = accounts.get(1-i1);//1,0
            int operation = random.nextInt(3);//0,1,2
            double amount = random.nextDouble(500.0);
            switch(operation){
		case 0: //Operation.DEPOSIT
                    account1.deposit(amount);
        	    break;
                case 1: //Operation.WITHDRAW
        		try {
				account1.withdraw(amount);
                        } catch (InsufficientFundException  e) {
				System.out.println(e);
			}
			break;
                case 2: //Operation.TRANSFER 
				account1.transfer(amount,account2);
				break;
			default :
				throw new IllegalArgumentException("Operation not considered!");
			}
		}
		// Print the statements (operations) of the accounts
		for(Account account : accounts) {
			System.out.println(account.bankStatement());
		}
	}//end of proceed
}

