package smart_home.command;

import smart_home.smartHome.GenericElectricDevice;

public class OffCommand extends SmartHomeCommand {
    public OffCommand(GenericElectricDevice device) {
        super(device);
    }

    @Override
    public void execute() {
        System.out.println("----------------------------------------------");
        GenericElectricDevice device = (GenericElectricDevice) this.device;
        device.setOnOffStatus(Boolean.FALSE);
        System.out.println(device);
        System.out.println("----------------------------------------------");
    }
}
