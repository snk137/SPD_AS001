import java.util.Scanner;

public class ShoppingCartDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Product product1 = new Product("Laptop", 800.0, 1);
        Product product2 = new Product("Mouse", 20.0, 2);

        cart.addProduct(product1);
        cart.addProduct(product2);

        System.out.println("Cart Contents:");
        for (Product product : cart.getProducts()) {
            System.out.println("Product: " + product.getName() + ", Quantity: " + product.getQuantity() +
                    ", Price per unit: $" + product.getPrice());
        }
        System.out.println("Total Price: $" + cart.calculateTotalPrice());

        System.out.println("Select a payment strategy:");
        System.out.println("1. Credit Card Payment");
        System.out.println("2. PayPal Payment");

        Scanner scanner = new Scanner(System.in);
        int paymentChoice = scanner.nextInt();

        PaymentStrategy paymentStrategy;
        switch (paymentChoice) {
            case 1:
                paymentStrategy = new CreditCardPayment("1234-5678-9876-5432", "John Doe", "12/25", "123");
                break;
            case 2:
                System.out.print("Enter PayPal email: ");
                String email = scanner.next();
                System.out.print("Enter PayPal password: ");
                String password = scanner.next();
                paymentStrategy = new PayPalPayment(email, password);
                break;
            default:
                System.out.println("Invalid choice. Using default payment strategy.");
                paymentStrategy = new CreditCardPayment("1234-5678-9876-5432", "John Doe", "12/25", "123");
        }

        cart.checkout(paymentStrategy);
    }
}
