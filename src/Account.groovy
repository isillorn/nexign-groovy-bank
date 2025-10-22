class Account {
    private int status
    private int id
    private String clientName
    private double balance
    private MoneyUtils.Currency currency

    MoneyUtils.Currency getCurrency() {
        return currency
    }
    int getId() {
        return id
    }

    Account(String clientName, MoneyUtils.Currency currency = MoneyUtils.Currency.RUB, double balance = 0, int status = 0) {
        Random rnd = new Random()
        rnd.setSeed(new Date().getTime())
        this.id = rnd.nextInt(100000)
        this.clientName = clientName
        this.currency = currency
        this.status = status
        this.balance = balance
    }

    def plus (double count, MoneyUtils.Currency currencyIncome = MoneyUtils.Currency.RUB) {
        println(">> Balance [${id}] ${sprintf('%.2f',balance)} ${currency}; Income: ${sprintf('%.2f',count)} ${currencyIncome}")
        balance +=  MoneyUtils.convert(count, currencyIncome, currency)
        println(">> New balance [${id}]: ${sprintf('%.2f',balance)} ${currency}")
        return this
    }

    def minus (double count, MoneyUtils.Currency currencyOutcome = MoneyUtils.Currency.RUB) {
        if (balance >= MoneyUtils.convert(count, currencyOutcome, currency)) {
            println(">> Balance [${id}] ${sprintf('%.2f', balance)} ${currency}; Outcome: ${sprintf('%.2f', count)} ${currencyOutcome}")
            balance -= MoneyUtils.convert(count, currencyOutcome, currency)
            println(">> New balance [${id}] : ${sprintf('%.2f', balance)} ${currency}")
            return this
        } else {
            println(">> Error: Insufficient money! Balance: ${sprintf('%.2f', balance)} ${currency}")
            return null
        }
    }

    boolean asBoolean() {
        return (status >= 0 && balance >= 0)  // status <0 for blocked or invalid accounts
    }

    String toString() {
        if (this) {
            return "[Id:$id, Client:$clientName, Balance:${sprintf('%.2f',balance)} $currency]"
            //return this.properties.toString()
        } else {
            return("Account [$id] is out of service!")
        }
    }

}