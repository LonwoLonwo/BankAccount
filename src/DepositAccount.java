import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DepositAccount extends PaymentAccount {
    private int moneyAmount;
    private Date lastPaymentDay;

    DepositAccount(int money, String date) {
        super(money);
        moneyAmount = money;
        lastPaymentDay = dateFormat(date);
    }

    @Override
    public void putMoney(int money) {
        System.out.println("Укажите дату внесения средств.");
    }

    public void putMoney(int money, String date){
        moneyAmount += money;
        lastPaymentDay = dateFormat(date);
    }

    public void withdrawMoney(int money){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date minusMonth = calendar.getTime();
        if(moneyAmount < money){
            System.out.println("Недостаточно средств на счету для продолжения операции.");
        }
        else if(minusMonth.after(lastPaymentDay) && moneyAmount >= money) {
            moneyAmount -= money;
        }
        else{
            System.out.println("Деньги на счёт были внесены менее месяца назад.");
        }
    }

    private Date dateFormat(String str){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public int getMoneyAmount() {
        return moneyAmount;
    }
}
