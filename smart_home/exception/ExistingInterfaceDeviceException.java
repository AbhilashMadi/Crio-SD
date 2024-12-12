package smart_home.exception;

public class ExistingInterfaceDeviceException extends Exception {
    public ExistingInterfaceDeviceException(String activationKey) {
        super("Already InterfaceDevice is present with activation Key : " + activationKey);
    }
}