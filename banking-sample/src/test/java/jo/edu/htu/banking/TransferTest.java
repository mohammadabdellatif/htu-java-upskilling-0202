package jo.edu.htu.banking;

public class TransferTest {

    public static void main(String[] args) {
        Account debit = new Account("98765", "Mohammad");
        Account credit = new Account("12345", "Sami");
        try {
            debit.deposit(350);
        } catch (DepositException e) {
            System.out.println("unable to deposit initial amount");
            return;
        }

        TransferHandler handler = new TransferHandler();

        try {
            handler.transfer(debit, credit, 100);
            System.out.println("successful transaction");
        } catch (TransferException e) {
            System.out.println("unable to transfer: " + e.getMessage());
        }
    }
}
