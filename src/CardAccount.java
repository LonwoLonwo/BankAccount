public class CardAccount extends PaymentAccount{

    CardAccount(double money) {
        super(money);
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }
    @Override
    public void putMoney(double money) {
        super.putMoney(money);
    }

    @Override
    public void withdrawMoney(double money) {
        if(money > (money*0.01 + moneyAmount)){
            System.out.println("Недостаточно средств на счету для продолжения операции.");
        }
        else {
            moneyAmount = moneyAmount - money - money * 0.01;
        }
    }
}
