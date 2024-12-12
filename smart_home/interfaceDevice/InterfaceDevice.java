package smart_home.interfaceDevice;

import home_auto_sys_raw.SmartHome.SmartHomeDevice;

import java.util.*;

public abstract class InterfaceDevice {
    String name;
    String location;
    String activationKey;
    Set<SmartHomeDevice> connectedSmartDevices = new HashSet<>();

    public InterfaceDevice(String name, String location, String activationKey) {
        this.name = name;
        this.location = location;
        this.activationKey = activationKey;
    }

    public List<SmartHomeDevice> getConnectedSmartDevices() {
        return connectedSmartDevices.stream().toList();
    }

    public void connectSmartDevice(SmartHomeDevice device) {
        connectedSmartDevices.add(device);
    }

    public void disConnectSmartDevice(SmartHomeDevice device) {
        connectedSmartDevices.remove(device);
    }

    @Override
    public String toString() {
        return "InterfaceDevice{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", activationKey='" + activationKey + '\'' +
                '}';
    }
}
