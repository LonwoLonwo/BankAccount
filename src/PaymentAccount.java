public class PaymentAccount {
    private int moneyAmount;

    public PaymentAccount(int money){
        moneyAmount = money;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void putMoney(int money){
        if(moneyAmount < money){
            System.out.println("Недостаточно средств на счету для продолжения операции.");
        }
        else {
            moneyAmount += money;
        }
    }

    public void withdrawMoney(int money){
        moneyAmount -= money;
    }


}
