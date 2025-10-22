class Bank {
    private clientAccounts = []

    int addAccount(Account account) {
        clientAccounts.add(account)
        return account.getId()
    }

    def getAccountById(int id) {
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
        println("===== ACCOUNTS =====")
        for (acc in clientAccounts) {
            println(acc)
        }
        println("====================")
    }


    boolean transferMoney(double count, Account fromAccount, Account toAccount) {
        boolean result = false
        if (fromAccount.minus(count,fromAccount.getCurrency())) {
            println(">> Transferring ${sprintf('%.2f',count)} ${fromAccount.getCurrency()} from [${fromAccount.getId()}] to [${toAccount.getId()}]")
            toAccount.plus(count,fromAccount.getCurrency())
            result = true
        } else {
            println(">> Error: Cannot transfer money!")
        }
        return result
    }

    boolean withdrawMoney(double count, Account fromAccount, MoneyUtils.Currency currency = MoneyUtils.Currency.RUB) {
        boolean result = false
        if (fromAccount.minus(count,currency)) {
            println(">> The money was successfully withdrawn: ${sprintf('%.2f',count)} ${currency} from [${fromAccount.getId()}]")
            result = true
        } else {
            println(">> Error: Cannot withdraw money!")
        }
        return result
    }

    boolean depositMoney(double count, Account toAccount, MoneyUtils.Currency currency = MoneyUtils.Currency.RUB) {
    }

}
