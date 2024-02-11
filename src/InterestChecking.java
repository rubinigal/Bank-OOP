
public class InterestChecking extends NoServiceChargeChecking {
	private static final double MIN_BALANCE_HIGH = MIN_BALANCE + 1;
	private static final double INTEREST = 5;
	private double _interest;
	
	// Builder with default interest
	public InterestChecking(String numAccount, String name, String id, double balance, double minBalance) {
		super(numAccount, name, id, balance, minBalance);
		this.setMinBalance(checkMinBalance(minBalance));
		_interest = INTEREST;
		
	}
	
	// Builder without default interest
	public InterestChecking(String numAccount, String name, String id, double balance, double minBalance, double interest) {
		super(numAccount, name, id, balance, minBalance);
		this.setMinBalance(checkMinBalance(minBalance));
		setInterest(interest);
	}
	
	// Getter
	public double getInterest() {
		return _interest;
	}
	
	// Setter
	public void setInterest(double interest) {
	// Fee can not be negative
	if (interest < 0)
		_interest = 0;
	_interest = interest;
	}
	
	// Here i will check that my min balance is higher then the NoServiceChargeChecking account
	private double checkMinBalance(double minBalance) {
		if (minBalance < MIN_BALANCE_HIGH)
			return MIN_BALANCE_HIGH;
		return minBalance;
	}
	
	// Interest is by percentage
	public double interestCalculate(double interest) {
		double balance = this.getBalance();
		if (balance <= 0)
			return 0;
		return (balance*(_interest/100 + 1) - balance);
	}
	
	// We add the monthly interest
	public void monthlyManagement() {
		this.setBalance(this.getBalance() + interestCalculate(_interest));
	}
	
	// Override
    public String toString() {
        return super.toString() + "| Interest: " + _interest;
    }
    
    public boolean equals(Object obj) {
        // Check if the other object is null
        if (obj == null) {
            return false;
        }
        // Check if the other object is an instance of NoServiceChargeChecking
        if (!(obj instanceof InterestChecking)) {
            return false;
        }
        // Convert the other object to a NoServiceChargeChecking
        InterestChecking otherAccount = (InterestChecking) obj;
        // Compare the values of instance variables for equality
        return super.equals(otherAccount) && Double.compare(_interest, otherAccount._interest) == 0;
    }
}
