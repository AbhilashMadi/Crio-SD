package patterns.statepattern.vending_machine;

public interface State {
    void insertMoney(int coin);
    void selectProduct(String product);
    void dispenseProduct();
}
