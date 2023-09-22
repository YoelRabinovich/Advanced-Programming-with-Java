

public class BankAccount
{
	private long accountNumber;
	private volatile double accountBalance;
	private int customerId;
	private static int nextCustomerId;

	public BankAccount(long accountNumber, double accountBalance)
	{
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		customerId = nextCustomerId++;
	}

	public synchronized void transaction(double sum)
	{
		
		if (accountBalance + sum < 0) {
			System.out.println(String.format("Account number %d trying to withdraw %.2f while account balance is only %.2f", 
					customerId, sum, accountBalance));
			return;
		}
		System.out.println(String.format("Account number %d %-12s %.2f. Account balance was: %.2f",
				customerId, "attempted "+(sum < 0 ? "withdraw" : "deposit"), Math.abs(sum), accountBalance));

		accountBalance += sum;
		System.out.println(String.format("Account number %d %-12s %.2f. Account balance now: %.2f",
				customerId, "completed "+(sum < 0 ? "withdraw" : "deposit"), Math.abs(sum), accountBalance));


		notifyAll();
	}

	public synchronized double accountBalance()
	{
		return accountBalance;
	}

	public long getAccountNumber()
	{
		return accountNumber;
	}

}

