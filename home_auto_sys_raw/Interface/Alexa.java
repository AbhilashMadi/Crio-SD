package home_auto_sys_raw.Interface;

import home_auto_sys_raw.SmartHome.SmartHomeDevice;

public class Alexa implements InterfaceDevice {
    private final String name;
    private final String activationKeyword;

    public Alexa(String name, String activationKeyword) {
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
        System.out.println(name + " sending command: " + command);

        if ("on".equalsIgnoreCase(command)) {
//            device.turnOn();
        } else if ("off".equalsIgnoreCase(command)) {
//            device.turnOff();
        } else {
            throw new IllegalArgumentException("Invalid command");
        }
    }

    @Override
    public void receiveResponse(String response) {
        System.out.println(name + " received response: " + response);
    }
}
