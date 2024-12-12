package home_auto_sys_raw.Interface;

import home_auto_sys_raw.SmartHome.SmartHomeDevice;

public interface InterfaceDevice {
    void sendCommand(SmartHomeDevice device, String command);
    void receiveResponse(String response);
    String getActivationKeyword();
    String getName();
}
