package cricket_score;

import java.util.ArrayList;
import java.util.List;

class ScoreBoard {
    short runs;
    byte wickets;

    public ScoreBoard(short runs, byte wickets) {
        this.runs = runs;
        this.wickets = wickets;
    }

    @Override
    public String toString() {
        return String.format("%s / %s", runs, wickets);
    }
}

abstract class Observer{
    protected CricketScoreSubject cricketScore;
    public abstract void update(ScoreBoard scoreBoard);
}

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

class CricketScoreSubject implements Subject{
    private ScoreBoard scoreBoard;
    private final List<Observer> observers = new ArrayList<>();

    public CricketScoreSubject() {
        this.scoreBoard = new ScoreBoard((short) 0, (byte) 0);
    }

    @Override
    public void attach(Observer observer){
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observers){
            observer.update(scoreBoard);
        }
    }

    public void addScoreBoard(ScoreBoard scoreBoard){
        this.scoreBoard = scoreBoard;
        notifyObservers();
    }
}

class Subscriber extends Observer {
    private final String name;

    public Subscriber(CricketScoreSubject cricketScoreSubject, String name){
        this.cricketScore = cricketScoreSubject;
        this.name = name;
    }

    @Override
    public void update(ScoreBoard scoreBoard){
        System.out.println(name + " -> " + scoreBoard);
    }
}

public class CricketScore {
    public static void main(String[] args) {
        CricketScoreSubject crickSub = new CricketScoreSubject();

        Subscriber sub1 = new Subscriber(crickSub, "Nawaz");
        Subscriber sub2 = new Subscriber(crickSub, "Abhilash");

        crickSub.attach(sub1);
        crickSub.attach(sub2);

        crickSub.addScoreBoard(new ScoreBoard((short) 100, (byte) 3));
        System.out.println();
        crickSub.addScoreBoard(new ScoreBoard((short) 300, (byte) 8));
    }
}
