package patterns.statepattern.vending_machine;

import java.util.Map;

public class DispenseState implements State {
    private final VendingMachine machine;

    public DispenseState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney(int coin) {
        System.out.println("Please insert a coin");
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("Please select a product");
    }

    @Override
    public void dispenseProduct() {
        String choice = machine.getProductChoice();

        if (choice != null) {
            Map<String, Integer> priceMap = machine.getProductPriceMap();
            int price = priceMap.get(choice);
            int amount = machine.getAmount();

            if (amount >= price) {
                System.out.println("Dispensing " + choice);
                machine.setAmount(amount - price);
                machine.setCurrentState(VendingState.IDLE);
            } else {
                System.out.println("Please insert more money.");
                machine.setCurrentState(VendingState.HAS_MONEY);
            }
        } else {
            System.out.println("Please select a product");
        }
    }

    @Override
    public String toString(){
        return "DISPENSE";
    }
}
