class Bank {
    private Account[] clientAccounts = []

    void addAccount(Account account) {
        clientAccounts.add(account)
    }

    def findAccountById(int id) {
        def result = null
        for (acc in clientAccounts) {
            if (acc.getId() == id) {
                result = acc
                break
            }
        }
        return result
    }

    void printAccounts() {
        for (acc in clientAccounts) {
            println(acc)
        }
    }

    boolean transferMoney(double count, Account fromAccount, Account toAccount) {
    }

    boolean withdrawMoney(double count, Account fromAccount, MoneyUtils.Currency currency = MoneyUtils.Currency.RUB) {
    }

    boolean depositMoney(double count, Account toAccount, MoneyUtils.Currency currency = MoneyUtils.Currency.RUB) {
    }

}
