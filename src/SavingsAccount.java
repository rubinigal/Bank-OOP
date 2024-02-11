
public class SavingsAccount extends BankAccount {
	protected static final double SAVING_INTEREST = 10;
	private double _savingInterest;
	
	// Builder with default saving interest
	public SavingsAccount(String numAccount, String name, String id, double balance) {
		super(numAccount, name, id, balance);
		_savingInterest = SAVING_INTEREST;
	}
	
	// Builder without default saving interest
	public SavingsAccount(String numAccount, String name, String id, double balance, double savingInterest) {
		super(numAccount, name, id, balance);
		setSavingInterest(savingInterest);
	}
	
	// Getter
	public double getSavingInterest() {
		return _savingInterest;
	}
	
	// Setter
	public void setSavingInterest(double savingInterest) {
	// Fee can not be negative
	if (savingInterest < 0)
		_savingInterest = 0;
	_savingInterest = savingInterest;
	}
	
	// Interest is by percentage
	public double savingInterestCalculate(double savingInterest) {
		double balance = this.getBalance();
		if (balance <= 0)
			return 0;
		return (balance*(_savingInterest/100 + 1) - balance);
	}
	
	// We add the monthly interest
	public void monthlyManagement() {
		this.setBalance(this.getBalance() + savingInterestCalculate(_savingInterest));
	}
	
	// Override
    public String toString() {
        return super.toString() + "| Saving Interest: " + _savingInterest;
    }
    
    public boolean equals(Object obj) {
        // Check if the other object is null
        if (obj == null) {
            return false;
        }
        // Check if the other object is an instance of NoServiceChargeChecking
        if (!(obj instanceof SavingsAccount)) {
            return false;
        }
        // Convert the other object to a NoServiceChargeChecking
        SavingsAccount otherAccount = (SavingsAccount) obj;
        // Compare the values of instance variables for equality
        return super.equals(otherAccount) && Double.compare(_savingInterest, otherAccount._savingInterest) == 0;
    }		
}
