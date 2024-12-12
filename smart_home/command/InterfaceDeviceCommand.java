package smart_home.command;

import home_auto_sys_raw.Interface.InterfaceDevice;

public abstract class InterfaceDeviceCommand implements Command {
    public InterfaceDeviceCommand(InterfaceDevice iDevice, String commandString) {}
}
