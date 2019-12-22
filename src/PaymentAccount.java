public class PaymentAccount {
    protected double moneyAmount;

    PaymentAccount(double money){
        moneyAmount = money;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void putMoney(double money){
        moneyAmount += money;
    }

    public void withdrawMoney(double money){
        if(moneyAmount < money){
            System.out.println("Недостаточно средств на счету для продолжения операции.");
        }
        else {
            moneyAmount -= money;
        }
    }


}
