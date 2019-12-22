import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DepositAccount extends PaymentAccount {
    private Date lastPaymentDay;

    DepositAccount(double money, String date) {
        super(money);
        lastPaymentDay = dateFormat(date);
    }

    @Override
    public void putMoney(double money) {
        System.out.println("Укажите дату внесения средств.");
    }

    public void putMoney(double money, String date){
        super.putMoney(money);
        lastPaymentDay = dateFormat(date);
    }

    public void withdrawMoney(double money){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date minusMonth = calendar.getTime();
        if(minusMonth.after(lastPaymentDay) && moneyAmount >= money) {
            super.withdrawMoney(money);
        }
        else{
            System.out.println("Деньги на счёт были внесены менее месяца назад.");
        }
    }

    protected Date dateFormat(String str){
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
    public double getMoneyAmount() {
        return moneyAmount;
    }
}
