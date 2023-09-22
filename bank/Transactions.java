import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Transactions {
    private final Queue<Transaction> transactionQueue;

    public Transactions(List<Transaction> transactions) {
        this.transactionQueue = new ConcurrentLinkedQueue<>(transactions);
    }

    public synchronized Transaction getTransaction() {
        return transactionQueue.poll();
    }
}

