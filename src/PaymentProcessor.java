public class PaymentProcessor {
    public void processPayment(double amount, PaymentStrategy paymentStrategy) {
        paymentStrategy.processPayment(amount);
    }
}
