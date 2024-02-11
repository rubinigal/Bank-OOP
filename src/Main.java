import java.util.ArrayList;
import java.util.Random;

public class Main {
	static final int MAX_RANDOM = 10000;
	// Main
	public static void main(String[] args) {
		// Adding bank accounts
		ArrayList<BankAccount> accounts = new ArrayList<>();
		accounts.add(new ServiceChargeChecking("1", "Dudu", "1111", 6557));
		accounts.add(new NoServiceChargeChecking("2", "Adi", "2222", 6557));
		accounts.add(new InterestChecking("3", "Kobi", "3333", 6557, 1000));
		accounts.add(new SavingsAccount("4", "David", "4444", 6557));
		accounts.add(new HighInterestSavings("5", "Aster", "5555", 6557, 12));
		int size = accounts.size();
		Random random = new Random();
		
		printAccounts(accounts);
		
		// Adding balance to bank accounts
		System.out.println("Adding to balance");
		for (int i = 0; i < size; i++) {
			accounts.get(i).addToBalance(random.nextInt(MAX_RANDOM));
		}
		printAccounts(accounts);
		
		// Withdrawing balance from bank accounts, might take a couple of runs to get an error
		System.out.println("Removing from balance");
		for (int i = 0; i < size; i++) {
			try {
				accounts.get(i).removeFromBalance(random.nextInt(MAX_RANDOM));
			} catch (IllegalBalance e) {
				System.out.println("Error: Account number " + accounts.get(i).getNumAccount() + " did not withdraw money.");
			}
		}
		printAccounts(accounts);
		
		// Only run once a month :)
		System.out.println("Proccecing monthly management");
		for (int i = 0; i < size; i++) {
			accounts.get(i).monthlyManagement();
		}
		printAccounts(accounts);		
	}
	
	// Return account type SavingsAccount
	public static String whatKind(BankAccount user) {
		if (user instanceof InterestChecking) {
			return "InterestChecking Account: ";
		} else if (user instanceof NoServiceChargeChecking) {
			return "NoServiceChargeChecking Account: ";
		} else if (user instanceof ServiceChargeChecking) {
			return "ServiceChargeChecking Account: ";
		} else if (user instanceof HighInterestSavings) {
			return "HighInterestSavings Account: ";
		} else {
			return "SavingsAccount Account: ";
		}
	}
	
	// Print all the accounts in the array
	public static void printAccounts(ArrayList<BankAccount> accounts) {
		for (int i = 0; i < accounts.size(); i++) {
			System.out.println(whatKind(accounts.get(i)) + accounts.get(i).toString());
		}
		System.out.println();
	}
}
