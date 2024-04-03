/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;
import java.util.ArrayList; 
import java.util.List ; 
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Random;
import java.sql.DriverManager; // Charger et configurer le driver de la base de donn�es.
import java.sql.Connection; // R�aliser la connexion et l'authentification � la base de donn�es.
import java.sql.Statement; //  D�finir et ex�cuter la requ�te SQL sur la base de donn�es.
import java.sql.PreparedStatement; // D�finir et ex�cuter la requ�te SQL param�tr�e 
import java.sql.ResultSet; // Parcourir les informations retourn�es par la base de donn�es 
import java.sql.SQLException; // Gestion des exceptions 


/**
 *
 * @author Original Shop
 */
public class Bank {
    private List<Account> accounts ; 
    private String name;
    public static String FILENAME ="bank.dta";
    private static final Bank INSTANCE  = new Bank();
    private Bank(){
	System.out.println("Bank created (single instance)");
	accounts = new ArrayList<>();	
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Account> getAccounts() {
        return accounts;
    }
    public static Bank getInstance() {
        return INSTANCE;
    }
    public boolean add(Account e) {
        return accounts.add(e);
    }

	/**
	 * Saves accounts  in a file
     * @param fileName
	 * @return
	 */
    public  void save(String fileName) {
        try {
            OutputStream fos = new BufferedOutputStream(
            new FileOutputStream(fileName));
            var oos = new ObjectOutputStream (fos);
            oos.writeObject(accounts);
            oos.flush(); 
            oos.close();
    	} catch (IOException e) {
            e.printStackTrace();
	}
    }

	/**
	 * Loads the accounts from a file
     * @param fileName
	 * @return List<Account>
     * @throws java.io.FileNotFoundException
	 */
    public List<Account> load(String fileName) throws FileNotFoundException {
        List<Account> accounts1 = new ArrayList<>();
        InputStream fis = new FileInputStream(fileName) ; 
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            accounts1 = (List<Account>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.err.println("Le fichier n'a pas été trouvé : " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur de lecture du fichier : " + e.getMessage());
        }
        
        return accounts1;
    }
    public  void makeSimulation() {
        Random random = new Random();
	final int NBOFOPERATIONS = 20;
        //create 5 accounts
	accounts = List.of(
            new CurrentAccount("Anie LeRoy", 4000,500),
            new CurrentAccount("Karim Baazzi", 7000,1000),
            new CurrentAccount("Paul Jacard", 5000,1000),
            new SavingAccount("Nora Zouin", 6000,0.05),
            new SavingAccount("Omar Amir", 9000,0.1)
        );
        for (int i=0; i < NBOFOPERATIONS; i++) {
            //get an account from accounts
            int i1 = random.nextInt(accounts.size());
            int i2 =0;
            for (int j = 0; j < accounts.size(); j++) {
                i2 = random.nextInt(accounts.size());
                if(i2 != i1) break;
                }
                var account1 = accounts.get(i1);  
                var account2 = accounts.get(i2);
                int operation = random.nextInt(4);
                double amount = random.nextDouble(1000.0);
                switch(operation){
                    case 0: case 1: //DEPOSIT
                        account1.deposit(amount);
                        break;
                    case 2: //WITHDRAW
                        try {
                            account1.withdraw(amount);
                        } catch (InsufficientFundException  e) {
                            System.out.println(e);
                        }
                        break;
                    case 3: //TRANSFER 
                        account1.transfer(amount,account2);
                        break;
                        default :
                    throw new IllegalArgumentException("Operation not considered!");
		}
            }
    }
	/**
	 * Looks for an account by number in the bank
	 * @param number
	 * @return
	 */
    public Account lookFor(String number) {
        Account account = null;
        for (Account c : accounts) {
            if(c.getNumber().equals(number)) {
                account = c; 
                break;
            }
        }
        return account;
    }

	@Override
    public String toString() {
        String str ="";
        for (Account c : accounts) { 
            str += c.bankStatement();
        }
        return this.getName()+"\n"+str;
    }	
    void loadDriver() throws ClassNotFoundException {
        // Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        }
    Connection newConnection() throws SQLException {
        final String url = "jdbc:mysql://localhost/dbessai";
        Connection conn = DriverManager.getConnection(url, "root", "");
        return conn;
        }
    public void listeComptes() throws SQLException {
        Connection conn = null;
        try {
            // Etape 1: Connexion a al base de donnees
            conn = newConnection();
            // Etape 2: Cr�ation d'une requ�te SQL de selction des enregistrements
            Statement st = conn.createStatement();
            String RequeteSQLSelection1 = "SELECT Number,Nom,Balance,CreditLimit FROM CurrentAccount";
            String RequeteSQLSelection2 = "SELECT * FROM SavingAccount" ;
            // Etape 3: Execution de la requete SQL POUR Cuurent Account: 
            ResultSet rs = st.executeQuery( RequeteSQLSelection1 ); // retourne l'ensemble des enregistrements selectionn�s
            // Etape 4: L'affichage sera dans la 
            while (rs.next()) {
                String str = "Nom: " + rs.getString(1) +  " Pr�nom: " + rs.getString("prenom") + " Age: " + rs.getInt(3);
                System.out.println( str );
                }
            // Etape 5: Execution de la requete SQL pour Saving Account: 
            rs = st.executeQuery( RequeteSQLSelection2 ); // retourne l'ensemble des enregistrements selectionn�s
            // Etape 6: Parcours et traitements des r�sultats de la requ�te
            while (rs.next()) {
                String str = "Nom: " + rs.getString(1) +  " Pr�nom: " + rs.getString("prenom") + " Age: " + rs.getInt(3);
                System.out.println( str );
                }
            } 
        finally { 	// Epate 5: fermeture de la connexion � la base de donn�es
                    if (conn != null) conn.close();
                }
        }
}//La fin de la classe 

