package patterns.statepattern.vending_machine;

public class IdleState implements State{
    private final VendingMachine machine;

    public IdleState(VendingMachine machine){
        this.machine = machine;
    }

    @Override
    public void insertMoney(int coin){
        machine.setAmount(machine.getAmount() + coin);
        machine.setCurrentState(VendingState.HAS_MONEY);
    }

    @Override
    public void selectProduct(String product){
        System.out.println("Please insert a coin");
    }

    @Override
    public void dispenseProduct(){
        System.out.println("Please insert a coin");
    }

    @Override
    public String toString(){
        return "IDLE";
    }
}
