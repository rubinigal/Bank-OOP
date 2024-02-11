
public class NoServiceChargeChecking extends CheckingAccount {
	protected static final double MIN_BALANCE = 100;
	private double _minBalance;
	
	// Builder with default minimum balance
	public NoServiceChargeChecking(String numAccount, String name, String id, double balance) {
		super(numAccount, name, id, balance);
		_minBalance = MIN_BALANCE;
	}
	
	// Builder without default minimum balance
	public NoServiceChargeChecking(String numAccount, String name, String id, double balance, double minBalance) {
		super(numAccount, name, id, balance);
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
	
	// Have to implement abstract function
	public void monthlyManagement() {
		return;
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
        if (!(obj instanceof NoServiceChargeChecking)) {
            return false;
        }
        // Convert the other object to a NoServiceChargeChecking
        NoServiceChargeChecking otherAccount = (NoServiceChargeChecking) obj;
        // Compare the values of instance variables for equality
        return super.equals(otherAccount) && Double.compare(_minBalance, otherAccount._minBalance) == 0;
    }		
}
