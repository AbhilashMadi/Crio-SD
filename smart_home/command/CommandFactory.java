package smart_home.command;

import home_auto_sys_raw.SmartHome.SmartHomeDevice;
import smart_home.exception.InvalidCommandException;
import smart_home.exception.UnknownCommandException;
import smart_home.smartHome.Fan;
import smart_home.smartHome.GenericElectricDevice;
import smart_home.smartHome.Light;

public class CommandFactory {

    public InterfaceDeviceCommand getSpecialCommand(String commandString) throws UnknownCommandException {
        if (commandString.equalsIgnoreCase("I am home")) {
            System.out.println("--" + commandString);
            System.out.println("You are welcome");
        } else if (commandString.equalsIgnoreCase("Leaving home")) {
            System.out.println("--" + commandString);
            System.out.println("go safe");
        } else if (commandString.equalsIgnoreCase("Good Night")) {
            System.out.println("--" + commandString);
            System.out.println("sweet dreams");
        }

        throw new UnknownCommandException(commandString);
    }

    public Command getCommand(SmartHomeDevice device, String commandString) throws UnknownCommandException, InvalidCommandException {
        if (commandString.equalsIgnoreCase("ON")) {
            if (device instanceof GenericElectricDevice)
                return new OnCommand((GenericElectricDevice) device);
            throw new InvalidCommandException();
        } else if (commandString.equalsIgnoreCase("OFF")) {
            if (device instanceof GenericElectricDevice)
                return new OffCommand((GenericElectricDevice) device);
            throw new InvalidCommandException();
        }
        try {
            Integer num = Integer.valueOf(commandString);
            if (device instanceof Light) {
                return new BrightnessCommand((Light) device, commandString);
            } else if (device instanceof Fan) {
                return new FanSpeedCommand((Fan) device, commandString);
            } else
                throw new UnknownCommandException(commandString);
        } catch (Exception e) {
            if (device instanceof Light) {
                return new ColourCommand((Light) device, commandString);
            }
            throw new UnknownCommandException(commandString);
        }
    }
}