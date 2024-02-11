
public abstract class BankAccount {
	private String _numAccount;
	private String _name;
	private String _id;
	private double _balance;
	
	// Builder
	public BankAccount(String numAccount, String name, String id, double balance) {
		_numAccount = numAccount;
		_name = name;
		_id = id;
		_balance = balance;
	}
	
	 // Getters
    public String getNumAccount() {
        return _numAccount;
    }

    public String getName() {
        return _name;
    }

    public String getId() {
        return _id;
    }

    public double getBalance() {
        return _balance;
    }

    // Setters
    public void setNumAccount(String numAccount) {
        _numAccount = numAccount;
    }

    public void setName(String name) {
        _name = name;
    }

    public void setId(String id) {
        _id = id;
    }

    public void setBalance(double balance) {
        _balance = balance;
    }
    
    // Functions that control the user balance
    public void addToBalance(int money) {
    	if (money > 0)
    		_balance += money;
    }
    
    public void removeFromBalance(int money) throws IllegalBalance {
    	if (_balance - money < 0) {
    		throw new IllegalBalance("Error: You cannot withdraw more money than your balance allows.");
    	}
    }
    
    // Abstract function
    public abstract void monthlyManagement();
    
    // Override
    public String toString() {
        return  "Account Number: " + _numAccount +
                "| Client Name: " + _name +
                "| Id: " + _id +
                "| Balance: " + _balance;
    }
    
    public boolean equals(Object obj) {
        // Check if the other object is null
        if (obj == null) {
            return false;
        }
        // Check if the other object is an instance of BankAccount
        if (!(obj instanceof BankAccount)) {
            return false;
        }
        // Convert the other object to a BankAccount
        BankAccount otherAccount = (BankAccount) obj;
        // Compare the values of instance variables for equality
        return _numAccount.equals(otherAccount._numAccount) &&
                _name.equals(otherAccount._name) &&
                _id.equals(otherAccount._id) &&
                Double.compare(_balance, otherAccount._balance) == 0;
    }
}

