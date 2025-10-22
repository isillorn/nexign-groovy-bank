//println(MoneyUtils.Currency.EUR)
//MoneyUtils.setRate(MoneyUtils.Currency.RUB, 0.1)
//MoneyUtils.convert(5,MoneyUtils.Currency.USD,MoneyUtils.Currency.RUB)
println("===== Current rates: ${MoneyUtils.getAllRates()}")


bank = new Bank()
id1 = bank.addAccount(new Account("Vasya Pupkin", MoneyUtils.Currency.RUB, 1))
id2 = bank.addAccount(new Account("Fedor Petroff", MoneyUtils.Currency.EUR, 100))
id3 = bank.addAccount(new Account("Fedor Petroff", MoneyUtils.Currency.EUR, -1))
//println("$id1 $id2")
bank.printAccounts()
bank.transferMoney(10, bank.getAccountById(id2), bank.getAccountById(id1))
bank.printAccounts()
bank.withdrawMoney(5, bank.getAccountById(id1), MoneyUtils.Currency.USD)
bank.printAccounts()

//def x = account.plus(12, MoneyUtils.Currency.USD)

