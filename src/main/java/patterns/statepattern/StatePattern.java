package patterns.statepattern;

interface State{
    void handleRequest();
}

class RedlightState implements State{
    public void handleRequest(){
        System.out.println("Red...");
    }
}

class GreenlightState implements State{
    public void handleRequest(){
        System.out.println("Green...");
    }
}

class YellowlightState implements State{
    public void handleRequest(){
        System.out.println("Yellow...");
    }
}

class Trafficking {
    public State currentState;

    public Trafficking(State state){
        this.currentState = state;
    }

    public void handleRequest(){
        currentState.handleRequest();
    }
}

public class StatePattern {
    public static void main(String[] args){
        Trafficking red = new Trafficking(new RedlightState());
        Trafficking green = new Trafficking(new GreenlightState());
        Trafficking yellow = new Trafficking(new YellowlightState());

        red.handleRequest();
        green.handleRequest();
        yellow.handleRequest();
    }
}
