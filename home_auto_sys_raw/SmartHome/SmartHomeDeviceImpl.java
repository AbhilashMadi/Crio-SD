package home_auto_sys_raw.SmartHome;

public class SmartHomeDeviceImpl implements SmartHomeDeviceFactory {
    @Override
    public SmartHomeDevice createSmartHomeDevice(String deiceType) {
        return switch (deiceType.toLowerCase()) {
            case "fan" -> new Fan();
            case "light" -> new Light();
            default -> throw new IllegalArgumentException("Unknown SmartHome Device type: " + deiceType);
        };
    }
}
