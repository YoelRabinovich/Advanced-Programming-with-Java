import java.util.ArrayList;

public class Bank
{
	public void runBank()
	{
		ArrayList<BankAccount> accountList = new ArrayList<>();
		for (int i = 0; i < 5; i++)
		{
			accountList.add(new BankAccount(i, 0));
		}

		ArrayList<Transaction> transactionList = new ArrayList<>();
		for (int j = 0; j < 10; j++)
		{
			int accountNumber = (int) (Math.random() * 5);
			int sum = -1000 + (int) (4001 * Math.random());
			transactionList.add(new Transaction(accountNumber, sum));
		}
		Transactions transactions = new Transactions(transactionList);

		for (int j = 0; j < 10; j++)
		{
			new Thread(new BankTeller(transactions, accountList)).start();
		}
	}
}


