public class Client {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Product product1 = new Product("Product 1", 10.0, 2);
        Product product2 = new Product("Product 2", 20.0, 1);
        cart.addProduct(product1);
        cart.addProduct(product2);

        double totalPrice = cart.calculateTotalPrice();
        System.out.println("Total price: $" + totalPrice);

        PaymentStrategy paymentStrategy = new CreditCardPayment("1234-5678-9876-5432", "N S", "10/3", "123");

        cart.checkout(paymentStrategy);
    }
}
