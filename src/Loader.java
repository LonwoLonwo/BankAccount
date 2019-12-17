public class Loader {
    public static void main(String[] args) {
        DepositAccount dAccount = new DepositAccount(4000, "01.10.2019");
        dAccount.putMoney(4000, "01.11.2019");

        dAccount.withdrawMoney(2000);
        System.out.println(dAccount.getMoneyAmount());

        dAccount.putMoney(3000, "01.12.2019");
        dAccount.withdrawMoney(2000);
        System.out.println(dAccount.getMoneyAmount());

        CardAccount cAccount = new CardAccount(15000);
        System.out.println(cAccount.getMoneyAmount());
        cAccount.putMoney(3000);
        cAccount.withdrawMoney(1000);
        System.out.println(cAccount.getMoneyAmount());

        PaymentAccount pAccount = new PaymentAccount(1111);
        pAccount.putMoney(222);
        System.out.println(pAccount.getMoneyAmount());
    }
}
