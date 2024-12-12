package smart_home.exception;

public class NotPossibleBrigtnessException extends Exception {
    public NotPossibleBrigtnessException(Integer brightness) {
        super("Can't able to set the brightness to : " + brightness.toString());
    }
}