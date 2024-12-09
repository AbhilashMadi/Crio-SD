package patterns.statepattern.vending_machine;

public class TestDriver {

    public static void main(String[] args){
        VendingMachine machine = new VendingMachine();

        machine.addProduct("Coke", 10);
        machine.addProduct("Pepsi", 15);

        //test insert money and select product
        machine.insertMoney(5);
        System.out.println(machine.getCurrentState());
        machine.selectProduct("Coke");
        System.out.println(machine.getCurrentState());
        machine.dispenseProduct();
    }
}
