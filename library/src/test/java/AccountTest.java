import com.thoughtworks.step_bank.Account;
import com.thoughtworks.step_bank.InvalidAccountNumberException;
import com.thoughtworks.step_bank.LowAmountException;
import com.thoughtworks.step_bank.MinimumBalanceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws MinimumBalanceException, InvalidAccountNumberException {
        account = new Account("1111-1111",1000.0);
    }

    @Test
    public void checkBalance() {
        assertThat(account.getBalance(),is(1000.0));
    }

    @Test
    public void checkAccountNumber() {
        assertThat(account.getAccountNumber(),is("1111-1111"));
    }

    @Test (expected = MinimumBalanceException.class)
    public void checkMinimumBalance() throws MinimumBalanceException,InvalidAccountNumberException {
        new Account("1011-2222",10);
    }

    @Test
    public void checkCredit() throws LowAmountException {
        assertThat(account.credit(1000),is(2000.0));
    }

    @Test
    public void checkDebit() throws MinimumBalanceException, LowAmountException {
        account.credit(1000);
        assertThat(account.getBalance(),is(2000.0));
        assertThat(account.debit(1000),is(1000.0));
    }

    @Test (expected = MinimumBalanceException.class)
    public void debitValidation() throws MinimumBalanceException{
        account.debit(950);
        assertThat(account.getBalance(),is(1000.0));
    }

    @Test (expected = InvalidAccountNumberException.class)
    public void accountNumberValidation() throws InvalidAccountNumberException, MinimumBalanceException {
        new Account("1111",1000);
    }

    @Test
    public void checkCanCredit() {
        assertTrue(account.canCredit(100));
    }

    @Test (expected = LowAmountException.class)
    public void checkLowAmountException() throws LowAmountException {
        account.credit(-4);
    }
}
