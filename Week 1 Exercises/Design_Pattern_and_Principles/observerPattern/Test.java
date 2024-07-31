package observerPattern;

public class Test {
    public static void main(String[] args) {
        // Create a stock market
        StockMarket stockMarket = new StockMarket("TechCorp", 150.00);

        // Create observers
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Update stock price
        stockMarket.setStockPrice(155.00);  // This should notify all registered observers
        stockMarket.setStockPrice(160.00);  // This should notify all registered observers

        // Deregister an observer
        stockMarket.deregisterObserver(mobileApp);

        // Update stock price
        stockMarket.setStockPrice(165.00);  // Only WebApp should receive this update
    }

}
