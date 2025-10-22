class Account {
    private int status
    private int id
    private String clientName
    private static double balance
    private MoneyUtils.Currency currency

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

    Account plus (double count, MoneyUtils.Currency currencyIncome = MoneyUtils.Currency.RUB) {
        println(">> Balance ${sprintf('%.2f',balance)} ${currency}, Income: ${sprintf('%.2f',count)} ${currencyIncome}")
        balance +=  MoneyUtils.convert(count, currencyIncome, currency)
        println(">> New balance: ${sprintf('%.2f',balance)} ${currency}")
        return this
    }

    boolean asBoolean() {
        return (status >= 0 && balance >= 0)  // status <0 for blocked or invalid accounts
    }

    String toString() {
        if (this) {
            return this.properties.toString()
        } else {
            return('Account is out of service!')
        }
    }

}