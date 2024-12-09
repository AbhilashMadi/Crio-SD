package patterns.statepattern.vending_machine;

import java.util.Map;

public class HasMoneyState implements State {
    private final VendingMachine machine;

    public HasMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney(int coin) {
        machine.setAmount(machine.getAmount() + coin);
        machine.setCurrentState(VendingState.HAS_MONEY);
    }

    @Override
    public void selectProduct(String product) {
        Map<String, Integer> priceMap = machine.getProductPriceMap();

        if (priceMap.containsKey(product)) {
            int price = priceMap.get(product);

            if (machine.getAmount() >= price) {
                System.out.println("Selected " + product);
                machine.setProductChoice(product);
                machine.setCurrentState(VendingState.DISPENSING);
            } else {
                machine.setCurrentState(VendingState.HAS_MONEY);
                System.out.println("Please insert more money.");
            }
        } else {
            System.out.println("Sorry, we don't have that product.");
        }
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product");
    }

    @Override
    public String toString(){
        return "HAS_MONEY";
    }
}
