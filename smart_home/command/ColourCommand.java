package smart_home.command;

import smart_home.exception.UnknownColorException;
import smart_home.smartHome.Light;

import java.util.List;
import java.util.Objects;

public class ColourCommand extends SmartHomeCommand {
    public ColourCommand(Light smartHomeDevice, String commandString) {
        super(smartHomeDevice, commandString);
    }

    @Override
    public void execute() {
        System.out.println("----------------------------------------------");
        Light light = (Light) this.device;
        try {
            light.setColor(commandString);
        } catch (UnknownColorException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------------------------------------------");
    }
}
