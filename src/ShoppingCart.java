import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;
    private PaymentProcessor paymentProcessor;

    public ShoppingCart() {
        this.products = new ArrayList<>();
        this.paymentProcessor = new PaymentProcessor();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }

    public void checkout(PaymentStrategy paymentStrategy) {
        double totalPrice = calculateTotalPrice();
        System.out.println("Total price: $" + totalPrice);

        paymentProcessor.processPayment(totalPrice, paymentStrategy);
    }

    public List<Product> getProducts() {
        return products;
    }
}
