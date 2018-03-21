import com.thoughtworks.step_bank.Account;
import com.thoughtworks.step_bank.InvalidAccountNumberException;
import com.thoughtworks.step_bank.LowAmountException;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws LowAmountException, InvalidAccountNumberException {
        account = new Account("ketan","1111-1111",1000.0);
    }

    @Test
    public void checkBalance() {
        assertThat(account.getBalance(),is(1000.0));
    }

    @Test
    public void checkAccountNumber() {
        assertThat(account.getAccountNumber(),is("1111-1111"));
    }

    @Test (expected = LowAmountException.class)
    public void checkMinimumBalance() throws LowAmountException,InvalidAccountNumberException {
        new Account("ketan","1011-2222",10);
    }

    @Test
    public void checkCredit() throws LowAmountException {
        assertThat(account.credit(1000),is(2000.0));
    }

    @Test
    public void checkDebit() throws LowAmountException, LowAmountException {
        account.credit(1000);
        assertThat(account.getBalance(),is(2000.0));
        assertThat(account.debit(1000),is(1000.0));
    }

    @Test (expected = LowAmountException.class)
    public void debitValidation() throws LowAmountException{
        account.debit(950);
        assertThat(account.getBalance(),is(1000.0));
    }

    @Test (expected = InvalidAccountNumberException.class)
    public void accountNumberValidation() throws InvalidAccountNumberException, LowAmountException {
        new Account("ketan","1111",1000);
    }

    @Test
    public void checkCanCredit() {
        assertTrue(account.canCredit(100));
    }

    @Test
    public void checkCanDebit() {
        assertTrue(account.canDebit(10));
    }

    @Test (expected = LowAmountException.class)
    public void checkLowAmountException() throws LowAmountException {
        account.credit(-4);
    }

    @Test
    public void getAccountHolderName() {
        assertThat(account.getAccountHolder(),is("ketan"));
    }

    @Test
    public void checkSummary() {
        String summary=account.getSummary();
        assertThat(summary,is("Account{accountNumber='1111-1111', accountHolder='ketan', balance=1000.0}"));
    }
}
