
public abstract class CheckingAccount extends BankAccount {
	
	public CheckingAccount(String numAccount, String name, String id, double balance) {
		super(numAccount, name, id, balance);
		// TODO Auto-generated constructor stub
	}
	
	// Checks if you can write checks
	public void writeCheck(int money) throws IllegalBalance {
		if (this.getBalance() - money < 0) {
    		throw new IllegalBalance("Error: You cannot withdraw more money than your balance allows.");
    	}
		
	}
}
