package solid.ocp.before_refactor;

import java.util.ArrayList;
import java.util.List;

class Item {
    private final String name;
    private final double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public double calculatePriceAfterDiscount(double discountPercent) {
        double total = calculateTotal();

        return total - (total * discountPercent / 100);
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem(new Item("A", 10_000));
        shoppingCart.addItem(new Item("B", 20_000));

        System.out.printf("Total price: %.2f\n", shoppingCart.calculateTotal());
        System.out.printf("Price after discount: %.2f ", shoppingCart.calculatePriceAfterDiscount(10));
    }
}
