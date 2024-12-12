package smart_home.command;

import smart_home.exception.UnknownFanSpeedException;
import smart_home.smartHome.Fan;

public class FanSpeedCommand extends SmartHomeCommand {
    public FanSpeedCommand(Fan smartHomeDevice, String commandString) {
        super(smartHomeDevice, commandString);
    }

    @Override
    public void execute() {
        System.out.println("----------------------------------------------");
        Fan fan = (Fan) this.device;

        try {
            fan.setFanSpeed(Integer.valueOf(commandString));
        } catch (UnknownFanSpeedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------------------------------------------");
    }
}