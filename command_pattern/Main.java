package command_pattern;

import java.util.Stack;

class AddToCartCommand implements Command{
    @Override
    public void execute() {
        System.out.println("added to cart");
    }

    @Override
    public void unExecute(){
        System.out.println("removed from cart");
    }
}

class PaymentCommand implements Command{
    @Override
    public void execute(){
        System.out.println("do payment");
    }

    @Override
    public void unExecute() {
        System.out.println("undo payment");
    }
}

class CreateOrderCommand implements Command{
    @Override
    public void execute(){
        System.out.println("create order");
    }

    @Override
    public void unExecute(){
        System.out.println("cancel order");
    }
}

class SendToLogisticsCommand implements Command{
    @Override
    public void execute(){
        System.out.println("sent to logistics");
    }

    @Override
    public void unExecute(){
        System.out.println("canceled sending to logistics");
    }
}

class DispatchOrderCommand implements Command{
    @Override
    public void execute(){
        System.out.println("dispatched order");
    }

    @Override
    public void unExecute(){
        System.out.println("not dispatching order");
    }
}

class Invoker{
    private final Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void executeCommand(){
        this.command.execute();
    }

    public void unExecuteCommand(){
        this.command.unExecute();
    }
}

public class Main {
    public static void main(String[] args) {
        Stack<Command> commandHistory = new Stack<>();

        //if add to cart command is called
        Command cartCmd = new AddToCartCommand();
        Invoker cartInvoker = new Invoker(cartCmd);

        cartInvoker.executeCommand();
        commandHistory.add(cartCmd);


        //if payment method is called
        Command paymentCmd = new PaymentCommand();
        Invoker paymentInvoker = new Invoker(paymentCmd);

        paymentInvoker.executeCommand();
        commandHistory.push(paymentCmd);


        //if order api is called
        Command orderCmd = new CreateOrderCommand();
        Invoker orderInvoker = new Invoker(orderCmd);

        orderInvoker.executeCommand();
        commandHistory.push(orderCmd);


        //if send logistics api called
        Command logisticsCmd = new SendToLogisticsCommand();
        Invoker logisticsInvoker = new Invoker(logisticsCmd);

        logisticsInvoker.executeCommand();
        commandHistory.push(logisticsCmd);


        //if dispatch api is called
        Command dispatchCmd = new DispatchOrderCommand();
        Invoker dispatchInvoker = new Invoker(dispatchCmd);

        dispatchInvoker.executeCommand();
        commandHistory.push(dispatchCmd);



        // if we wanted to be rollback
        Command rollbackCmd = commandHistory.pop();
        Invoker invoker = new Invoker(rollbackCmd);
        invoker.unExecuteCommand();
    }
}


