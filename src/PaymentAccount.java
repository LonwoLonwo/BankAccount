public class PaymentAccount {

    private int moneyAmount;

    public PaymentAccount(int moneyAmount){
        this.moneyAmount = moneyAmount;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void putMoney(int money){
        moneyAmount += money;
    }

    public void withdrawMoney(int money){
        moneyAmount -= money;
    }


}
