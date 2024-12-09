package patterns.statepattern.vending_machine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine implements State{
    private State currentState;
    private int amount;
    private String choice;
    private final Map<String, Integer> productPriceMap;

    public VendingMachine() {
        this.currentState = new IdleState(this);
        this.amount = 0;
        this.choice = null;
        this.productPriceMap = new HashMap<>();
    }

    public void addProduct(String product, int price) {
        productPriceMap.put(product, price);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProductChoice(){
        return choice;
    }

    public void setProductChoice(String choice){
        this.choice = choice;
    }

    public Map<String, Integer> getProductPriceMap(){
        return productPriceMap;
    }

    public void setCurrentState(VendingState stage){
        switch (stage){
            case IDLE:
                currentState = new IdleState(this);
                break;
            case HAS_MONEY:
                currentState = new HasMoneyState(this);
                break;
            case DISPENSING:
                currentState = new DispenseState(this);
                break;
            default:
                throw  new IllegalArgumentException("Unknown state provided");
        }
    }

    public State getCurrentState(){
        return currentState;
    }

    @Override
    public void insertMoney(int coin){
        currentState.insertMoney(coin);
    }

    @Override
    public void selectProduct(String product){
        currentState.selectProduct(product);
    }

    @Override
    public void dispenseProduct(){
        currentState.dispenseProduct();
    }
}
