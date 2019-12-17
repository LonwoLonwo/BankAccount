public class CardAccount extends PaymentAccount{
    private int moneyAmount;

    CardAccount(int money) {
        super(money);
        this.moneyAmount = money;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }
/*    @Override
    public void putMoney(int money) {
        super.putMoney(money);
    }*/

    @Override
    public void putMoney(int money) {
        moneyAmount += money;
    }

    @Override
    public void withdrawMoney(int money) {
        if(moneyAmount < (money + moneyAmount*0.01)){
            System.out.println("Недостаточно средств на счету для продолжения операции.");
        }
        else {
            moneyAmount = moneyAmount - money - (int) Math.round(moneyAmount * 0.01);
        }
    }
}
