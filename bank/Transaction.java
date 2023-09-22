public class Transaction
{
	private long accountNumber;
	private double amount;

	public Transaction(long accountNumber, double amount)
	{
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public long getAccountNumber()
	{
		return accountNumber;
	}

	public double getSum()
	{
		return amount;
	}
}
