package smart_home.exception;

public class InvalidCommandException extends Exception {
    public InvalidCommandException() {
        super("Invalid Command Exception to the device");
    }
}