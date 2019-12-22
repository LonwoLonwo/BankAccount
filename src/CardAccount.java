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
        if(moneyAmount < (money + moneyAmount*0.01)){
            System.out.println("Недостаточно средств на счету для продолжения операции.");
        }
        else {
            moneyAmount = moneyAmount - money - Math.round(moneyAmount * 0.01);
        }
    }
}
