public class CardAccount extends PaymentAccount{
    private int moneyAmount;

    public CardAccount(int moneyAmount) {
        super(moneyAmount);
        this.moneyAmount = moneyAmount;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    @Override
    public void putMoney(int money) {
        moneyAmount += money;
    }

    @Override
    public void withdrawMoney(int money) {
        moneyAmount = moneyAmount - money - (int)Math.round(moneyAmount*0.01);
    }
}
