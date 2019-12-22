import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankAccountTest
{
    private PaymentAccount pAccount;
    private DepositAccount dAccount;
    private CardAccount cAccount;
    @Before
    public void init(){
        pAccount = new PaymentAccount(100);
        dAccount = new DepositAccount(200, "20.12.2019");
        cAccount = new CardAccount(1000);
    }
    @After
    public void ruin(){
        pAccount = null;
        dAccount = null;
        cAccount = null;
    }
    @Test
    public void putMoneyTest(){
        pAccount.putMoney(300.0);
        double expected = pAccount.moneyAmount;
        double actual = 400.0;
        Assert.assertEquals(expected, actual, 1e-8);
    }
    @Test
    public void withdrawMoneyTest(){
        pAccount.withdrawMoney(90.0);
        double expected = pAccount.moneyAmount;
        Assert.assertEquals(expected, 10.0, 1e-8);
    }
    @Test
    public void withdrawMoneyDepositTest(){
        dAccount.withdrawMoney(90.0);
        String expected = "Деньги на счёт были внесены менее месяца назад.";
        Assert.assertEquals(expected, "Деньги на счёт были внесены менее месяца назад.");
    }
    @Test
    public void withdrawNotEnoughMoneyTest(){
        pAccount.withdrawMoney(110.0);
        String expected = "Недостаточно средств на счету для продолжения операции.";
        Assert.assertEquals(expected, "Недостаточно средств на счету для продолжения операции.");
    }
    @Test
    public void dateFormatTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String dateString = "01.02.2013";
        Date expected = dAccount.dateFormat(dateString);
        Date actual = format.parse(dateString);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void withdrawMoneyCardAccountTest(){
        cAccount.withdrawMoney(100);
        double expected = cAccount.moneyAmount;
        Assert.assertEquals(expected, 890.0, 1e-8);
    }
}
