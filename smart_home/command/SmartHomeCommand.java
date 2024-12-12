package smart_home.command;

import home_auto_sys_raw.SmartHome.SmartHomeDevice;

public abstract class SmartHomeCommand implements Command {
    SmartHomeDevice device;
    String commandString;

    public SmartHomeCommand(SmartHomeDevice device, String commandString){
        this.device = device;
        this.commandString = commandString;
    }

    public SmartHomeCommand(SmartHomeDevice device){
        this.device = device;
    }
}
