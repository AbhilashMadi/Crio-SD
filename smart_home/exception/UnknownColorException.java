package smart_home.exception;


public class UnknownColorException extends Exception {
    public UnknownColorException(String colour) {
        super("Unknown Color to set :- " + colour);
    }
}
