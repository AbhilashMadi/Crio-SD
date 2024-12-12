package home_auto_sys_raw.Interface;

import home_auto_sys_raw.SmartHome.SmartHomeDevice;

public class GoogleHome implements InterfaceDevice {
    private final String name;
    private final String activationKeyword;

    public GoogleHome(String name, String activationKeyword) {
        this.name = name;
        this.activationKeyword = activationKeyword;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getActivationKeyword() {
        return activationKeyword;
    }

    @Override
    public void sendCommand(SmartHomeDevice device, String command) {
        System.out.println(name + " received command: " + command);

        if ("off".equalsIgnoreCase(command)) {
            device.turnOff();
        } else if ("on".equalsIgnoreCase(command)) {
            device.turnOn();
        } else {
            throw new IllegalArgumentException("Unknown command sent: " + command);
        }
    }

    @Override
    public void receiveResponse(String response){
        System.out.println(name + " received response: " + response);
    }
}
