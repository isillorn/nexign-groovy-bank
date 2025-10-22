class MoneyUtils {
    enum Currency {
        //enum Currency { USD(1.0), EUR(1.16), RUB(0.012) }
        USD('USD'), EUR('EUR'), RUB('RUB')

        private String name
        Currency(String name) {
            this.name = name
        }
        @Override
        String toString() {
            return this.name
        }
    }

    private static currencyRates = [
            // default rates
            (Currency.USD): 1.00,
            (Currency.EUR): 1.16,
            (Currency.RUB): 0.012
    ]

    static setRate(Currency currency, double rate) {
        currencyRates.put(currency, rate)
    }

    static double getRate(Currency currency) {
        return currencyRates.get(currency)
    }

    static String getAllRates() {
        return currencyRates
    }

    static double convert(double count, Currency fromCurrency, Currency toCurrency = Currency.RUB) {
        double result
        if (fromCurrency != toCurrency) {
            result = count * getRate(fromCurrency) / getRate(toCurrency)
            println("[conversion: ${sprintf('%.2f',count)} ${fromCurrency} -> ${sprintf('%.2f',result)} ${toCurrency}]") // TEST
        } else {
            result = count
        }
        return result
    }
}