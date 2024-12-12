package smart_home.exception;

public class NonExistingInterfaceDeviceException extends Exception {
    public NonExistingInterfaceDeviceException(String activationKey) {
        super("No Such InterfaceDevice is present with activation key : " + activationKey);
    }
}