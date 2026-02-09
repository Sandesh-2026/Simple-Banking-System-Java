import java.io.*;

public class BankService {

    private static final String FILE_NAME = "account.dat";

    public void saveAccount(Account account) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(account);
            System.out.println("Account saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Account loadAccount() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Account) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}
