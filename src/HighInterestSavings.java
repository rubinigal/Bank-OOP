
public class HighInterestSavings extends SavingsAccount {
	private static final double SAVING_INTEREST_HIGH = SAVING_INTEREST + 1;
	private static final double MIN_BALANCE = 100;
	private double _minBalance;
	
	// Builder with default minimum balance
	public HighInterestSavings(String numAccount, String name, String id, double balance, double savingInterest) {
		super(numAccount, name, id, balance, savingInterest);
		this.setSavingInterest(checkMinBalance(savingInterest));
		_minBalance = MIN_BALANCE;
	}
	
	// Builder without default minimum balance
	public HighInterestSavings(String numAccount, String name, String id, double balance, double savingInterest, double minBalance) {
		super(numAccount, name, id, balance);
		this.setSavingInterest(checkMinBalance(savingInterest));
		setMinBalance(minBalance);
	}
	
	// Getter
	public double getMinBalance() {
		return _minBalance;
	}
	
	// Setter
	public void setMinBalance(double minBalance) {
		// Minimum balance can not be negative
		if (minBalance < 0)
			_minBalance = 0;
		_minBalance = minBalance;
	}
	
	// Here i will check that my saving interest is higher then the SavingsAccount account
	private double checkMinBalance(double savingInterest) {
		if (savingInterest < SAVING_INTEREST_HIGH)
			return SAVING_INTEREST_HIGH;
		return savingInterest;
	}
	
	// Override
    public String toString() {
        return super.toString() + "| Minimum Balance: " + _minBalance;
    }
    
    public boolean equals(Object obj) {
        // Check if the other object is null
        if (obj == null) {
            return false;
        }
        // Check if the other object is an instance of NoServiceChargeChecking
        if (!(obj instanceof HighInterestSavings)) {
            return false;
        }
        // Convert the other object to a NoServiceChargeChecking
        HighInterestSavings otherAccount = (HighInterestSavings) obj;
        // Compare the values of instance variables for equality
        return super.equals(otherAccount) && Double.compare(_minBalance, otherAccount._minBalance) == 0;
    }
}
