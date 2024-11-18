package solid.ocp.after_refactor;

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

interface PricingStrategy {
    double calculatePrice(List<Item> items);
}

class DefaultPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(List<Item> items) {
        double total = 0.0;

        for (Item item : items) {
            total += item.getPrice();
        }

        return total;
    }

}

class DiscountPricingStrategy implements PricingStrategy {
    private final double discount;

    public DiscountPricingStrategy(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculatePrice(List<Item> items) {
        double total = items.stream()
                .mapToDouble(Item::getPrice)
                .sum();
        double discountAmt = (total * discount) / 100;
        return total - discount;
    }
}

class TaxPricingStrategy implements PricingStrategy {
    private final double taxRate;

    public TaxPricingStrategy(double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public double calculatePrice(List<Item> items) {
        double total = items.stream()
                .mapToDouble(Item::getPrice)
                .sum();

        double taxAmt = (total * taxRate) / 100;
        return total + taxAmt;
    }
}

public class ShoppingCart {
    private final List<Item> items;
    private PricingStrategy strategy;

    public ShoppingCart(PricingStrategy strategy) {
        this.items = new ArrayList<>();
        this.strategy = strategy;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double calculateTotal() {
        return strategy.calculatePrice(items);
    }

    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new DefaultPricingStrategy());

        cart.addItem(new Item("A", 500));
        cart.addItem(new Item("B", 1_000));

        System.out.printf("Total: %.2f\n", cart.calculateTotal());

        cart.setStrategy(new DiscountPricingStrategy(10));
        System.out.printf("Total (with Discount): %.2f\n", cart.calculateTotal());

        cart.setStrategy(new TaxPricingStrategy(15));
        System.out.printf("Total (with Tax): %.2f\n", cart.calculateTotal());
    }
}
