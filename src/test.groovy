//println(MoneyUtils.Currency.EUR)
//MoneyUtils.setRate(MoneyUtils.Currency.RUB, 0.1)
println("===== Current rates: ${MoneyUtils.getAllRates()}")
//MoneyUtils.convert(5,MoneyUtils.Currency.USD,MoneyUtils.Currency.RUB)

bank = new Bank()
account = new Account("Vasya Pupkin", MoneyUtils.Currency.RUB, 1)


def x = account.plus(12, MoneyUtils.Currency.USD)

println