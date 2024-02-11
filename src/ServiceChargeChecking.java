
public class ServiceChargeChecking extends CheckingAccount {
	private static final double MONTHLY_FEE = 100;
	private double _monthlyFee;
	
	// Builder with default monthly fee
	public ServiceChargeChecking(String numAccount, String name, String id, double balance) {
		super(numAccount, name, id, balance);
		_monthlyFee = MONTHLY_FEE;
	}
	
	// Builder without default monthly fee
	public ServiceChargeChecking(String numAccount, String name, String id, double balance, double monthlyFee) {
		super(numAccount, name, id, balance);
		setMonthlyFee(monthlyFee);
	}
	
	// Getter
	public double getMonthlyFee() {
		return _monthlyFee;
	}
	
	// Setter
	public void setMonthlyFee(double monthlyFee) {
		// Fee can not be negative
		if (monthlyFee < 0)
			_monthlyFee = 0;
		_monthlyFee = monthlyFee;
	}
	
	public void monthlyManagement() {
		this.setBalance(this.getBalance() - _monthlyFee);
	}
	
	// Override
    public String toString() {
        return super.toString() + "| Monthly Fee: " + _monthlyFee;
    }
    
    public boolean equals(Object obj) {
        // Check if the other object is null
        if (obj == null) {
            return false;
        }
        // Check if the other object is an instance of ServiceChargeChecking
        if (!(obj instanceof ServiceChargeChecking)) {
            return false;
        }
        // Convert the other object to a ServiceChargeChecking
        ServiceChargeChecking otherAccount = (ServiceChargeChecking) obj;
        // Compare the values of instance variables for equality
        return super.equals(otherAccount) && Double.compare(_monthlyFee, otherAccount._monthlyFee) == 0;
    }
}
