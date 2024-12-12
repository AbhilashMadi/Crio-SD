package home_auto_sys_raw.Interface;

public class InterfaceDeviceImpl implements InterfaceDeviceFactory {
    @Override
    public InterfaceDevice createInterfaceDevice(String name, String activationKeyword) {
        return switch (activationKeyword.toLowerCase()) {
            case "ok google" -> new GoogleHome(name, activationKeyword);
            case "alexa" -> new Alexa(name, activationKeyword);
            default ->
                    throw new IllegalArgumentException("Device not found with the action keyword: " + activationKeyword);
        };
    }
}
