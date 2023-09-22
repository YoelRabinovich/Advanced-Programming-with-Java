import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BankTeller implements Runnable
{

	private Transactions transactions;
	private Map<Long, BankAccount> accounts;
	private int TellerId;
	private static int nextId;


	public BankTeller(Transactions tr, ArrayList<BankAccount> accounts)
	{
		TellerId = nextId++;
		transactions = tr;
		this.accounts = new HashMap<Long, BankAccount>();
		for (BankAccount bank : accounts)
		{
			this.accounts.put(bank.getAccountNumber(), bank);
		}
	}

	@Override
	public void run()
	{
		Transaction transaction = transactions.getTransaction();
		while (transaction != null)
		{
			long aaccountNo = transaction.getAccountNumber();
			BankAccount ba = accounts.get(aaccountNo);
			System.out.println(String.format("Teller number %d about to %s sum of %.2f %s account %d. Account balance is: %.2f",
					TellerId, (transaction.getSum() < 0) ? "withdraw" : "deposit", transaction.getSum(), (transaction.getSum() < 0) ? "from" : "to", aaccountNo, ba.accountBalance()));

			ba.transaction(transaction.getSum());
			System.out.println(String.format("Teller number %d completed %s %.2f %s account %d. Account balance is: %.2f",
					TellerId, (transaction.getSum() < 0) ? "withdraw" : "deposit", Math.abs(transaction.getSum()), (transaction.getSum() < 0) ? "from" : "to", aaccountNo, ba.accountBalance()));


			try
			{
				Thread.sleep((long)(101*Math.random()));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			transaction = transactions.getTransaction();
		}
	}

}




